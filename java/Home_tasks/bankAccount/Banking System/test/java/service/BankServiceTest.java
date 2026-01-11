package service;

import data.model.Account;
import data.model.Transaction;
import data.model.TransactionStatus;
import data.model.TransactionType;
import data.repository.impl.AccountRepositoryImpl;
import data.repository.impl.TransactionRepositoryImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    private BankService bankService;
    private TransactionService transactionService;
    private TransactionRepositoryImpl transactionRepository;
    private static final String BANK_CODE = "044";

    @BeforeEach
    void setUp() {
        transactionRepository = new TransactionRepositoryImpl();
        transactionService = new TransactionService(transactionRepository);
        bankService = new BankService(BANK_CODE, new AccountRepositoryImpl(), transactionService);
    }

    @Test
    @DisplayName("Should create account successfully")
    void shouldCreateAccount() {
        Account created = bankService.createAccount("John Doe", "john@email.com", "password123");
        
        assertNotNull(created);
        assertEquals("John Doe", created.getName());
        assertEquals("john@email.com", created.getEmail());
        assertEquals(1, created.getAccountNumber());
        assertTrue(bankService.accountExists(1));
        
        var transactions = transactionService.getAccountTransactions(1);
        assertEquals(1, transactions.size());
        assertEquals(TransactionType.DEPOSIT, transactions.get(0).getType());
        assertEquals(0.0, transactions.get(0).getAmount());
    }

    @Test
    @DisplayName("Should create multiple accounts with sequential numbers")
    void shouldCreateMultipleAccounts() {
        Account account1 = bankService.createAccount("John Doe", "john@email.com", "password123");
        Account account2 = bankService.createAccount("Jane Smith", "jane@email.com", "password456");
        
        assertNotNull(account1.getAccountNumber());
        assertNotNull(account2.getAccountNumber());
        assertEquals(2, bankService.getAccountCount());
    }

    @Test
    @DisplayName("Should find account by account number")
    void shouldFindAccount() {
        Account created = bankService.createAccount("John Doe", "john@email.com", "password123");
        String accountNumber = created.getAccountNumber();
        
        Account found = bankService.findAccount(accountNumber);
        
        assertNotNull(found);
        assertEquals(created.getName(), found.getName());
        assertEquals(created.getEmail(), found.getEmail());
    }

    @Test
    @DisplayName("Should return empty when account not found")
    void shouldReturnEmptyWhenAccountNotFound() {
        Account found = bankService.findAccount("9999999999999");
        
        assertNull(found);
    }

    @Test
    @DisplayName("Should deposit successfully")
    void shouldDeposit() {
        Account account = bankService.createAccount("John Doe", "john@email.com", "password123");
        String accountNumber = account.getAccountNumber();
        
        bankService.deposit(accountNumber, 1000.0);
        
        assertEquals(1000, bankService.getBalance(accountNumber));
        
        var transactions = transactionService.getAccountTransactions(accountNumber);
        assertEquals(2, transactions.size());
        
        var depositTransaction = transactions.stream()
            .filter(t -> t.getAmount() == 1000.0)
            .findFirst();
        assertTrue(depositTransaction.isPresent());
        assertEquals(TransactionStatus.COMPLETED, depositTransaction.get().getStatus());
    }

    @Test
    @DisplayName("Should throw exception for negative deposit amount")
    void shouldThrowExceptionForNegativeDeposit() {
        Account account = bankService.createAccount("John Doe", "john@email.com", "password123");
        String accountNumber = account.getAccountNumber();
        
        assertThrows(IllegalArgumentException.class, () -> bankService.deposit(accountNumber, -100.0));
        assertThrows(IllegalArgumentException.class, () -> bankService.deposit(accountNumber, 0.0));
    }

    @Test
    @DisplayName("Should throw exception for deposit to non-existent account")
    void shouldThrowExceptionForDepositToNonExistentAccount() {
        assertThrows(IllegalArgumentException.class, () -> bankService.deposit("9999999999999", 1000.0));
    }

    @Test
    @DisplayName("Should withdraw successfully")
    void shouldWithdraw() {
        Account account = bankService.createAccount("John Doe", "john@email.com", "password123");
        String accountNumber = account.getAccountNumber();
        account.deposit(1000);
        
        bankService.withdraw(accountNumber, 500.0);
        
        assertEquals(500, bankService.getBalance(accountNumber));
        
        var transactions = transactionService.getAccountTransactions(accountNumber);
        assertEquals(2, transactions.size());
        
        var withdrawalTransaction = transactions.stream()
            .filter(t -> t.getType() == TransactionType.WITHDRAWAL)
            .findFirst();
        assertTrue(withdrawalTransaction.isPresent());
        assertEquals(TransactionStatus.COMPLETED, withdrawalTransaction.get().getStatus());
    }

    @Test
    @DisplayName("Should throw exception for negative withdrawal amount")
    void shouldThrowExceptionForNegativeWithdrawal() {
        Account account = bankService.createAccount("John Doe", "john@email.com", "password123");
        String accountNumber = account.getAccountNumber();
        
        assertThrows(IllegalArgumentException.class, () -> bankService.withdraw(accountNumber, -100.0));
        assertThrows(IllegalArgumentException.class, () -> bankService.withdraw(accountNumber, 0.0));
    }

    @Test
    @DisplayName("Should throw exception for withdrawal from non-existent account")
    void shouldThrowExceptionForWithdrawalFromNonExistentAccount() {
        assertThrows(IllegalArgumentException.class, () -> bankService.withdraw("9999999999999", 100.0));
    }

    @Test
    @DisplayName("Should throw exception for insufficient funds")
    void shouldThrowExceptionForInsufficientFunds() {
        Account account = bankService.createAccount("John Doe", "john@email.com", "password123");
        String accountNumber = account.getAccountNumber();
        
        assertThrows(IllegalArgumentException.class, () -> bankService.withdraw(accountNumber, 2000.0));
    }

    @Test
    @DisplayName("Should get balance successfully")
    void shouldGetBalance() {
        Account account = bankService.createAccount("John Doe", "john@email.com", "password123");
        String accountNumber = account.getAccountNumber();
        account.deposit(1000);
        
        double balance = bankService.getBalance(accountNumber);
        
        assertEquals(1000.0, balance);
    }

    @Test
    @DisplayName("Should throw exception for balance of non-existent account")
    void shouldThrowExceptionForBalanceOfNonExistentAccount() {
        assertThrows(IllegalArgumentException.class, () -> bankService.getBalance("9999999999999"));
    }

    @Test
    @DisplayName("Should check if account exists")
    void shouldCheckAccountExists() {
        Account account = bankService.createAccount("John Doe", "john@email.com", "password123");
        String accountNumber = account.getAccountNumber();
        
        assertTrue(bankService.accountExists(accountNumber));
        assertFalse(bankService.accountExists("9999999999999"));
    }

    @Test
    @DisplayName("Should get account count")
    void shouldGetAccountCount() {
        assertEquals(0, bankService.getAccountCount());
        
        bankService.createAccount("John Doe", "john@email.com", "password123");
        assertEquals(1, bankService.getAccountCount());
        
        bankService.createAccount("Jane Smith", "jane@email.com", "password456");
        assertEquals(2, bankService.getAccountCount());
    }

    @Test
    @DisplayName("Should get all accounts")
    void shouldGetAllAccounts() {
        Account account1 = bankService.createAccount("John Doe", "john@email.com", "password123");
        Account account2 = bankService.createAccount("Jane Smith", "jane@email.com", "password456");
        
        var allAccounts = bankService.getAllAccounts();
        
        assertEquals(2, allAccounts.size());
        assertTrue(allAccounts.contains(account1));
        assertTrue(allAccounts.contains(account2));
    }

    @Test
    @DisplayName("Should return bank code")
    void shouldReturnBankCode() {
        assertEquals(BANK_CODE, bankService.getBankCode());
    }

    @Test
    @DisplayName("Should handle multiple deposits")
    void shouldHandleMultipleDeposits() {
        Account account = bankService.createAccount("John Doe", "john@email.com", "password123");
        String accountNumber = account.getAccountNumber();
        
        bankService.deposit(accountNumber, 1000.0);
        bankService.deposit(accountNumber, 500.0);
        
        assertEquals(1500, bankService.getBalance(accountNumber));
        
        var transactions = transactionService.getAccountTransactions(accountNumber);
        assertEquals(3, transactions.size());
    }

    @Test
    @DisplayName("Should handle multiple withdrawals")
    void shouldHandleMultipleWithdrawals() {
        Account account = bankService.createAccount("John Doe", "john@email.com", "password123");
        String accountNumber = account.getAccountNumber();
        account.deposit(2000);
        
        bankService.withdraw(accountNumber, 500.0);
        bankService.withdraw(accountNumber, 300.0);
        
        assertEquals(1200, bankService.getBalance(accountNumber));
        
        var transactions = transactionService.getAccountTransactions(accountNumber);
        assertEquals(3, transactions.size());
    }

    @Test
    @DisplayName("Should handle zero balance after withdrawal")
    void shouldHandleZeroBalanceAfterWithdrawal() {
        Account account = bankService.createAccount("John Doe", "john@email.com", "password123");
        String accountNumber = account.getAccountNumber();
        account.deposit(1000);
        
        bankService.withdraw(accountNumber, 1000.0);
        
        assertEquals(0, bankService.getBalance(accountNumber));
    }
}
