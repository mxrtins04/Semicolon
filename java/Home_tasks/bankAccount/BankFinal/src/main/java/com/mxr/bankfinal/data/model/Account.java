package com.mxr.bankfinal.data.model;

import com.mxr.bankfinal.data.repository.UserRepository;

public class Account {
    private User user;
    private int balance;
    private String name;
    private String password;
    private String email;
    private String accountNumber;
    private final UserRepository userRepository;

    public Account(String name, String email,String password, UserRepository userRepository) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.userRepository = userRepository;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public int deposit(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Invalid Amount");
        balance += amount;
        return balance;
    }

    public String getBvn(){
        User user = this.userRepository.findByEmail(this.email);
        if (user == null) return null;
        
        return user.getBvn();
    }

    public int withdraw(int amount) {
        if (amount > balance) throw new IllegalArgumentException("insufficient funds");
        else if (amount < 0) throw new IllegalArgumentException("Invalid Amount");
        return balance = balance - amount;
    }


    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
