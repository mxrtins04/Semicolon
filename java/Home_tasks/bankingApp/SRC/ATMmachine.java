import java.lang.classfile.instruction.SwitchCase;
import java.util.Arrays;
import java.util.Scanner;

public class ATMmachine {
    static void main(String[] args) {
        BankingSystem firstBank =  new BankingSystem();
        Scanner input = new Scanner(System.in);
        while(true){
            IO.print(firstBank.mainMenu());
            IO.print("ENTER AN INPUT ");
            String mainMenu = input.nextLine();
            switch (mainMenu) {
                case "1"->{
                    IO.print("ENTER  YOUR NAME ");
                    String name = input.nextLine();

                    IO.println("");
                    IO.print("ENTER YOUR PASSWORD ");
                    String password = input.nextLine();
                    IO.println("WELCOME TO FIRST BANK "+name+" THIS IS YOUR ACCOUNT NUMBER "+ firstBank.createAccount(name,password));
                }
                case "2"-> {
                    while (true) {
                        IO.println("WELCOME TO THE WITHDRAW TERMINAL!");
                        IO.print(" ");
                        IO.print("ENTER YOUR ACCOUNT NUMBER ");
                        int accountNumber = input.nextInt();
                        IO.println("HOW MUCH DO YOU WAN TO WITHDRAW?");
                        int amount = input.nextInt();
                        IO.print("ENTER YOUR ACCOUNT PASSWORD");
                        String password = input.nextLine();
                        try {
                            firstBank.withDraw(password, accountNumber, amount);
                            IO.println("TRANSACTION SUCCESSFUL!");
                            break;
                        } catch (validateAmount | validatePasswordException | validateAccount |
                                 validateAmountAboveBalance e) {
                            IO.println(e.getMessage());
                        }
                    }
                }
                case "3"-> {
                    while (true) {
                        IO.println("WELCOME TO DEPOSIT TERMINAL!");
                        IO.println("");
                        IO.print("ENTER YOUR ACCOUNT NUMBER ");
                        int accountNumber = input.nextInt();
                        IO.println("ENTER AN AMOUNT");
                        int amount = input.nextInt();
                        try {
                            firstBank.deposit(amount,accountNumber);
                            IO.println("TRANSACTION SUCCESSFUL!");
                            break;
                        } catch (validateAmount |validateAccount e) {
                            IO.println(e.getMessage());
                        }
                    }
                }
                case "4"->{
                    while (true) {


                        IO.println("WELCOME TO THE TRANSFER TERMINAL");
                        IO.println("");
                        IO.println("ENTER THE ACCOUNT NUMBER OF THE SENDER");
                        int sender = input.nextInt();
                        IO.println("HOW MUCH DO YOU WANT TO SEND?");
                        int amount = input.nextInt();
                        IO.println("ENTER THE ACCOUNT NUMBER OF THE RECEIVER");
                        int receiver = input.nextInt();
                        IO.println("ENTER YOUR PASWORD TO AUTHORIZE THE TRANSACTION");
                        String password = input.nextLine();
                        try {
                            firstBank.Transfer(sender, receiver, amount, password);
                            IO.println("TRANSACTION SUCCESSFUL!");
                            break;
                        } catch (validateAmount | validatePasswordException | validateAmountAboveBalance |
                                 validateAccount e) {
                            IO.println(e.getMessage());
                        }
                    }
                }
                case "5"->{
                    IO.println("CHECK BALANCE");
                    IO.println("");
                    IO.println("ENTER YOUR ACCOUNT NUMBER!");
                    int accountNumber = input.nextInt();
                    IO.println("ENTER ACCOUNT PASSWORD");
                    String password = input.nextLine();
                    try{
                        firstBank.checkBalance(accountNumber,password);
                    }
                    catch (validateAccount e){
                        IO.println(e.getMessage());
                    }
                }
            }

        }
    }
}
