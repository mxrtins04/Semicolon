package data.repository;

import data.model.Transaction;
import data.model.TransactionStatus;
import data.model.TransactionType;
import data.repository.impl.TransactionRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TransactionRepositoryImplTest {

    private TransactionRepositoryImpl repository;
    private Transaction testTransaction1;
    private Transaction testTransaction2;
    private Transaction testTransaction3;

    @BeforeEach
    void setUp() {
        repository = new TransactionRepositoryImpl();
        testTransaction1 = new Transaction(TransactionType.DEPOSIT, 1001, 1000.0, "Test deposit");
        testTransaction2 = new Transaction(TransactionType.WITHDRAWAL, 1001, 500.0, "Test withdrawal");
        testTransaction3 = new Transaction(TransactionType.TRANSFER, 1001, 1002, 300.0, "Test transfer");
    }

    @Test
    @DisplayName("Should save transaction successfully")
    void shouldSaveTransaction() {
        repository.save(testTransaction1);
        
        assertTrue(repository.exists(testTransaction1.getTransactionId()));
        assertEquals(1, repository.count());
    }

    @Test
    @DisplayName("Should find transaction by ID")
    void shouldFindByTransactionId() {
        repository.save(testTransaction1);
        
        Optional<Transaction> found = repository.findByTransactionId(testTransaction1.getTransactionId());
        
        assertTrue(found.isPresent());
        assertEquals(testTransaction1.getTransactionId(), found.get().getTransactionId());
        assertEquals(TransactionType.DEPOSIT, found.get().getType());
        assertEquals(1001, found.get().getFromAccount());
        assertEquals(1000.0, found.get().getAmount());
    }

    @Test
    @DisplayName("Should return empty when transaction ID not found")
    void shouldReturnEmptyWhenTransactionIdNotFound() {
        Optional<Transaction> found = repository.findByTransactionId("NONEXISTENT");
        
        assertFalse(found.isPresent());
    }

    @Test
    @DisplayName("Should find transactions by account number")
    void shouldFindByAccountNumber() {
        repository.save(testTransaction1);
        repository.save(testTransaction2);
        repository.save(testTransaction3);
        
        List<Transaction> account1001Transactions = repository.findByAccountNumber(1001);
        List<Transaction> account1002Transactions = repository.findByAccountNumber(1002);
        
        assertEquals(3, account1001Transactions.size());
        assertEquals(1, account1002Transactions.size());
    }

    @Test
    @DisplayName("Should find transactions by account number and type")
    void shouldFindByAccountNumberAndType() {
        repository.save(testTransaction1);
        repository.save(testTransaction2);
        repository.save(testTransaction3);
        
        List<Transaction> deposits = repository.findByAccountNumberAndType(1001, TransactionType.DEPOSIT);
        List<Transaction> withdrawals = repository.findByAccountNumberAndType(1001, TransactionType.WITHDRAWAL);
        List<Transaction> transfers = repository.findByAccountNumberAndType(1001, TransactionType.TRANSFER);
        
        assertEquals(1, deposits.size());
        assertEquals(1, withdrawals.size());
        assertEquals(1, transfers.size());
    }

    @Test
    @DisplayName("Should find transactions by date range")
    void shouldFindByDateRange() {
        repository.save(testTransaction1);
        
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneHourAgo = now.minusHours(1);
        LocalDateTime oneHourLater = now.plusHours(1);
        
        List<Transaction> transactionsInRange = repository.findByDateRange(oneHourAgo, oneHourLater);
        List<Transaction> transactionsOutOfRange = repository.findByDateRange(now.plusHours(2), now.plusHours(3));
        
        assertEquals(1, transactionsInRange.size());
        assertTrue(transactionsOutOfRange.isEmpty());
    }

    @Test
    @DisplayName("Should find all transactions")
    void shouldFindAllTransactions() {
        repository.save(testTransaction1);
        repository.save(testTransaction2);
        repository.save(testTransaction3);
        
        List<Transaction> allTransactions = repository.findAll();
        
        assertEquals(3, allTransactions.size());
        assertTrue(allTransactions.contains(testTransaction1));
        assertTrue(allTransactions.contains(testTransaction2));
        assertTrue(allTransactions.contains(testTransaction3));
    }

    @Test
    @DisplayName("Should return empty list when no transactions exist")
    void shouldReturnEmptyListWhenNoTransactionsExist() {
        List<Transaction> allTransactions = repository.findAll();
        
        assertTrue(allTransactions.isEmpty());
    }

    @Test
    @DisplayName("Should find transactions by status")
    void shouldFindByStatus() {
        testTransaction1.complete();
        testTransaction2.fail();
        repository.save(testTransaction1);
        repository.save(testTransaction2);
        
        List<Transaction> completedTransactions = repository.findByStatus(TransactionStatus.COMPLETED);
        List<Transaction> failedTransactions = repository.findByStatus(TransactionStatus.FAILED);
        List<Transaction> pendingTransactions = repository.findByStatus(TransactionStatus.PENDING);
        
        assertEquals(1, completedTransactions.size());
        assertEquals(1, failedTransactions.size());
        assertTrue(pendingTransactions.isEmpty());
    }

    @Test
    @DisplayName("Should delete transaction by ID")
    void shouldDeleteTransaction() {
        repository.save(testTransaction1);
        repository.save(testTransaction2);
        
        repository.delete(testTransaction1.getTransactionId());
        
        assertFalse(repository.exists(testTransaction1.getTransactionId()));
        assertTrue(repository.exists(testTransaction2.getTransactionId()));
        assertEquals(1, repository.count());
    }

    @Test
    @DisplayName("Should not throw when deleting non-existent transaction")
    void shouldNotThrowWhenDeletingNonExistentTransaction() {
        assertDoesNotThrow(() -> repository.delete("NONEXISTENT"));
        assertEquals(0, repository.count());
    }

    @Test
    @DisplayName("Should check if transaction exists")
    void shouldCheckTransactionExists() {
        repository.save(testTransaction1);
        
        assertTrue(repository.exists(testTransaction1.getTransactionId()));
        assertFalse(repository.exists("NONEXISTENT"));
    }

    @Test
    @DisplayName("Should return correct transaction count")
    void shouldReturnCorrectCount() {
        assertEquals(0, repository.count());
        
        repository.save(testTransaction1);
        assertEquals(1, repository.count());
        
        repository.save(testTransaction2);
        assertEquals(2, repository.count());
        
        repository.delete(testTransaction1.getTransactionId());
        assertEquals(1, repository.count());
    }

    @Test
    @DisplayName("Should handle transactions with same account")
    void shouldHandleTransactionsSameAccount() {
        Transaction anotherTransaction = new Transaction(TransactionType.DEPOSIT, 1001, 2000.0, "Another deposit");
        repository.save(testTransaction1);
        repository.save(anotherTransaction);
        
        List<Transaction> accountTransactions = repository.findByAccountNumber(1001);
        
        assertEquals(2, accountTransactions.size());
    }

    @Test
    @DisplayName("Should handle date range edge cases")
    void shouldHandleDateRangeEdgeCases() {
        repository.save(testTransaction1);
        LocalDateTime transactionTime = testTransaction1.getTimestamp();
        
        // Exact same time
        List<Transaction> exactTime = repository.findByDateRange(transactionTime, transactionTime);
        assertEquals(1, exactTime.size());
        
        // Before transaction time
        List<Transaction> beforeTime = repository.findByDateRange(transactionTime.minusSeconds(1), transactionTime.minusNanos(1));
        assertTrue(beforeTime.isEmpty());
    }
}
