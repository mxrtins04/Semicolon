package data.repository;

import data.model.Transaction;
import data.model.TransactionType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository {
    void save(Transaction transaction);
    Optional<Transaction> findByTransactionId(String transactionId);
    List<Transaction> findByAccountNumber(String accountNumber);
    List<Transaction> findByAccountNumberAndType(String accountNumber, TransactionType type);
    List<Transaction> findByDateRange(LocalDateTime start, LocalDateTime end);
    List<Transaction> findAll();
    List<Transaction> findByStatus(data.model.TransactionStatus status);
    void delete(String transactionId);
    boolean exists(String transactionId);
    int count();
}
