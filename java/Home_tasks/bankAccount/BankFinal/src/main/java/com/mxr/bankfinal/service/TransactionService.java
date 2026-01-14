package com.mxr.bankfinal.service;
import com.mxr.bankfinal.data.model.Transaction;
import com.mxr.bankfinal.data.model.TransactionStatus;
import com.mxr.bankfinal.data.model.TransactionType;
import com.mxr.bankfinal.data.model.Receipt;
import com.mxr.bankfinal.data.repository.AccountRepository;
import com.mxr.bankfinal.data.repository.TransactionRepository;
import com.mxr.bankfinal.data.model.Account;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionService {
    private final com.mxr.bankfinal.data.repository.TransactionRepository transactionRepository;
    private final ReceiptService receiptService;
    private final AccountRepository accountRepository;

    public TransactionService(TransactionRepository transactionRepository, ReceiptService receiptService, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.receiptService = receiptService;
        this.accountRepository = accountRepository;
    }

    public Transaction createDeposit(String accountNumber, double amount, String description) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found: " + accountNumber);
        }
        account.deposit(amount);
        accountRepository.save(account);
        
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, accountNumber, amount, description);
        transaction.complete();
        transactionRepository.save(transaction);
        
        return transaction;
    }

    public Receipt createDepositWithReceipt(String accountNumber, double amount, String description, String bankName) {
        Transaction transaction = createDeposit(accountNumber, amount, description);
        return receiptService.generateReceipt(transaction, bankName);
    }

    public Transaction createWithdrawal(String accountNumber, double amount, String description) {

        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found: " + accountNumber);
        }
        
        if (account.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds in account: " + accountNumber);
        }

        account.withdraw(amount);
        accountRepository.save(account);
        
        Transaction transaction = new Transaction(TransactionType.WITHDRAWAL, accountNumber, amount, description);
        transaction.complete();
        transactionRepository.save(transaction);
        
        return transaction;
    }

    public Receipt createWithdrawalWithReceipt(String accountNumber, double amount, String description, String bankName) {
        Transaction transaction = createWithdrawal(accountNumber, amount, description);
        return receiptService.generateReceipt(transaction, bankName);
    }

    public Transaction createTransfer(String fromAccount, String toAccount, double amount, String description) {
        Account fromAcc = accountRepository.findByAccountNumber(fromAccount);
        Account toAcc = accountRepository.findByAccountNumber(toAccount);
        
        if (fromAcc == null) {
            throw new IllegalArgumentException("From account not found: " + fromAccount);
        }
        if (toAcc == null) {
            throw new IllegalArgumentException("To account not found: " + toAccount);
        }
        
        if (fromAcc.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds in account: " + fromAccount);
        }
        

        fromAcc.withdraw(amount);
        toAcc.deposit(amount);
        

        accountRepository.save(fromAcc);
        accountRepository.save(toAcc);
        

        Transaction transaction = new Transaction(TransactionType.TRANSFER, fromAccount, toAccount, amount, description);
        transaction.complete();
        transactionRepository.save(transaction);
        
        return transaction;
    }

    public Receipt createTransferWithReceipt(String fromAccount, String toAccount, double amount, String description, String bankName) {
        Transaction transaction = createTransfer(fromAccount, toAccount, amount, description);
        return receiptService.generateReceipt(transaction, bankName);
    }

    public Transaction findTransactionById(String transactionId) {
        Transaction transaction = transactionRepository.findByTransactionId(transactionId);
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction not found: " + transactionId);
        }
        return transaction;
    }

    public List<Transaction> getAccountTransactions(String accountNumber) {
        return transactionRepository.findByAccountNumber(accountNumber);
    }

    public List<Transaction> getTransactionsByType(String accountNumber, TransactionType type) {
        return transactionRepository.findByAccountNumberAndType(accountNumber, type);
    }

    public List<Transaction> getTransactionsByDateRange(LocalDateTime start, LocalDateTime end) {
        return transactionRepository.findByDateRange(start, end);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public void completeTransaction(String transactionId) {
        Transaction transaction = findTransactionById(transactionId);
        transaction.complete();
    }

    public void failTransaction(String transactionId) {
        Transaction transaction = findTransactionById(transactionId);
        transaction.fail();
    }

    public Receipt getReceiptForTransaction(String transactionId, String bankName) {
        Transaction transaction = findTransactionById(transactionId);
        return receiptService.generateReceipt(transaction, bankName);
    }

    public void printReceipt(String transactionId, String bankName) {
        Receipt receipt = getReceiptForTransaction(transactionId, bankName);
        receiptService.printReceipt(receipt);
    }

}
