package com.mxr.bankfinal.service;

import com.mxr.bankfinal.data.repository.impl.BankRepositoryImpl;
import com.mxr.bankfinal.data.repository.impl.TransactionRepositoryImpl;
import com.mxr.bankfinal.data.repository.impl.AccountRepositoryImpl;
import com.mxr.bankfinal.service.ReceiptService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleCbnTest {
    
    @Test
    void testBankRegistration() {
        TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl();
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        ReceiptService receiptService = new ReceiptService(accountRepository);
        TransactionService transactionService = new TransactionService(transactionRepository, receiptService, accountRepository);
        CbnService cbnService = new CbnService(new BankRepositoryImpl(), transactionService);
        
        cbnService.registerBank("044");
        cbnService.registerBank("058");
        
        assertTrue(cbnService.validateBank("044"));
        assertTrue(cbnService.validateBank("058"));
        assertFalse(cbnService.validateBank("999"));
        
        System.out.println("Bank registration test passed!");
    }
    
    @Test
    void testBankServiceRegistration() {
        TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl();
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        ReceiptService receiptService = new ReceiptService(accountRepository);
        TransactionService transactionService = new TransactionService(transactionRepository, receiptService, accountRepository);
        CbnService cbnService = new CbnService(new BankRepositoryImpl(), transactionService);
        
        cbnService.registerBank("044");
        cbnService.registerBank("058");
        
        BankService service1 = cbnService.getBankService("044");
        BankService service2 = cbnService.getBankService("058");
        
        assertNotNull(service1);
        assertNotNull(service2);
        
        System.out.println("Bank service registration test passed!");
    }
}
