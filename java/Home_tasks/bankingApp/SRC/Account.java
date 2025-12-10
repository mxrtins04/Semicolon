
public class Account {
    private int balance;
    private String name;
    private String password;
    private int accountNumber;


    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }



    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }




    public int getBalance(String password) {
        validatePassword(password);
       return balance;
    }

    public void deposit(int amount) {
        validate(amount);
        balance+=amount;
    }
    private  void validate(int amount) {
        if (amount < 0) throw new validateAmount("Invalid amount");
    }

    public void withdraw(int amount, String password) {
        validate(amount);
        validateAmountAboveBalance(amount);
        validatePassword(password);
        balance-=amount;
    }

    private void validateAmountAboveBalance(int amount) {
        if (amount > balance) throw new validateAmount("Insufficient balance");
    }

    private void validatePassword(String password) {
        if (!this.password.equals(password)) {
            throw new validatePasswordException("WRONG PASSWORD");
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
