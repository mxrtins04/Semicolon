package service;

import data.model.Transaction;
import data.model.TransactionStatus;
import data.model.TransactionType;
import data.repository.impl.BankRepositoryImpl;
import data.repository.impl.TransactionRepositoryImpl;

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
        
        bankService1.deposit(1, 1000.0);
        bankService2.deposit(1, 2000.0);
    }

    @Test
    @DisplayName("Should perform intra-bank transfer successfully")
    void shouldPerformIntraBankTransfer() {
        double initialBalance1 = bankService1.getBalance(1);
        double initialBalance2 = bankService1.getBalance(2);
        
        Transaction result = cbnService.transfer("044", 1, "044", 2, 300.0, "Test transfer");
        
        assertNotNull(result);
        assertEquals(TransactionType.TRANSFER, result.getType());
        assertEquals(1, result.getFromAccount());
        assertEquals(2, result.getToAccount());
        assertEquals(300.0, result.getAmount());
        assertEquals(TransactionStatus.COMPLETED, result.getStatus());
        
        assertEquals(initialBalance1 - 300.0, bankService1.getBalance(1));
        assertEquals(initialBalance2 + 300.0, bankService1.getBalance(2));
    }

    @Test
    @DisplayName("Should perform inter-bank transfer successfully")
    void shouldPerformInterBankTransfer() {
        double initialBalance1 = bankService1.getBalance(1);
        double initialBalance2 = bankService2.getBalance(1);
        
        Transaction result = cbnService.transfer("044", 1, "058", 1, 500.0, "Inter-bank transfer");
        
        assertNotNull(result);
        assertEquals(TransactionType.TRANSFER, result.getType());
        assertEquals(1, result.getFromAccount());
        assertEquals(1, result.getToAccount());
        assertEquals(500.0, result.getAmount());
        assertEquals(TransactionStatus.COMPLETED, result.getStatus());
        
        assertEquals(initialBalance1 - 500.0, bankService1.getBalance(1));
        assertEquals(initialBalance2 + 500.0, bankService2.getBalance(1));
    }

    @Test
    @DisplayName("Should throw exception for invalid from bank code")
    void shouldThrowExceptionForInvalidFromBankCode() {
        assertThrows(IllegalArgumentException.class, 
            () -> cbnService.transfer("999", 1, "044", 2, 300.0, "Test transfer"));
    }

    @Test
    @DisplayName("Should throw exception for invalid to bank code")
    void shouldThrowExceptionForInvalidToBankCode() {
        assertThrows(IllegalArgumentException.class, 
            () -> cbnService.transfer("044", 1, "999", 2, 300.0, "Test transfer"));
    }

    @Test
    @DisplayName("Should throw exception for non-existent from account")
    void shouldThrowExceptionForNonExistentFromAccount() {
        assertThrows(IllegalArgumentException.class, 
            () -> cbnService.transfer("044", 999, "044", 2, 300.0, "Test transfer"));
    }

    @Test
    @DisplayName("Should throw exception for non-existent to account")
    void shouldThrowExceptionForNonExistentToAccount() {
        assertThrows(IllegalArgumentException.class, 
            () -> cbnService.transfer("044", 1, "058", 999, 300.0, "Test transfer"));
    }

    @Test
    @DisplayName("Should throw exception for unregistered bank service")
    void shouldThrowExceptionForUnregisteredBankService() {
        assertThrows(IllegalArgumentException.class, 
            () -> cbnService.transfer("032", 1, "044", 2, 300.0, "Test transfer"));
    }

    @Test
    @DisplayName("Should throw exception for insufficient funds")
    void shouldThrowExceptionForInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, 
            () -> cbnService.transfer("044", 1, "044", 2, 2000.0, "Test transfer"));
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
        assertTrue(cbnService.validateAccount("044", 1));
        assertTrue(cbnService.validateAccount("044", 2));
        assertTrue(cbnService.validateAccount("058", 1));
        assertFalse(cbnService.validateAccount("044", 999));
        assertFalse(cbnService.validateAccount("999", 1));
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
        double initialBalance1 = bankService1.getBalance(1);
        double initialBalance2 = bankService1.getBalance(2);
        double initialBalance3 = bankService2.getBalance(1);
        
        Transaction result1 = cbnService.transfer("044", 1, "044", 2, 100.0, "Transfer 1");
        Transaction result2 = cbnService.transfer("044", 1, "058", 1, 200.0, "Transfer 2");
        
        assertNotNull(result1);
        assertNotNull(result2);
        
        assertEquals(initialBalance1 - 300.0, bankService1.getBalance(1));
        assertEquals(initialBalance2 + 100.0, bankService1.getBalance(2));
        assertEquals(initialBalance3 + 200.0, bankService2.getBalance(1));
    }

    @Test
    @DisplayName("Should handle zero amount transfer")
    void shouldHandleZeroAmountTransfer() {
        double initialBalance1 = bankService1.getBalance(1);
        double initialBalance2 = bankService1.getBalance(2);
        
        Transaction result = cbnService.transfer("044", 1, "044", 2, 0.0, "Zero transfer");
        
        assertNotNull(result);
        assertEquals(0.0, result.getAmount());
        assertEquals(initialBalance1, bankService1.getBalance(1));
        assertEquals(initialBalance2, bankService1.getBalance(2));
    }

    @Test
    @DisplayName("Should handle large amount transfers")
    void shouldHandleLargeAmountTransfers() {
        double initialBalance1 = bankService1.getBalance(1);
        double initialBalance2 = bankService1.getBalance(2);
        
        Transaction result = cbnService.transfer("044", 1, "044", 2, 999.0, "Large transfer");
        
        assertNotNull(result);
        assertEquals(999.0, result.getAmount());
        assertEquals(initialBalance1 - 999.0, bankService1.getBalance(1));
        assertEquals(initialBalance2 + 999.0, bankService1.getBalance(2));
    }

    @Test
    @DisplayName("Should register multiple bank services")
    void shouldRegisterMultipleBankServices() {
        BankService bankService3 = new BankService("032", new data.repository.impl.AccountRepositoryImpl(), transactionService);
        bankService3.createAccount("Test User", "test@email.com", "password");
        
        cbnService.registerBankService("032", bankService3);
        
        assertTrue(cbnService.validateAccount("032", 1));
        assertTrue(cbnService.validateBank("032"));
    }

    @Test
    @DisplayName("Should handle transfer with long descriptions")
    void shouldHandleTransferWithLongDescriptions() {
        String longDescription = "This is a very long transfer description that contains many words and characters to test if the system can handle it properly without any issues or problems arising from the length of the description field.";
        
        Transaction result = cbnService.transfer("044", 1, "044", 2, 100.0, longDescription);
        
        assertNotNull(result);
        assertTrue(result.getDescription().contains("Intra-bank"));
        assertTrue(result.getDescription().contains(longDescription));
    }
}
