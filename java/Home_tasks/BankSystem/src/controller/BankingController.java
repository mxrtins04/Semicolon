package controller;

import service.*;
import model.*;
import dto.request.*;
import dto.response.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BankingController {
    private BankService bankService;
    private CustomerService customerService;
    private AccountService accountService;
    private TransactionService transactionService;
    private Scanner scanner;

    public BankingController(BankService bankService, CustomerService customerService,
                             AccountService accountService, TransactionService transactionService) {
        this.bankService = bankService;
        this.customerService = customerService;
        this.accountService = accountService;
        this.transactionService = transactionService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getIntInput("Enter choice: ");

            try {
                switch (choice) {
                    case 1: registerCustomer(); break;
                    case 2: createAccount(); break;
                    case 3: depositMoney(); break;
                    case 4: checkBalance(); break;
                    case 5: transferMoney(); break;
                    case 6: viewTransactionHistory(); break;
                    case 7: nameInquiry(); break;
                    case 8: viewAllBanks(); break;
                    case 9: viewCustomerAccounts(); break;
                    case 0: running = false; break;
                    default: System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }

        System.out.println("Thank you for using Nigerian Banking System!");
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   NIGERIAN BANKING SYSTEM (NUBAN)     ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1. Register Customer (BVN)             ║");
        System.out.println("║ 2. Create Account (Generate NUBAN)     ║");
        System.out.println("║ 3. Deposit Money                       ║");
        System.out.println("║ 4. Check Balance                       ║");
        System.out.println("║ 5. Transfer Money (Inter-bank)         ║");
        System.out.println("║ 6. View Transaction History            ║");
        System.out.println("║ 7. Name Inquiry                        ║");
        System.out.println("║ 8. View All Banks                      ║");
        System.out.println("║ 9. View Customer Accounts              ║");
        System.out.println("║ 0. Exit                                ║");
        System.out.println("╚════════════════════════════════════════╝");
    }

    private void registerCustomer() {
        System.out.println("\n--- REGISTER CUSTOMER ---");

        CreateCustomerRequest request = new CreateCustomerRequest();
        request.setBvn(getStringInput("Enter BVN (11 digits): "));
        request.setFirstName(getStringInput("Enter first name: "));
        request.setLastName(getStringInput("Enter last name: "));
        request.setEmail(getStringInput("Enter email: "));
        request.setPhoneNumber(getStringInput("Enter phone (+234XXXXXXXXXX): "));
        Customer customer = customerService.registerCustomer(request);
        System.out.println("✓ Customer registered successfully!");
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Name: " + customer.getFullName());
    }

    private void createAccount() {
        System.out.println("\n--- CREATE ACCOUNT (NUBAN) ---");

        String bvn = getStringInput("Enter BVN: ");

        System.out.println("\nAvailable Banks:");
        List<Bank> banks = bankService.getAllBanks();
        for (int i = 0; i < banks.size(); i++) {
            System.out.println((i + 1) + ". " + banks.get(i).getBankName() +
                    " (" + banks.get(i).getBankCode() + ")");
        }

        int bankChoice = getIntInput("Select bank: ");
        if (bankChoice < 1 || bankChoice > banks.size()) {
            System.out.println("Invalid bank selection");
            return;
        }

        Bank selectedBank = banks.get(bankChoice - 1);

        CreateAccountRequest request = new CreateAccountRequest();
        request.setBvn(bvn);
        request.setBankCode(selectedBank.getBankCode());

        AccountResponse response = accountService.createAccount(request);
        System.out.println("\n✓ Account created successfully!");
        System.out.println("═══════════════════════════════════");
        System.out.println("Account Number: " + response.getAccountNumber());
        System.out.println("Bank: " + response.getBankName());
        System.out.println("Customer: " + response.getCustomerName());
        System.out.println("═══════════════════════════════════");
    }

    private void depositMoney() {
        System.out.println("\n--- DEPOSIT MONEY ---");

        String accountNumber = getStringInput("Enter account number: ");
        BigDecimal amount = getBigDecimalInput("Enter amount: ");

        accountService.deposit(accountNumber, amount);
        BigDecimal newBalance = accountService.getBalance(accountNumber);

        System.out.println("✓ Deposit successful!");
        System.out.println("New Balance: ₦" + newBalance);
    }

    private void checkBalance() {
        System.out.println("\n--- CHECK BALANCE ---");

        String accountNumber = getStringInput("Enter account number: ");
        BigDecimal balance = accountService.getBalance(accountNumber);
        String holderName = accountService.getAccountHolderName(accountNumber);

        System.out.println("\nAccount: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: ₦" + balance);
    }

    private void transferMoney() {
        System.out.println("\n--- TRANSFER MONEY ---");

        TransferRequest request = new TransferRequest();
        request.setSourceAccountNumber(getStringInput("Enter your account number: "));
        request.setDestinationAccountNumber(getStringInput("Enter destination account: "));

        // Show banks for selection
        System.out.println("\nSelect destination bank:");
        List<Bank> banks = bankService.getAllBanks();
        for (int i = 0; i < banks.size(); i++) {
            System.out.println((i + 1) + ". " + banks.get(i).getBankName());
        }

        int bankChoice = getIntInput("Bank: ");
        if (bankChoice < 1 || bankChoice > banks.size()) {
            System.out.println("Invalid bank selection");
            return;
        }

        request.setDestinationBankCode(banks.get(bankChoice - 1).getBankCode());
        request.setAmount(getBigDecimalInput("Enter amount: "));
        request.setNarration(getStringInput("Enter narration: "));

        String destName = accountService.getAccountHolderName(request.getDestinationAccountNumber());
        System.out.println("\nTransfer to: " + destName);
        System.out.println("Amount: ₦" + request.getAmount());
        String confirm = getStringInput("Confirm (yes/no): ");

        if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Transfer cancelled");
            return;
        }

        TransactionResponse response = transactionService.transfer(request);
        System.out.println("\n✓ Transfer successful!");
        System.out.println("Reference: " + response.getReferenceNumber());
        System.out.println("Status: " + response.getStatus());
    }

    private void viewTransactionHistory() {
        System.out.println("\n--- TRANSACTION HISTORY ---");

        String accountNumber = getStringInput("Enter account number: ");
        List<TransactionResponse> transactions = transactionService.getAccountTransactions(accountNumber);

        if (transactions.isEmpty()) {
            System.out.println("No transactions found");
        } else {
            for (TransactionResponse txn : transactions) {
                System.out.println(txn);
            }
        }
    }

    private void nameInquiry() {
        System.out.println("\n--- NAME INQUIRY ---");

        String accountNumber = getStringInput("Enter account number: ");
        String name = accountService.getAccountHolderName(accountNumber);

        System.out.println("Account Holder: " + name);
    }

    private void viewAllBanks() {
        System.out.println("\n--- REGISTERED BANKS ---");

        List<Bank> banks = bankService.getAllBanks();
        for (Bank bank : banks) {
            System.out.println(bank.getBankCode() + " - " + bank.getBankName());
        }
    }

    private void viewCustomerAccounts() {
        System.out.println("\n--- CUSTOMER ACCOUNTS ---");

        String bvn = getStringInput("Enter BVN: ");
        List<AccountResponse> accounts = accountService.getCustomerAccounts(bvn);

        if (accounts.isEmpty()) {
            System.out.println("No accounts found");
        } else {
            for (AccountResponse account : accounts) {
                System.out.println(account);
            }
        }
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Invalid input. " + prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private BigDecimal getBigDecimalInput(String prompt) {
        System.out.print(prompt);
        return new BigDecimal(scanner.nextLine());
    }

    private LocalDate getDateInput(String prompt) {
        System.out.print(prompt);
    }