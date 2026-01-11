package service;

import data.model.Transaction;
import java.util.List;
import java.util.Map;

public class CbnService {
    private final data.repository.BankRepository bankRepository;
    private final TransactionService transactionService;
    private final Map<String, BankService> bankServices;

    public CbnService(data.repository.BankRepository bankRepository, 
                     TransactionService transactionService) {
        this.bankRepository = bankRepository;
        this.transactionService = transactionService;
        this.bankServices = new java.util.HashMap<>();
    }

    public void registerBankService(String bankCode, BankService bankService) {
        bankServices.put(bankCode, bankService);
    }

    public Transaction transfer(String fromBankCode, String fromAccount, 
                              String toBankCode, String toAccount, 
                              double amount, String description) {
        // Validate banks
        if (!validateBank(fromBankCode) || !validateBank(toBankCode)) {
            throw new IllegalArgumentException("Invalid bank code(s)");
        }

        // Validate accounts
        if (!validateAccount(fromBankCode, fromAccount) || !validateAccount(toBankCode, toAccount)) {
            throw new IllegalArgumentException("Invalid account number(s)");
        }

        // Get bank services
        BankService fromBankService = bankServices.get(fromBankCode);
        BankService toBankService = bankServices.get(toBankCode);

        if (fromBankService == null || toBankService == null) {
            throw new IllegalArgumentException("Bank services not registered");
        }

        // Check sufficient funds
        if (fromBankService.getBalance(fromAccount) < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        // Perform transfer
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
        return data.model.BankCode.fromCode(bankCode) != null;
    }

    public boolean validateAccount(String bankCode, String accountNumber) {
        BankService bankService = bankServices.get(bankCode);
        return bankService != null && bankService.accountExists(accountNumber);
    }

    public String getBankName(String bankCode) {
        data.model.BankCode bank = data.model.BankCode.fromCode(bankCode);
        return bank != null ? bank.getName() : null;
    }

    public List<String> getAllBankCodes() {
        return java.util.Arrays.stream(data.model.BankCode.getAllCodes())
                .map(data.model.BankCode::getCode)
                .collect(java.util.stream.Collectors.toList());
    }

    private boolean isInterBankTransfer(String fromBankCode, String toBankCode) {
        return !fromBankCode.equals(toBankCode);
    }
}
