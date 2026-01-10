package com.mxr.mfds.repository;

import com.mxr.mfds.model.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryTransactionRepository implements TransactionRepository {

    private final List<Transaction> store = new ArrayList<>();

    @Override
    public Transaction save(Transaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null");
        }

        store.add(transaction);
        return transaction;
    }

    @Override
    public List<Transaction> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(store));
    }
}
