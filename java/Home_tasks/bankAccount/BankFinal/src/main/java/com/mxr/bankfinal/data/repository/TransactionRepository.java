package com.mxr.bankfinal.data.repository;
import com.mxr.bankfinal.data.model.Transaction;
import com.mxr.bankfinal.data.model.TransactionType;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository {
    void save(Transaction transaction);
    Transaction findByTransactionId(String transactionId);
    List<Transaction> findByAccountNumber(String accountNumber);
    List<Transaction> findByAccountNumberAndType(String accountNumber, TransactionType type);
    List<Transaction> findByDateRange(LocalDateTime start, LocalDateTime end);
    List<Transaction> findAll();
    List<Transaction> findByStatus(com.mxr.bankfinal.data.model.TransactionStatus status);
    void delete(String transactionId);
    boolean exists(String transactionId);
    int count();
}
