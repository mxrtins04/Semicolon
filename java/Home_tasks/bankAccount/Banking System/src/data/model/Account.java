import validateInsufficientAmountException;
import validateNegativeAmountException;

package data.model;
public class Account {
    private int balance;
    private String name;
    private String password;
    private 
    private int accountNumber;

    public Account(String name, String email,String password,int accountNumber) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.accountNumber = accountNumber;
    }


    public int getBalance() {
        return balance;
    }

    public int deposit(int amount) {
        validateNegativeAmount(amount);
        balance += amount;
        return balance;

    }
    private void validateNegativeAmount(int amount) {
        if (amount < 0) throw new validateNegativeAmountException("Invalid Amount");
    }

    public int withdraw(int amount) {
        if (amount > balance) throw new validateInsufficientAmountException("insufficient funds");
        else if (amount < 0) throw new validateNegativeAmountException("Invalid Amount");
        return balance = balance  - amount ;

    }


}
