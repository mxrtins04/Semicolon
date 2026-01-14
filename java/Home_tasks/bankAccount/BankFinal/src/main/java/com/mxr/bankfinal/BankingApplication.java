package com.mxr.bankfinal;

import com.mxr.bankfinal.data.model.*;
import com.mxr.bankfinal.data.repository.*;
import com.mxr.bankfinal.data.repository.impl.*;
import com.mxr.bankfinal.service.*;

import java.util.Scanner;

public class BankingApplication {
    private final UserService userService;
    private final CbnService cbnService;
    private final ReceiptService receiptService;
    private final TransactionRepository transactionRepository;
    private final Scanner scanner;

    public BankingApplication() {
        UserRepository userRepository = new UserRepositoryImpl();
        BankRepository bankRepository = new BankRepositoryImpl();
        this.transactionRepository = new TransactionRepositoryImpl();
        
        this.userService = new UserService(userRepository);
        this.receiptService = new ReceiptService(new AccountRepositoryImpl());
        this.cbnService = new CbnService(bankRepository, new TransactionService(transactionRepository, receiptService, new AccountRepositoryImpl()));
        this.scanner = new Scanner(System.in);
        
        initializeSampleData();
    }

    public static void main(String[] args) {
        BankingApplication app = new BankingApplication();
        app.run();     
    }

    private void run() {
        System.out.println("=== Banking System CLI ===");
        System.out.println("Welcome to the Nigerian Banking System");
        
        while (true) {
            printMainMenu();
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    handleUserOperations();
                    break;
                case "2":
                    handleAccountOperations();
                    break;
                case "3":
                    handleTransactionOperations();
                    break;
                case "4":
                    handleBankOperations();
                    break;
                case "5":
                    System.out.println("Thank you for using Banking System CLI. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }

    private void printMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. User Operations");
        System.out.println("2. Account Operations");
        System.out.println("3. Transaction Operations");
        System.out.println("4. Bank Operations");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void handleUserOperations() {
        System.out.println("\n=== User Operations ===");
        System.out.println("1. Create User");
        System.out.println("2. Find User by BVN");
        System.out.println("3. Find User by Email");
        System.out.println("4. List All Users");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice: ");
        
        String choice = scanner.nextLine().trim();
        
        switch (choice) {
            case "1":
                createUser();
                break;
            case "2":
                findUserByBvn();
                break;
            case "3":
                findUserByEmail();
                break;
            case "4":
                listAllUsers();
                break;
            case "5":
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void handleAccountOperations() {
        System.out.println("\n=== Account Operations ===");
        System.out.println("1. Create Account");
        System.out.println("2. Find Account");
        System.out.println("3. Check Balance");
        System.out.println("4. List All Accounts");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice: ");
        
        String choice = scanner.nextLine().trim();
        
        switch (choice) {
            case "1":
                createAccount();
                break;
            case "2":
                findAccount();
                break;
            case "3":
                checkBalance();
                break;
            case "4":
                listAllAccounts();
                break;
            case "5":
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void handleTransactionOperations() {
        System.out.println("\n=== Transaction Operations ===");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. View Account Transactions");
        System.out.println("5. Print Receipt");
        System.out.println("6. Back to Main Menu");
        System.out.print("Enter your choice: ");
        
        String choice = scanner.nextLine().trim();
        
        switch (choice) {
            case "1":
                handleDeposit();
                break;
            case "2":
                handleWithdrawal();
                break;
            case "3":
                handleTransfer();
                break;
            case "4":
                viewAccountTransactions();
                break;
            case "5":
                printReceipt();
                break;
            case "6":
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void handleBankOperations() {
        System.out.println("\n=== Bank Operations ===");
        System.out.println("1. List All Banks");
        System.out.println("2. Find Bank by Code");
        System.out.println("3. Register New Bank");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice: ");
        
        String choice = scanner.nextLine().trim();
        
        switch (choice) {
            case "1":
                listAllBanks();
                break;
            case "2":
                findBankByCode();
                break;
            case "3":
                registerBank();
                break;
            case "4":
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void createUser() {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();
        
        try {
            User user = userService.createUser(name, email);
            System.out.println("User created successfully!");
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("BVN: " + user.getBvn());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void findUserByBvn() {
        System.out.print("Enter BVN: ");
        String bvn = scanner.nextLine().trim();
        
        User user = userService.findByBvn(bvn);
        if (user != null) {
            System.out.println("User found:");
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("BVN: " + user.getBvn());
        } else {
            System.out.println("User not found with BVN: " + bvn);
        }
    }

    private void findUserByEmail() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();
        
        User user = userService.findByEmail(email);
        if (user != null) {
            System.out.println("User found:");
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("BVN: " + user.getBvn());
        } else {
            System.out.println("User not found with email: " + email);
        }
    }

    private void listAllUsers() {
        var users = userService.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("All Users:");
            for (User user : users) {
                System.out.println("Name: " + user.getName() + ", Email: " + user.getEmail() + ", BVN: " + user.getBvn());
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();
        System.out.print("Enter bank code (e.g., 044 for Access Bank): ");
        String bankCode = scanner.nextLine().trim();
        
        try {
            AccountRepository accountRepo = cbnService.getBankAccountRepository(bankCode);
            AccountService accountService = new AccountService(bankCode, accountRepo, 
                userService.getUserRepository(), transactionRepository);
            
            Account account = accountService.createAccount(name, email, password);
            System.out.println("Account created successfully!");
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Name: " + account.getName());
            System.out.println("Email: " + account.getEmail());
            System.out.println("Bank: " + cbnService.getBankName(bankCode));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void findAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.print("Enter bank code: ");
        String bankCode = scanner.nextLine().trim();
        
        try {
            AccountRepository accountRepo = cbnService.getBankAccountRepository(bankCode);
            Account account = accountRepo.findByAccountNumber(accountNumber);
            
            if (account != null) {
                System.out.println("Account found:");
                System.out.println("Account Number: " + account.getAccountNumber());
                System.out.println("Name: " + account.getName());
                System.out.println("Email: " + account.getEmail());
                System.out.println("Balance: " + account.getBalance());
            } else {
                System.out.println("Account not found.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void checkBalance() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.print("Enter bank code: ");
        String bankCode = scanner.nextLine().trim();
        
        try {
            AccountRepository accountRepo = cbnService.getBankAccountRepository(bankCode);
            AccountService accountService = new AccountService(bankCode, accountRepo, 
                userService.getUserRepository(), transactionRepository);
            
            double balance = accountService.getAccountBalance(accountNumber);
            System.out.println("Account Balance: " + balance);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listAllAccounts() {
        System.out.print("Enter bank code: ");
        String bankCode = scanner.nextLine().trim();
        
        try {
            AccountRepository accountRepo = cbnService.getBankAccountRepository(bankCode);
            var accounts = accountRepo.findAll();
            
            if (accounts.isEmpty()) {
                System.out.println("No accounts found for this bank.");
            } else {
                System.out.println("All Accounts for " + cbnService.getBankName(bankCode) + ":");
                for (Account account : accounts) {
                    System.out.println("Account Number: " + account.getAccountNumber() + 
                                     ", Name: " + account.getName() + 
                                     ", Balance: " + account.getBalance());
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void handleDeposit() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Enter description: ");
        String description = scanner.nextLine().trim();
        System.out.print("Enter bank code: ");
        String bankCode = scanner.nextLine().trim();
        
        try {
            TransactionService transactionService = cbnService.getTransactionService();
            Receipt receipt = transactionService.createDepositWithReceipt(accountNumber, amount, description, 
                cbnService.getBankName(bankCode));
            
            System.out.println("Deposit successful!");
            receiptService.printReceipt(receipt);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void handleWithdrawal() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Enter description: ");
        String description = scanner.nextLine().trim();
        System.out.print("Enter bank code: ");
        String bankCode = scanner.nextLine().trim();
        
        try {
            TransactionService transactionService = cbnService.getTransactionService();
            Receipt receipt = transactionService.createWithdrawalWithReceipt(accountNumber, amount, description, 
                cbnService.getBankName(bankCode));
            
            System.out.println("Withdrawal successful!");
            receiptService.printReceipt(receipt);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void handleTransfer() {
        System.out.print("Enter from account number: ");
        String fromAccount = scanner.nextLine().trim();
        System.out.print("Enter to account number: ");
        String toAccount = scanner.nextLine().trim();
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Enter description: ");
        String description = scanner.nextLine().trim();
        System.out.print("Enter from bank code: ");
        String fromBankCode = scanner.nextLine().trim();
        
        try {
            TransactionService transactionService = cbnService.getTransactionService();
            Receipt receipt = transactionService.createTransferWithReceipt(fromAccount, toAccount, amount, description, 
                cbnService.getBankName(fromBankCode));
            
            System.out.println("Transfer initiated!");
            receiptService.printReceipt(receipt);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewAccountTransactions() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine().trim();
        
        try {
            TransactionService transactionService = cbnService.getTransactionService();
            var transactions = transactionService.getAccountTransactions(accountNumber);
            
            if (transactions.isEmpty()) {
                System.out.println("No transactions found for this account.");
            } else {
                System.out.println("Account Transactions:");
                for (Transaction transaction : transactions) {
                    System.out.println("ID: " + transaction.getTransactionId() + 
                                     ", Type: " + transaction.getType() + 
                                     ", Amount: " + transaction.getAmount() + 
                                     ", Status: " + transaction.getStatus());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void printReceipt() {
        System.out.print("Enter transaction ID: ");
        String transactionId = scanner.nextLine().trim();
        System.out.print("Enter bank name: ");
        String bankName = scanner.nextLine().trim();
        
        try {
            TransactionService transactionService = cbnService.getTransactionService();
            transactionService.printReceipt(transactionId, bankName);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listAllBanks() {
        var banks = cbnService.getAllBanks();
        if (banks.isEmpty()) {
            System.out.println("No banks registered.");
        } else {
            System.out.println("All Registered Banks:");
            for (Bank bank : banks) {
                System.out.println("Code: " + bank.getCode() + ", Name: " + bank.getName());
            }
        }
    }

    private void findBankByCode() {
        System.out.print("Enter bank code: ");
        String bankCode = scanner.nextLine().trim();
        
        Bank bank = cbnService.findBank(bankCode);
        if (bank != null) {
            System.out.println("Bank found:");
            System.out.println("Code: " + bank.getCode());
            System.out.println("Name: " + bank.getName());
        } else {
            System.out.println("Bank not found with code: " + bankCode);
        }
    }

    private void registerBank() {
        System.out.print("Enter bank code: ");
        String bankCode = scanner.nextLine().trim();
        
        try {
            cbnService.registerBank(bankCode);
            System.out.println("Bank registered successfully!");
            System.out.println("Code: " + bankCode + ", Name: " + cbnService.getBankName(bankCode));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void initializeSampleData() {
        try {
            User user1 = userService.createUser("Ekwethebabesnatcher", "ekwethebabesnatcher@rmail.com");
            User user2 = userService.createUser("Jegede", "jegede@rmail.com");
            User user3 = userService.createUser("Akande", "akande@rmail.com");
            
            cbnService.registerBank("044");
            cbnService.registerBank("057");
            cbnService.registerBank("011");
            
            System.out.println("Sample data initialized successfully!");
            System.out.println("Created 3 users and registered 3 banks");
            
        } catch (Exception e) {
            System.out.println("Warning: Could not initialize sample data: " + e.getMessage());
        }
    }
}
