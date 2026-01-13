package com.mxr.bankfinal.data.model;
public class Account {
    private User user;
    private int balance;
    private String name;
    private String password;
    private String email;
    private String accountNumber;

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

    public int getBalance() {
        return balance;
    }

    public int deposit(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Invalid Amount");
        balance += amount;
        return balance;
    }

    public String getBvn(){
        String  Bvn = this.user.getBvn();
        return Bvn;
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
