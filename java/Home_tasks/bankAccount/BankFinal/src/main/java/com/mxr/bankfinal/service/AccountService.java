package com.mxr.bankfinal.service;

import com.mxr.bankfinal.data.model.Account;
import com.mxr.bankfinal.data.model.User;
import com.mxr.bankfinal.data.repository.AccountRepository;
import com.mxr.bankfinal.data.repository.UserRepository;
import com.mxr.bankfinal.util.NubanGenerator;
import com.mxr.bankfinal.data.repository.TransactionRepository;

import java.util.List;

public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final String bankCode;
    private final TransactionRepository transactionRepository;

    public AccountService(String bankCode, AccountRepository accountRepository, UserRepository userRepository, TransactionRepository transactionRepository) {
        this.bankCode = bankCode;
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }


    public Account findAccount(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found: " + accountNumber);
        }
        return account;
    }

    public Account updateAccount(String accountNumber, String name, String email) {
        Account account = findAccount(accountNumber);
        
        if (name != null && !name.trim().isEmpty()) {
            account.setName(name);
        }
        
        if (email != null && !email.trim().isEmpty() && !email.equals(account.getEmail())) {
            User user = userRepository.findByEmail(email);
            if (user == null) {
                throw new IllegalArgumentException("User not found with new email: " + email);
            }
            account.setEmail(email);
            account.setUser(user);
        }
        
        return account;
    }

    public void deleteAccount(String accountNumber) {
        Account account = findAccount(accountNumber);
        accountRepository.delete(accountNumber);
    }

    public double getAccountBalance(String accountNumber) {
        Account account = findAccount(accountNumber);
        return account.getBalance();
    }

    public List<com.mxr.bankfinal.data.model.Transaction> getAccountTransactions(String accountNumber) {
        findAccount(accountNumber); 
        return transactionRepository.findByAccountNumber(accountNumber); 
    }

    public void linkToUser(String accountNumber, String userEmail) {
        Account account = findAccount(accountNumber);
        User user = userRepository.findByEmail(userEmail);
        
        if (user == null) {
            throw new IllegalArgumentException("User not found with email: " + userEmail);
        }
        
        account.setUser(user);
        account.setEmail(userEmail);
    }

    public boolean validateAccount(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        return account != null;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public boolean accountExists(String accountNumber) {
        return accountRepository.exists(accountNumber);
    }

    public int getAccountCount() {
        return accountRepository.count();
    }

    public List<Account> findAccountsByEmail(String email) {
        return accountRepository.findByEmail(email);
    }



    public String getBankCode() {
        return bankCode;
    }
}
