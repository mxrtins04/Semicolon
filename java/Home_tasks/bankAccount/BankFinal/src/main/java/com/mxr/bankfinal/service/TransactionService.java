package com.mxr.bankfinal.service;
import com.mxr.bankfinal.data.model.Transaction;
import com.mxr.bankfinal.data.model.TransactionStatus;
import com.mxr.bankfinal.data.model.TransactionType;
import com.mxr.bankfinal.data.model.Receipt;
import com.mxr.bankfinal.data.repository.AccountRepository;
import com.mxr.bankfinal.data.repository.TransactionRepository;

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
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, accountNumber, amount, description);
        transactionRepository.save(transaction);
        
        return transaction;
    }

    public Receipt createDepositWithReceipt(String accountNumber, double amount, String description, String bankName) {
        if (accountRepository.findByAccountNumber(accountNumber) == null) {
            throw new IllegalArgumentException("Account not found: " + accountNumber);
        }
        Transaction transaction = createDeposit(accountNumber, amount, description);
        return receiptService.generateReceipt(transaction, bankName);
    }

    public Transaction createWithdrawal(String accountNumber, double amount, String description) {
        Transaction transaction = new Transaction(TransactionType.WITHDRAWAL, accountNumber, amount, description);
        transactionRepository.save(transaction);
        
        return transaction;
    }

    public Receipt createWithdrawalWithReceipt(String accountNumber, double amount, String description, String bankName) {
        if (accountRepository.findByAccountNumber(accountNumber) == null) {
            throw new IllegalArgumentException("Account not found: " + accountNumber);
        }
        Transaction transaction = createWithdrawal(accountNumber, amount, description);
        return receiptService.generateReceipt(transaction, bankName);
    }

    public Transaction createTransfer(String fromAccount, String toAccount, double amount, String description) {
        Transaction transaction = new Transaction(TransactionType.TRANSFER, fromAccount, toAccount, amount, description);
        transactionRepository.save(transaction);
        
        return transaction;
    }

    public Receipt createTransferWithReceipt(String fromAccount, String toAccount, double amount, String description, String bankName) {
        if (accountRepository.findByAccountNumber(fromAccount) == null) {
            throw new IllegalArgumentException("Account not found: " + fromAccount);
        }
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
