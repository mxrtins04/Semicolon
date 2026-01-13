package com.mxr.bankfinal.service;

import com.mxr.bankfinal.data.model.BankCode;
import com.mxr.bankfinal.data.model.Transaction;
import com.mxr.bankfinal.data.repository.BankRepository;

import java.util.ArrayList;
import java.util.List;

public class CbnService {
    private final BankRepository bankRepository;
    private final TransactionService transactionService;
    private final List<BankService> bankServices;
    private final List<String> bankCodes;

    public CbnService(BankRepository bankRepository, TransactionService transactionService) {
        this.bankRepository = bankRepository;
        this.transactionService = transactionService;
        this.bankServices = new ArrayList<>();
        this.bankCodes = new ArrayList<>();
    }

    public void registerBankService(String bankCode, BankService bankService) {
        int index = bankCodes.indexOf(bankCode);
        if (index == -1) {
            bankCodes.add(bankCode);
            bankServices.add(bankService);
        } else {
            bankServices.set(index, bankService);
        }
    }

    private BankService findBankService(String bankCode) {
        for (int i = 0; i < bankCodes.size(); i++) {
            if (bankCodes.get(i).equals(bankCode)) {
                return bankServices.get(i);
            }
        }
        return null;
    }

    private boolean hasBankService(String bankCode) {
        return bankCodes.contains(bankCode);
    }

    public Transaction transfer(String fromBankCode, String fromAccount,
                                String toBankCode, String toAccount,
                                double amount, String description) {
        if (!validateBank(fromBankCode) || !validateBank(toBankCode)) {
            throw new IllegalArgumentException("Invalid bank code(s)");
        }

        if (!hasBankService(fromBankCode) || !hasBankService(toBankCode)) {
            throw new IllegalArgumentException("Bank service not registered");
        }

        if (!validateAccount(fromBankCode, fromAccount) || !validateAccount(toBankCode, toAccount)) {
            throw new IllegalArgumentException("Invalid account number(s)");
        }

        BankService fromBankService = findBankService(fromBankCode);
        BankService toBankService = findBankService(toBankCode);

        if (fromBankService.getBalance(fromAccount) < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        try {
            fromBankService.withdraw(fromAccount, amount);
            toBankService.deposit(toAccount, amount);

            String fullDescription = isInterBankTransfer(fromBankCode, toBankCode)
                    ? String.format("%s (Inter-bank: %s->%s)", description, fromBankCode, toBankCode)
                    : String.format("%s (Intra-bank: %s)", description, fromBankCode);

            Transaction transaction = transactionService.createTransfer(
                    fromAccount, toAccount, amount, fullDescription);
            transactionService.completeTransaction(transaction.getTransactionId());

            return transaction;

        } catch (Exception e) {
            throw new RuntimeException("Transfer failed: " + e.getMessage());
        }
    }

    public boolean validateBank(String bankCode) {
        return BankCode.fromCode(bankCode) != null;
    }

    public boolean validateAccount(String bankCode, String accountNumber) {
        BankService service = findBankService(bankCode);
        return service != null && service.accountExists(accountNumber);
    }

    public String getBankName(String bankCode) {
        BankCode bank = BankCode.fromCode(bankCode);
        return bank != null ? bank.getName() : null;
    }

    public List<String> getAllBankCodes() {
        return new ArrayList<>(bankCodes);
    }

    private boolean isInterBankTransfer(String fromBankCode, String toBankCode) {
        return !fromBankCode.equals(toBankCode);
    }
}