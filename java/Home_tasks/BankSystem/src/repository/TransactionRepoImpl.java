package repository;

import model.Transaction;
import repository.TransactionRepo;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionRepoImpl implements TransactionRepo {
    private Map<String, Transaction> transactions = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public Transaction save(Transaction transaction) {
        if (transaction.getId() == null) {
            transaction.setId(currentId++);
        }
        transactions.put(transaction.getReferenceNumber(), transaction);
        return transaction;
    }

    @Override
    public Optional<Transaction> findByReference(String reference) {
        return Optional.ofNullable(transactions.get(reference));
    }

    @Override
    public List<Transaction> findByAccountNumber(String accountNumber) {
        return transactions.values().stream().filter(txn -> accountNumber.equals(txn.getSourceAccountNumber()) || accountNumber.equals(txn.getDestinationAccountNumber())).collect(Collectors.toList());
    }

    @Override
    public List<Transaction> findAll() {
        return new ArrayList<>(transactions.values());
    }

}