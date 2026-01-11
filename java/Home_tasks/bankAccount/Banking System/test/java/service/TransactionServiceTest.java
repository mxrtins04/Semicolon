package service;

import data.model.Transaction;
import data.model.TransactionStatus;
import data.model.TransactionType;
import data.repository.impl.TransactionRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    private TransactionService transactionService;
    private TransactionRepositoryImpl transactionRepository;

    @BeforeEach
    void setUp() {
        transactionRepository = new TransactionRepositoryImpl();
        transactionService = new TransactionService(transactionRepository);
    }

    @Test
    @DisplayName("Should create deposit transaction successfully")
    void shouldCreateDepositTransaction() {
        Transaction transaction = transactionService.createDeposit(1001, 1000.0, "Test deposit");
        
        assertNotNull(transaction);
        assertEquals(TransactionType.DEPOSIT, transaction.getType());
        assertEquals(1001, transaction.getFromAccount());
        assertEquals(1000.0, transaction.getAmount());
        assertEquals("Test deposit", transaction.getDescription());
        assertEquals(TransactionStatus.PENDING, transaction.getStatus());
        assertTrue(transactionService.findByTransactionId(transaction.getTransactionId()).isPresent());
    }

    @Test
    @DisplayName("Should create withdrawal transaction successfully")
    void shouldCreateWithdrawalTransaction() {
        Transaction transaction = transactionService.createWithdrawal(1001, 500.0, "Test withdrawal");
        
        assertNotNull(transaction);
        assertEquals(TransactionType.WITHDRAWAL, transaction.getType());
        assertEquals(1001, transaction.getFromAccount());
        assertEquals(500.0, transaction.getAmount());
        assertEquals("Test withdrawal", transaction.getDescription());
        assertEquals(TransactionStatus.PENDING, transaction.getStatus());
    }

    @Test
    @DisplayName("Should create transfer transaction successfully")
    void shouldCreateTransferTransaction() {
        Transaction transaction = transactionService.createTransfer(1001, 1002, 300.0, "Test transfer");
        
        assertNotNull(transaction);
        assertEquals(TransactionType.TRANSFER, transaction.getType());
        assertEquals(1001, transaction.getFromAccount());
        assertEquals(1002, transaction.getToAccount());
        assertEquals(300.0, transaction.getAmount());
        assertEquals("Test transfer", transaction.getDescription());
        assertEquals(TransactionStatus.PENDING, transaction.getStatus());
    }

    @Test
    @DisplayName("Should find transaction by ID")
    void shouldFindByTransactionId() {
        Transaction created = transactionService.createDeposit(1001, 1000.0, "Test deposit");
        
        Optional<Transaction> found = transactionService.findByTransactionId(created.getTransactionId());
        
        assertTrue(found.isPresent());
        assertEquals(created.getTransactionId(), found.get().getTransactionId());
        assertEquals(created.getType(), found.get().getType());
        assertEquals(created.getAmount(), found.get().getAmount());
    }

    @Test
    @DisplayName("Should return empty when transaction ID not found")
    void shouldReturnEmptyWhenTransactionIdNotFound() {
        Optional<Transaction> found = transactionService.findByTransactionId("NONEXISTENT");
        
        assertFalse(found.isPresent());
    }

    @Test
    @DisplayName("Should get account transactions")
    void shouldGetAccountTransactions() {
        Transaction deposit = transactionService.createDeposit(1001, 1000.0, "Deposit");
        Transaction withdrawal = transactionService.createWithdrawal(1001, 500.0, "Withdrawal");
        Transaction transfer = transactionService.createTransfer(1001, 1002, 300.0, "Transfer");
        Transaction otherAccount = transactionService.createDeposit(1002, 2000.0, "Other deposit");
        
        List<Transaction> account1001Transactions = transactionService.getAccountTransactions(1001);
        List<Transaction> account1002Transactions = transactionService.getAccountTransactions(1002);
        
        assertEquals(3, account1001Transactions.size());
        assertEquals(2, account1002Transactions.size()); // transfer + deposit
        assertTrue(account1001Transactions.contains(deposit));
        assertTrue(account1001Transactions.contains(withdrawal));
        assertTrue(account1001Transactions.contains(transfer));
        assertTrue(account1002Transactions.contains(otherAccount));
    }

    @Test
    @DisplayName("Should get transactions by type for account")
    void shouldGetTransactionsByTypeForAccount() {
        Transaction deposit1 = transactionService.createDeposit(1001, 1000.0, "Deposit 1");
        Transaction deposit2 = transactionService.createDeposit(1001, 500.0, "Deposit 2");
        Transaction withdrawal = transactionService.createWithdrawal(1001, 300.0, "Withdrawal");
        Transaction transfer = transactionService.createTransfer(1001, 1002, 200.0, "Transfer");
        
        List<Transaction> deposits = transactionService.getTransactionsByType(1001, TransactionType.DEPOSIT);
        List<Transaction> withdrawals = transactionService.getTransactionsByType(1001, TransactionType.WITHDRAWAL);
        List<Transaction> transfers = transactionService.getTransactionsByType(1001, TransactionType.TRANSFER);
        
        assertEquals(2, deposits.size());
        assertEquals(1, withdrawals.size());
        assertEquals(1, transfers.size());
        assertTrue(deposits.contains(deposit1));
        assertTrue(deposits.contains(deposit2));
        assertTrue(withdrawals.contains(withdrawal));
        assertTrue(transfers.contains(transfer));
    }

    @Test
    @DisplayName("Should get transactions by date range")
    void shouldGetTransactionsByDateRange() {
        Transaction transaction1 = transactionService.createDeposit(1001, 1000.0, "Transaction 1");
        // Small delay to ensure different timestamps
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Transaction transaction2 = transactionService.createDeposit(1002, 500.0, "Transaction 2");
        
        var start = transaction1.getTimestamp();
        var end = transaction2.getTimestamp();
        
        List<Transaction> inRange = transactionService.getTransactionsByDateRange(start, end);
        List<Transaction> beforeRange = transactionService.getTransactionsByDateRange(start.minusSeconds(1), start.minusNanos(1));
        List<Transaction> afterRange = transactionService.getTransactionsByDateRange(end.plusNanos(1), end.plusSeconds(1));
        
        assertEquals(2, inRange.size());
        assertTrue(beforeRange.isEmpty());
        assertTrue(afterRange.isEmpty());
    }

    @Test
    @DisplayName("Should get all transactions")
    void shouldGetAllTransactions() {
        Transaction transaction1 = transactionService.createDeposit(1001, 1000.0, "Transaction 1");
        Transaction transaction2 = transactionService.createWithdrawal(1001, 500.0, "Transaction 2");
        Transaction transaction3 = transactionService.createTransfer(1001, 1002, 300.0, "Transaction 3");
        
        List<Transaction> allTransactions = transactionService.getAllTransactions();
        
        assertEquals(3, allTransactions.size());
        assertTrue(allTransactions.contains(transaction1));
        assertTrue(allTransactions.contains(transaction2));
        assertTrue(allTransactions.contains(transaction3));
    }

    @Test
    @DisplayName("Should complete transaction successfully")
    void shouldCompleteTransaction() {
        Transaction transaction = transactionService.createDeposit(1001, 1000.0, "Test deposit");
        
        transactionService.completeTransaction(transaction.getTransactionId());
        
        Optional<Transaction> found = transactionService.findByTransactionId(transaction.getTransactionId());
        assertTrue(found.isPresent());
        assertEquals(TransactionStatus.COMPLETED, found.get().getStatus());
    }

    @Test
    @DisplayName("Should fail transaction successfully")
    void shouldFailTransaction() {
        Transaction transaction = transactionService.createDeposit(1001, 1000.0, "Test deposit");
        
        transactionService.failTransaction(transaction.getTransactionId());
        
        Optional<Transaction> found = transactionService.findByTransactionId(transaction.getTransactionId());
        assertTrue(found.isPresent());
        assertEquals(TransactionStatus.FAILED, found.get().getStatus());
    }

    @Test
    @DisplayName("Should not throw when completing non-existent transaction")
    void shouldNotThrowWhenCompletingNonExistentTransaction() {
        assertDoesNotThrow(() -> transactionService.completeTransaction("NONEXISTENT"));
    }

    @Test
    @DisplayName("Should not throw when failing non-existent transaction")
    void shouldNotThrowWhenFailingNonExistentTransaction() {
        assertDoesNotThrow(() -> transactionService.failTransaction("NONEXISTENT"));
    }

    @Test
    @DisplayName("Should handle multiple transactions")
    void shouldHandleMultipleTransactions() {
        for (int i = 0; i < 10; i++) {
            transactionService.createDeposit(1001 + i, 1000.0 + i, "Transaction " + i);
        }
        
        List<Transaction> allTransactions = transactionService.getAllTransactions();
        assertEquals(10, allTransactions.size());
    }

    @Test
    @DisplayName("Should handle transactions with same account")
    void shouldHandleTransactionsSameAccount() {
        Transaction transaction1 = transactionService.createDeposit(1001, 1000.0, "Deposit 1");
        Transaction transaction2 = transactionService.createWithdrawal(1001, 500.0, "Withdrawal");
        Transaction transaction3 = transactionService.createDeposit(1001, 2000.0, "Deposit 2");
        
        List<Transaction> accountTransactions = transactionService.getAccountTransactions(1001);
        
        assertEquals(3, accountTransactions.size());
        assertTrue(accountTransactions.contains(transaction1));
        assertTrue(accountTransactions.contains(transaction2));
        assertTrue(accountTransactions.contains(transaction3));
    }

    @Test
    @DisplayName("Should handle transactions with different amounts")
    void shouldHandleTransactionsDifferentAmounts() {
        Transaction smallAmount = transactionService.createDeposit(1001, 0.01, "Small amount");
        Transaction largeAmount = transactionService.createDeposit(1002, 999999.99, "Large amount");
        Transaction zeroAmount = transactionService.createDeposit(1003, 0.0, "Zero amount");
        
        assertEquals(0.01, smallAmount.getAmount());
        assertEquals(999999.99, largeAmount.getAmount());
        assertEquals(0.0, zeroAmount.getAmount());
    }

    @Test
    @DisplayName("Should handle transactions with long descriptions")
    void shouldHandleTransactionsLongDescriptions() {
        String longDescription = "This is a very long description that contains many words and characters to test if the system can handle it properly without any issues or problems arising from the length of the description field.";
        
        Transaction transaction = transactionService.createDeposit(1001, 1000.0, longDescription);
        
        assertEquals(longDescription, transaction.getDescription());
    }
}
