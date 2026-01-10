import java.util.Scanner;

import data.model.Bank;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("Stanbic Bank", "info@bank.com", "admin123");

        while (true) {

            String options = """
                    1===== STANBIC BANK PLC MENU =====
                    1. Create Account
                    2. Deposit
                    3. Withdraw
                    4. Transfer
                    5. Check Balance
                    6. Exit
                    """;

            System.out.println(options);
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    bank.createAccount(name, email, password);
                    System.out.println("Account created! Your account number is: " + bank.getAccount());
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int accDeposit = scanner.nextInt();

                    System.out.print("Enter deposit amount: ");
                    int depAmount = scanner.nextInt();

                    bank.deposit(accDeposit, depAmount);
                    System.out.println("Deposit successful!");
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int accWithdraw = scanner.nextInt();

                    System.out.print("Enter withdrawal amount: ");
                    int withAmount = scanner.nextInt();

                    try {
                        bank.withdraw(withAmount, accWithdraw);
                        System.out.println("Withdrawal successful!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter source account number: ");
                    int from = scanner.nextInt();

                    System.out.print("Enter destination account number: ");
                    int to = scanner.nextInt();

                    System.out.print("Enter transfer amount: ");
                    int transAmount = scanner.nextInt();

                    try {
                        bank.transfer(transAmount, from, to);
                        System.out.println("Transfer successful!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    int accBalance = scanner.nextInt();

                    try {
                        int balance = bank.getBalance(accBalance);
                        System.out.println("Balance: " + balance);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
