package com.mxr.bankfinal.data.repository.impl;

import com.mxr.bankfinal.data.model.Account;
import com.mxr.bankfinal.data.repository.AccountRepository;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    private final List<Account> accounts = new ArrayList<>();

    @Override
    public void save(Account account) {
        accounts.add(account);
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {
        return accounts.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Account> findByEmail(String email) {
        return accounts.stream()
                .filter(account -> account.getEmail().equals(email))
                .toList();
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accounts);
    }

    @Override
    public void delete(String accountNumber) {
        accounts.removeIf(account -> account.getAccountNumber().equals(accountNumber));
    }

    @Override
    public boolean exists(String accountNumber) {
        return accounts.stream()
                .anyMatch(account -> account.getAccountNumber().equals(accountNumber));
    }

    @Override
    public int count() {
        return accounts.size();
    }
}
