package src.model;

import java.util.ArrayList;

public class Account {
    private User user;
    private int balance;
    private String name;
    private String password;
    private String bvn;
    private Bank bank;
    private String accountNumber;
    private ArrayList<Transaction> transactions;


    public Account(Bank bank, User user) {
        this.bank = bank;
        this.user = user;
        this.balance = 0;
    }


    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public String getName(){
       return this.user.getName();
    }

    public int getBalance(){
        return this.balance;
    }

    public void debit(int amount){
        if (amount > this.balance || amount <= 0) {
            throw new IllegalArgumentException("Amount must be less than balance and positive");
        }
        this.balance -= amount;
    }


    public void credit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.balance += amount;
    }



    
 
    

}
