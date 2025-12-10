import java.util.ArrayList;

public class BankingSystem {
    private int accountNumbers;
    private Account newMember;

    public ArrayList<Account> accountList = new ArrayList<>();



    public int getAccounts(){
        return accountNumbers;
    }


    public int createAccount(String name,String password) {
        newMember = new Account(name,password);
        newMember.setAccountNumber(++accountNumbers);
        accountList.add(newMember);
      return  newMember.getAccountNumber();
    }

    public void deposit(int amount, int accountNumber) { findAccount(accountNumber).deposit(amount);}

    private   Account findAccount( int accountNumber) {
        return accountList.get(accountNumber-1)
                ;}

    public void withDraw(String password,int accountNumber,int amount) {
        findAccount(accountNumber).withdraw(amount,password);
    }


    public void Transfer(int sender, int receiver, int amount,String passwordOfSender) {
        verifyAccountNumber(sender);
        verifyAccountNumber(receiver);
        withDraw(passwordOfSender,sender,amount);
        deposit(amount,receiver);
    }

    public int checkBalance(int accountNumbers,String password) {
        return findAccount(accountNumbers).getBalance( password);
    }
    private void verifyAccountNumber( int accountNumber){
        if(accountNumber<0|accountNumber>accountNumbers){
            throw new validateAccount("ENTER A VALID ACCOUNT NUMBER!");
        }

    }

    public String mainMenu(){
        return """
                WELCOME TO FIRST BANK!
                
                
                HOW MAY WE BE OF SERVICE??
                
                1.CREATE ACCOUNT
                2.WITHDRAW FROM ACCOUNT
                3.DEPOSIT FROM ACCOUNT
                4.TRANSFER TO ANOTHER ACCOUNT
                
                """;
    }


}


