package com.mxr.bankfinal.service;
import com.mxr.bankfinal.data.model.Transaction;
import com.mxr.bankfinal.data.model.TransactionStatus;
import com.mxr.bankfinal.data.model.TransactionType;
import com.mxr.bankfinal.data.repository.impl.BankRepositoryImpl;
import com.mxr.bankfinal.data.repository.impl.TransactionRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CbnServiceTest {

    private CbnService cbnService;
    private TransactionService transactionService;
    private BankService bankService1;
    private BankService bankService2;
    private TransactionRepositoryImpl transactionRepository;

    @BeforeEach
    void setUp() {
        transactionRepository = new TransactionRepositoryImpl();
        transactionService = new TransactionService(transactionRepository);
        cbnService = new CbnService(new BankRepositoryImpl(), transactionService);
        
        bankService1 = new BankService("044", new data.repository.impl.AccountRepositoryImpl(), transactionService);
        bankService2 = new BankService("058", new data.repository.impl.AccountRepositoryImpl(), transactionService);
        
        cbnService.registerBankService("044", bankService1);
        cbnService.registerBankService("058", bankService2);
        
        bankService1.createAccount("John Doe", "john@email.com", "password123");
        bankService1.createAccount("Jane Smith", "jane@email.com", "password456");
        bankService2.createAccount("Bob Johnson", "bob@email.com", "password789");
        bankService2.createAccount("Alice Brown", "alice@email.com", "password012");
        
        bankService1.deposit("1000000001", 1000.0);
        bankService2.deposit("2000000001", 2000.0);

        String acc1 = "1000000001";
        String acc2 = "1000000002";
        String acc3 = "2000000001";
        String acc4 = "2000000002";
        String invalidAcc = "9999999999";
    }

    @Test
    @DisplayName("Should perform intra-bank transfer successfully")
    void shouldPerformIntraBankTransfer() {
        double initialBalance1 = bankService1.getBalance("1000000001");
        double initialBalance2 = bankService1.getBalance("1000000002");
        
        Transaction result = cbnService.transfer("044", "1000000001", "044", "1000000002", 300.0, "Test transfer");
        
        assertNotNull(result);
        assertEquals(TransactionType.TRANSFER, result.getType());
        assertEquals("1000000001", result.getFromAccount());
        assertEquals("1000000002", result.getToAccount());
        assertEquals(300.0, result.getAmount());
        assertEquals(TransactionStatus.COMPLETED, result.getStatus());
        
        assertEquals(initialBalance1 - 300.0, bankService1.getBalance("1000000001"));
        assertEquals(initialBalance2 + 300.0, bankService1.getBalance("1000000002"));
    }

    @Test
    @DisplayName("Should perform inter-bank transfer successfully")
    void shouldPerformInterBankTransfer() {
        double initialBalance1 = bankService1.getBalance("1000000001");
        double initialBalance2 = bankService2.getBalance("2000000001");
        
        Transaction result = cbnService.transfer("044", "1000000001", "058", "2000000001", 500.0, "Inter-bank transfer");
        
        assertNotNull(result);
        assertEquals(TransactionType.TRANSFER, result.getType());
        assertEquals("1000000001", result.getFromAccount());
        assertEquals("2000000001", result.getToAccount());
        assertEquals(500.0, result.getAmount());
        assertEquals(TransactionStatus.COMPLETED, result.getStatus());
        
        assertEquals(initialBalance1 - 500.0, bankService1.getBalance("1000000001"));
        assertEquals(initialBalance2 + 500.0, bankService2.getBalance("2000000001"));
    }

    @Test
    @DisplayName("Should throw exception for invalid from bank code")
    void shouldThrowExceptionForInvalidFromBankCode() {
        assertThrows(IllegalArgumentException.class, 
            () -> cbnService.transfer("999", "1000000001", "044", "1000000002", 300.0, "Test transfer"));
    }

    @Test
    @DisplayName("Should throw exception for invalid to bank code")
    void shouldThrowExceptionForInvalidToBankCode() {
        assertThrows(IllegalArgumentException.class, 
            () -> cbnService.transfer("044", "1000000001", "999", "1000000002", 300.0, "Test transfer"));
    }

    @Test
    @DisplayName("Should throw exception for non-existent from account")
    void shouldThrowExceptionForNonExistentFromAccount() {
        assertThrows(IllegalArgumentException.class, 
            () -> cbnService.transfer("044", "9999999999", "044", "1000000002", 300.0, "Test transfer"));
    }

    @Test
    @DisplayName("Should throw exception for non-existent to account")
    void shouldThrowExceptionForNonExistentToAccount() {
        assertThrows(IllegalArgumentException.class, 
            () -> cbnService.transfer("044", "1000000001", "058", "9999999999", 300.0, "Test transfer"));
    }

    @Test
    @DisplayName("Should throw exception for unregistered bank service")
    void shouldThrowExceptionForUnregisteredBankService() {
        assertThrows(IllegalArgumentException.class, 
            () -> cbnService.transfer("032", "1000000001", "044", "1000000002", 300.0, "Test transfer"));
    }

    @Test
    @DisplayName("Should throw exception for insufficient funds")
    void shouldThrowExceptionForInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, 
            () -> cbnService.transfer("044", "1000000001", "044", "1000000002", 2000.0, "Test transfer"));
    }

    @Test
    @DisplayName("Should validate bank codes correctly")
    void shouldValidateBankCodes() {
        assertTrue(cbnService.validateBank("044"));
        assertTrue(cbnService.validateBank("058"));
        assertTrue(cbnService.validateBank("011"));
        assertFalse(cbnService.validateBank("999"));
        assertFalse(cbnService.validateBank("INVALID"));
    }

    @Test
    @DisplayName("Should validate accounts correctly")
    void shouldValidateAccounts() {
        assertTrue(cbnService.validateAccount("044", "1000000001"));
        assertTrue(cbnService.validateAccount("044", "1000000002"));
        assertTrue(cbnService.validateAccount("058", "2000000001"));
        assertFalse(cbnService.validateAccount("044", "9999999999"));
        assertFalse(cbnService.validateAccount("999", "1000000001"));
    }

    @Test
    @DisplayName("Should get bank names correctly")
    void shouldGetBankNames() {
        assertEquals("Access Bank", cbnService.getBankName("044"));
        assertEquals("Guaranty Trust Bank", cbnService.getBankName("058"));
        assertEquals("First Bank of Nigeria", cbnService.getBankName("011"));
        assertNull(cbnService.getBankName("999"));
        assertNull(cbnService.getBankName("INVALID"));
    }

    @Test
    @DisplayName("Should get all bank codes")
    void shouldGetAllBankCodes() {
        List<String> bankCodes = cbnService.getAllBankCodes();
        
        assertNotNull(bankCodes);
        assertFalse(bankCodes.isEmpty());
        assertTrue(bankCodes.contains("044"));
        assertTrue(bankCodes.contains("058"));
        assertTrue(bankCodes.contains("011"));
    }

    @Test
    @DisplayName("Should handle multiple transfers")
    void shouldHandleMultipleTransfers() {
        String acc1 = "1000000001";
        String acc2 = "1000000002";
        String acc3 = "2000000001";
        
        double initialBalance1 = bankService1.getBalance(acc1);
        double initialBalance2 = bankService1.getBalance(acc2);
        double initialBalance3 = bankService2.getBalance(acc3);
        
        Transaction result1 = cbnService.transfer("044", acc1, "044", acc2, 100.0, "Transfer 1");
        Transaction result2 = cbnService.transfer("044", acc1, "058", acc3, 200.0, "Transfer 2");
        
        assertNotNull(result1);
        assertNotNull(result2);
        
        assertEquals(initialBalance1 - 300.0, bankService1.getBalance(acc1));
        assertEquals(initialBalance2 + 100.0, bankService1.getBalance(acc2));
        assertEquals(initialBalance3 + 200.0, bankService2.getBalance(acc3));
    }

    @Test
    @DisplayName("Should handle zero amount transfer")
    void shouldHandleZeroAmountTransfer() {
        String acc1 = "1000000001";
        String acc2 = "1000000002";
        
        double initialBalance1 = bankService1.getBalance(acc1);
        double initialBalance2 = bankService1.getBalance(acc2);
        
        Transaction result = cbnService.transfer("044", acc1, "044", acc2, 0.0, "Zero transfer");
        
        assertNotNull(result);
        assertEquals(0.0, result.getAmount());
        assertEquals(initialBalance1, bankService1.getBalance(acc1));
        assertEquals(initialBalance2, bankService1.getBalance(acc2));
    }

}
