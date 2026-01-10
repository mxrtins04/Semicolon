package repository;

import model.Transaction;
import java.util.List;
import java.util.Optional;

public interface TransactionRepo {
    Transaction save(Transaction transaction);
    Optional<Transaction> findByReference(String reference);
    List<Transaction> findByAccountNumber(String accountNumber);
    List<Transaction> findAll();
}