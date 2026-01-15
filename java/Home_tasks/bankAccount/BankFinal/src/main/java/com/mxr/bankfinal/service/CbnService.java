package com.mxr.bankfinal.service;

import com.mxr.bankfinal.data.model.Bank;
import com.mxr.bankfinal.data.model.BankCode;
import com.mxr.bankfinal.data.model.Cbn;
import com.mxr.bankfinal.data.model.Transaction;
import com.mxr.bankfinal.data.repository.AccountRepository;
import com.mxr.bankfinal.data.repository.BankRepository;
import com.mxr.bankfinal.data.repository.impl.AccountRepositoryImpl;
import com.mxr.bankfinal.data.repository.impl.BankRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class CbnService {
    private final BankRepository bankRepository;
    private final TransactionService transactionService;
    private final List<String> bankCodes;
    private final Cbn cbn;

    public CbnService(BankRepository bankRepository, TransactionService transactionService) {
        this.bankRepository = bankRepository;
        this.transactionService = transactionService;
        this.bankCodes = new ArrayList<>();
        this.cbn = new Cbn(bankRepository, transactionService);
    }

    public void registerBank(String bankCode) {
        if (!validateBank(bankCode)) {
            throw new IllegalArgumentException("Invalid bank code: " + bankCode);
        }
        
        if (bankRepository.exists(bankCode)) {
            throw new IllegalArgumentException("Bank already registered: " + bankCode);
        }
        
        cbn.registerBank(bankCode);
        bankCodes.add(bankCode);
    }

    
    private BankService findBankService(String bankCode) {
        Bank bank = bankRepository.findByCode(bankCode);
        return bank != null ? bank.getBankService() : null;
    }

    private boolean hasBankService(String bankCode) {
        return findBankService(bankCode) != null;
    }

    public BankService getBankService(String bankCode) {
        return findBankService(bankCode);
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
        if (bank == null) {
            return null;
        }
        return bank.getName();
    }

    public List<String> getAllBankCodes() {
        return new ArrayList<>(bankCodes);
    }

    public AccountRepository getBankAccountRepository(String bankCode) {
        Bank bank = bankRepository.findByCode(bankCode);
        if (bank == null) {
            throw new IllegalArgumentException("Bank not found: " + bankCode);
        }

        return bank.getAccountRepository();
    }

    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    public Bank findBank(String bankCode) {
        return bankRepository.findByCode(bankCode);
    }

    public BankCode[] getAvailableBankCodes() {
        return cbn.getBankCodes();
    }

    private boolean isInterBankTransfer(String fromBankCode, String toBankCode) {
        return !fromBankCode.equals(toBankCode);
    }

    public TransactionService getTransactionService() {
        return transactionService;
    }
}