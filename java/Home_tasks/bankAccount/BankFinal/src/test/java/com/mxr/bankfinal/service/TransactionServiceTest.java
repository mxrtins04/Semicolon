package com.mxr.bankfinal.service;

import com.mxr.bankfinal.data.model.Transaction;
import com.mxr.bankfinal.data.model.TransactionStatus;
import com.mxr.bankfinal.data.model.TransactionType;
import com.mxr.bankfinal.data.repository.impl.TransactionRepositoryImpl;
import com.mxr.bankfinal.data.repository.impl.AccountRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    private TransactionService transactionService;
    private TransactionRepositoryImpl transactionRepository;
    private ReceiptService receiptService;
    private AccountRepositoryImpl accountRepository;

    @BeforeEach
    void setUp() {
        transactionRepository = new TransactionRepositoryImpl();
        accountRepository = new AccountRepositoryImpl();
        receiptService = new ReceiptService(accountRepository);
        transactionService = new TransactionService(transactionRepository, receiptService, accountRepository);
    }

    @Test
    @DisplayName("Should create deposit transaction successfully")
    void shouldCreateDepositTransaction() {
        Transaction transaction = transactionService.createDeposit("1000000001", 1000.0, "Test deposit");
        
        assertNotNull(transaction);
        assertEquals(TransactionType.DEPOSIT, transaction.getType());

        
        Transaction found = transactionService.findTransactionById(transaction.getTransactionId());
        assertEquals(transaction.getTransactionId(), found.getTransactionId());
    }

    @Test
    @DisplayName("Should create withdrawal transaction successfully")
    void shouldCreateWithdrawalTransaction() {
        Transaction transaction = transactionService.createWithdrawal("1000000001", 500.0, "Test withdrawal");
        
        assertNotNull(transaction);
        assertEquals(TransactionType.WITHDRAWAL, transaction.getType());
        assertEquals("1000000001", transaction.getFromAccount());
        assertEquals(500.0, transaction.getAmount());
        assertEquals("Test withdrawal", transaction.getDescription());
        assertEquals(TransactionStatus.PENDING, transaction.getStatus());
    }

    @Test
    @DisplayName("Should create transfer transaction successfully")
    void shouldCreateTransferTransaction() {
        Transaction transaction = transactionService.createTransfer("1000000001", "1000000002", 300.0, "Test transfer");
        
        assertNotNull(transaction);
        assertEquals(TransactionType.TRANSFER, transaction.getType());
        assertEquals("1000000001", transaction.getFromAccount());
        assertEquals("1000000002", transaction.getToAccount());
        assertEquals(300.0, transaction.getAmount());
        assertEquals("Test transfer", transaction.getDescription());
        assertEquals(TransactionStatus.PENDING, transaction.getStatus());
    }

    @Test
    @DisplayName("Should find transaction by ID")
    void shouldFindByTransactionId() {
        Transaction created = transactionService.createDeposit("1000000001", 1000.0, "Test deposit");
        
        Transaction found = transactionService.findTransactionById(created.getTransactionId());
        
        assertNotNull(found);
        assertEquals(created.getTransactionId(), found.getTransactionId());
        assertEquals(created.getType(), found.getType());
        assertEquals(created.getAmount(), found.getAmount());
    }

    @Test
    @DisplayName("Should throw when transaction ID not found")
    void shouldThrowWhenTransactionIdNotFound() {
        assertThrows(IllegalArgumentException.class, () -> 
            transactionService.findTransactionById("NONEXISTENT")
        );
    }

    @Test
    @DisplayName("Should get account transactions")
    void shouldGetAccountTransactions() {
        String acc1 = "1000000001";
        String acc2 = "1000000002";
        
        Transaction deposit = transactionService.createDeposit(acc1, 1000.0, "Deposit");
        Transaction withdrawal = transactionService.createWithdrawal(acc1, 500.0, "Withdrawal");
        Transaction transfer = transactionService.createTransfer(acc1, acc2, 300.0, "Transfer");
        Transaction otherAccount = transactionService.createDeposit(acc2, 2000.0, "Other deposit");
        
        List<Transaction> acc1Transactions = transactionService.getAccountTransactions(acc1);
        List<Transaction> acc2Transactions = transactionService.getAccountTransactions(acc2);
        
        assertEquals(3, acc1Transactions.size());
        assertEquals(2, acc2Transactions.size());
        assertTrue(acc1Transactions.contains(deposit));
        assertTrue(acc1Transactions.contains(withdrawal));
        assertTrue(acc1Transactions.contains(transfer));
        assertTrue(acc2Transactions.contains(otherAccount));
    }

    @Test
    @DisplayName("Should get transactions by type for account")
    void shouldGetTransactionsByTypeForAccount() {
        String acc1 = "1000000001";
        String acc2 = "1000000002";
        
        Transaction deposit1 = transactionService.createDeposit(acc1, 1000.0, "Deposit 1");
        Transaction deposit2 = transactionService.createDeposit(acc1, 500.0, "Deposit 2");
        Transaction withdrawal = transactionService.createWithdrawal(acc1, 300.0, "Withdrawal");
        Transaction transfer = transactionService.createTransfer(acc1, acc2, 200.0, "Transfer");
        
        List<Transaction> deposits = transactionService.getTransactionsByType(acc1, TransactionType.DEPOSIT);
        List<Transaction> withdrawals = transactionService.getTransactionsByType(acc1, TransactionType.WITHDRAWAL);
        List<Transaction> transfers = transactionService.getTransactionsByType(acc1, TransactionType.TRANSFER);
        
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
        Transaction transaction1 = transactionService.createDeposit("1000000001", 1000.0, "Transaction 1");
        // Small delay to ensure different timestamps
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Transaction transaction2 = transactionService.createDeposit("1000000002", 500.0, "Transaction 2");
        
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
        Transaction transaction1 = transactionService.createDeposit("1000000001", 1000.0, "Transaction 1");
        Transaction transaction2 = transactionService.createWithdrawal("1000000001", 500.0, "Transaction 2");
        Transaction transaction3 = transactionService.createTransfer("1000000001", "1000000002", 300.0, "Transaction 3");
        
        List<Transaction> allTransactions = transactionService.getAllTransactions();
        
        assertEquals(3, allTransactions.size());
        assertTrue(allTransactions.contains(transaction1));
        assertTrue(allTransactions.contains(transaction2));
        assertTrue(allTransactions.contains(transaction3));
    }

    @Test
    @DisplayName("Should complete transaction successfully")
    void shouldCompleteTransaction() {
        Transaction transaction = transactionService.createDeposit("1000000001", 1000.0, "Test deposit");
        
        transactionService.completeTransaction(transaction.getTransactionId());
        
        Transaction found = transactionService.findTransactionById(transaction.getTransactionId());
        assertEquals(TransactionStatus.COMPLETED, found.getStatus());
    }

    @Test
    @DisplayName("Should fail transaction successfully")
    void shouldFailTransaction() {
        Transaction transaction = transactionService.createDeposit("1000000001", 1000.0, "Test deposit");
        
        transactionService.failTransaction(transaction.getTransactionId());
        
        Transaction found = transactionService.findTransactionById(transaction.getTransactionId());
        assertEquals(TransactionStatus.FAILED, found.getStatus());
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
}
