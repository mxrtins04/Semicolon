package com.mxr.bankfinal.service;

import com.mxr.bankfinal.data.model.Account;
import com.mxr.bankfinal.data.model.User;
import com.mxr.bankfinal.data.repository.AccountRepository;
import com.mxr.bankfinal.data.repository.UserRepository;
import com.mxr.bankfinal.util.NubanGenerator;

import java.util.List;

public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final String bankCode;

    public AccountService(String bankCode, AccountRepository accountRepository, UserRepository userRepository) {
        this.bankCode = bankCode;
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public Account createAccount(String name, String email, String password) {
        
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("User not found with email: " + email);
        }

        // Generate unique account number
        String accountNumber = generateUniqueAccountNumber();
        
        // Create account
        Account account = new Account(name, email, password, userRepository);
        account.setAccountNumber(accountNumber);
        
        // Save account
        accountRepository.save(account);
        
        return account;
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
        
        // Update fields if provided
        if (name != null && !name.trim().isEmpty()) {
            // Note: Account doesn't have setName method, so this would need to be added
            // account.setName(name);
        }
        
        if (email != null && !email.trim().isEmpty() && !email.equals(account.getEmail())) {
            // Validate new email exists in user repository
            User user = userRepository.findByEmail(email);
            if (user == null) {
                throw new IllegalArgumentException("User not found with new email: " + email);
            }
            // Note: Account doesn't have setEmail method, so this would need to be added
            // account.setEmail(email);
        }
        
        return account;
    }

    public void deleteAccount(String accountNumber) {
        Account account = findAccount(accountNumber);
        accountRepository.delete(accountNumber);
    }

    public int getAccountBalance(String accountNumber) {
        Account account = findAccount(accountNumber);
        return account.getBalance();
    }

    public List<Account> getAccountTransactions(String accountNumber) {
        findAccount(accountNumber); // Validate account exists
        return accountRepository.findByEmail(accountNumber); // This might need adjustment based on requirements
    }

    public void linkToUser(String accountNumber, String userEmail) {
        Account account = findAccount(accountNumber);
        User user = userRepository.findByEmail(userEmail);
        
        if (user == null) {
            throw new IllegalArgumentException("User not found with email: " + userEmail);
        }
        
        // Note: Account doesn't have setUser method, so this would need to be added
        // account.setUser(user);
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

    private String generateUniqueAccountNumber() {
        String accountNumber;
        int attempts = 0;
        final int MAX_ATTEMPTS = 100;
        
        do {
            accountNumber = NubanGenerator.generateNuban(bankCode);
            attempts++;
            
            if (attempts > MAX_ATTEMPTS) {
                throw new RuntimeException("Failed to generate unique account number after " + MAX_ATTEMPTS + " attempts");
            }
        } while (accountRepository.exists(accountNumber));
        
        return accountNumber;
    }

    public String getBankCode() {
        return bankCode;
    }
}
