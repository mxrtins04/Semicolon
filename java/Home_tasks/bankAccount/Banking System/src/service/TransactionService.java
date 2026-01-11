package service;

import data.model.Transaction;
import data.model.TransactionStatus;
import data.model.TransactionType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TransactionService {
    private final data.repository.TransactionRepository transactionRepository;

    public TransactionService(data.repository.TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createDeposit(String accountNumber, double amount, String description) {
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, accountNumber, amount, description);
        transactionRepository.save(transaction);
        return transaction;
    }

    public Transaction createWithdrawal(String accountNumber, double amount, String description) {
        Transaction transaction = new Transaction(TransactionType.WITHDRAWAL, accountNumber, amount, description);
        transactionRepository.save(transaction);
        return transaction;
    }

    public Transaction createTransfer(String fromAccount, String toAccount, double amount, String description) {
        Transaction transaction = new Transaction(TransactionType.TRANSFER, fromAccount, toAccount, amount, description);
        transactionRepository.save(transaction);
        return transaction;
    }

    public Optional<Transaction> findByTransactionId(String transactionId) {
        return transactionRepository.findByTransactionId(transactionId);
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
        Optional<Transaction> transactionOpt = transactionRepository.findByTransactionId(transactionId);
        if (transactionOpt.isPresent()) {
            transactionOpt.get().complete();
        }
    }

    public void failTransaction(String transactionId) {
        Optional<Transaction> transactionOpt = transactionRepository.findByTransactionId(transactionId);
        if (transactionOpt.isPresent()) {
            transactionOpt.get().fail();
        }
    }
}
