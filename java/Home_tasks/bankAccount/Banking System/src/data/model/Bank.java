package data.model;
import java.util.ArrayList;

public class Bank {
    private String name;
    private String email;
    private String password;
    private Account newAccount;
    ArrayList<Account> accounts = new ArrayList<>();
    private int accountNumber;



    public Bank(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getAccount() {
        return accountNumber;
    }


    public void createAccount(String name, String email, String password) {
         newAccount = new Account(name,email,password,accountNumber++);
         accounts.add(newAccount);


    }
    private Account findAccount(int accountNumber){
        if(accountNumber < 1 || accountNumber>accounts.size()){
            throw new IllegalArgumentException("Invalid account number");
        }
        return accounts.get(accountNumber-1);

    };
    public void deposit(int accountNo,int amount) {
        if(amount<1){
            throw new IllegalArgumentException("Insufficient amount");
        }
        findAccount(accountNo).deposit(amount);
    }

    public int getBalance(int accountNo) {
         return findAccount(accountNo).getBalance();
    }

    public void withdraw(int amount, int accountNo) {

        findAccount(accountNo).withdraw(amount);
        System.out.println(accountNo + " withdraw " + amount);
    }
           
    public void transfer(int amount, int accountFrom, int accountTo) {
            if(amount<1){
                throw new IllegalArgumentException("Insufficient amount");
            }
           Account from = findAccount(accountFrom);
           Account to = findAccount(accountTo);
           from.withdraw(amount);
           to.deposit(amount);

    }


}













