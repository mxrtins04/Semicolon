package com.mxr.bankfinal.service;
import com.mxr.bankfinal.data.model.Account;
import com.mxr.bankfinal.NubanGenerator.NubanGenerator;
import com.mxr.bankfinal.data.model.Transaction;
import com.mxr.bankfinal.data.repository.impl.AccountRepositoryImpl;

import java.util.List;

public class BankService {
    private final com.mxr.bankfinal.data.repository.impl.AccountRepositoryImpl accountRepository;
    private final TransactionService transactionService;
    private final String bankCode;

    public BankService(String bankCode, AccountRepositoryImpl accountRepository, TransactionService transactionService) {
        this.bankCode = bankCode;
        this.accountRepository = accountRepository;
        this.transactionService = transactionService;
    }

    public Account createAccount(String name, String email, String password) {
        String nubanAccountNumber = NubanGenerator.generateNuban(bankCode);
        Account newAccount = new Account(name, email, password);
        newAccount.setAccountNumber(nubanAccountNumber);
        accountRepository.save(newAccount);
        
        transactionService.createDeposit(nubanAccountNumber, 0.0, "Account created");
        return newAccount;
    }

    public Account findAccount(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found: " + accountNumber);
        }
        return account;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public void deposit(String accountNumber, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found: " + accountNumber);
        }

        account.deposit((int) amount);
        
        Transaction transaction = transactionService.createDeposit(accountNumber, amount, "Deposit");
        transactionService.completeTransaction(transaction.getTransactionId());
    }

    public void withdraw(String accountNumber, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found: " + accountNumber);
        }
        
        if (account.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        
        account.withdraw((int) amount);
        
        Transaction transaction = transactionService.createWithdrawal(accountNumber, amount, "Withdrawal");
        transactionService.completeTransaction(transaction.getTransactionId());
    }

    public double getBalance(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found: " + accountNumber);
        }
        return account.getBalance();
    }

    public boolean accountExists(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber) != null;
    }

    public int getAccountCount() {
        return accountRepository.findAll().size();
    }

    public String getBankCode() {
        return bankCode;
    }
}
