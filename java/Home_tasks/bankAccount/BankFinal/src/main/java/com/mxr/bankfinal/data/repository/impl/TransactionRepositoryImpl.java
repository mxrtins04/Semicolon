package com.mxr.bankfinal.data.repository.impl;
import com.mxr.bankfinal.data.model.Transaction;
import com.mxr.bankfinal.data.model.TransactionStatus;
import com.mxr.bankfinal.data.model.TransactionType;
import com.mxr.bankfinal.data.repository.TransactionRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionRepositoryImpl implements TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void save(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public Transaction findByTransactionId(String transactionId) {
        return transactions.stream()
                .filter(transaction -> transaction.getTransactionId().equals(transactionId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Transaction> findByAccountNumber(String accountNumber) {
        return transactions.stream()
                .filter(transaction -> {
                    return transaction.getFromAccount().equals(accountNumber) || 
                           transaction.getToAccount().equals(accountNumber);
                })
                .toList();
    }

    @Override
    public List<Transaction> findByAccountNumberAndType(String accountNumber, TransactionType type) {
        return transactions.stream()
                .filter(transaction -> transaction.getType() == type)
                .filter(transaction -> {
                    return transaction.getFromAccount().equals(accountNumber) || 
                           transaction.getToAccount().equals(accountNumber);
                })
                .toList();
    }

    @Override
    public List<Transaction> findByDateRange(LocalDateTime start, LocalDateTime end) {
        return transactions.stream()
                .filter(transaction -> !transaction.getTimestamp().isBefore(start) &&
                                   !transaction.getTimestamp().isAfter(end))
                .toList();
    }

    @Override
    public List<Transaction> findAll() {
        return new ArrayList<>(transactions);
    }

    @Override
    public List<Transaction> findByStatus(TransactionStatus status) {
        return transactions.stream()
                .filter(transaction -> transaction.getStatus() == status)
                .toList();
    }

    @Override
    public void delete(String transactionId) {
        transactions.removeIf(transaction -> transaction.getTransactionId().equals(transactionId));
    }

    @Override
    public boolean exists(String transactionId) {
        return transactions.stream()
                .anyMatch(transaction -> transaction.getTransactionId().equals(transactionId));
    }

    @Override
    public int count() {
        return transactions.size();
    }
}
