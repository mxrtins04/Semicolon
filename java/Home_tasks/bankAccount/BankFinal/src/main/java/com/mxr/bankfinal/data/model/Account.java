package com.mxr.bankfinal.data.model;

import com.mxr.bankfinal.data.repository.UserRepository;


public class Account {
    private User user;
    private double balance;
    private String name;
    private String password;
    private String email;
    private String accountNumber;
    private UserRepository userRepository;

    public Account(String name, String email,String password) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Invalid Amount");
        balance += amount;
        return balance;
    }

    public String getBvn(){
        User user = this.userRepository.findByEmail(this.email);
        if (user == null) return null;
        
        return user.getBvn();
    }

    public double withdraw(double amount) {
        if (amount > balance) throw new IllegalArgumentException("insufficient funds");
        else if (amount < 0) throw new IllegalArgumentException("Invalid Amount");
        return balance = balance - amount;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
