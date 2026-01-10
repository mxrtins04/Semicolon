package com.mxr.mfds.repository;

import com.mxr.mfds.model.Transaction;

import java.util.List;

public interface TransactionRepository {

    Transaction save(Transaction transaction);

    List<Transaction> findAll();
}
