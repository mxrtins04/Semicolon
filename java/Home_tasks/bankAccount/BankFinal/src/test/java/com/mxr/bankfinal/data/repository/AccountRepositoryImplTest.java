package com.mxr.bankfinal.data.repository;
import com.mxr.bankfinal.data.model.Account;
import com.mxr.bankfinal.data.repository.impl.AccountRepositoryImpl;
import com.mxr.bankfinal.data.repository.impl.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {

    private AccountRepositoryImpl repository;
    private UserRepositoryImpl userRepository;
    private Account testAccount1;
    private Account testAccount2;

    @BeforeEach
    void setUp() {
        repository = new AccountRepositoryImpl();
        userRepository = new UserRepositoryImpl();
        testAccount1 = new Account("Ekwethebabesnatcher", "ekwethebabesnatcher@rmail.com", "password123");
        testAccount1.setAccountNumber("1001");
        testAccount2 = new Account("Jegede", "jegede@rmail.com", "password456");
        testAccount2.setAccountNumber("1002");

    }




    @Test
    @DisplayName("Should save account successfully")
    void shouldSaveAccount() {
        repository.save(testAccount1);
        
        assertTrue(repository.exists("1001"));
        assertEquals(1, repository.count());
    }

    @Test
    @DisplayName("Should find account by account number")
    void shouldFindByAccountNumber() {
        repository.save(testAccount1);
        
        Account found = repository.findByAccountNumber("1001");
        
        assertNotNull(found);
        assertEquals("Ekwethebabesnatcher", found.getName());
        assertEquals("ekwethebabesnatcher@rmail.com", found.getEmail());
        assertEquals("1001", found.getAccountNumber());
    }

    @Test
    @DisplayName("Should return empty when account not found")
    void shouldReturnEmptyWhenAccountNotFound() {
        String TA2AccountNumber = testAccount2.getAccountNumber();
        Account found = repository.findByAccountNumber(TA2AccountNumber);
        assertNull(found);
    }

    @Test
    @DisplayName("Should find accounts by email")
    void shouldFindByEmail() {
        repository.save(testAccount1);
        repository.save(testAccount2);
        
        List<Account> johnsAccounts = repository.findByEmail("ekwethebabesnatcher@rmail.com");
        
        assertEquals(1, johnsAccounts.size());
        assertEquals("Ekwethebabesnatcher", johnsAccounts.get(0).getName());
    }

    @Test
    @DisplayName("Should return empty list when email not found")
    void shouldReturnEmptyListWhenEmailNotFound() {
        List<Account> accounts = repository.findByEmail("nonexistent@email.com");
        
        assertTrue(accounts.isEmpty());
    }

    @Test
    @DisplayName("Should find all accounts")
    void shouldFindAllAccounts() {
        repository.save(testAccount1);
        repository.save(testAccount2);
        
        List<Account> allAccounts = repository.findAll();
        
        assertEquals(2, allAccounts.size());
        assertTrue(allAccounts.contains(testAccount1));
        assertTrue(allAccounts.contains(testAccount2));
    }

    @Test
    @DisplayName("Should return empty list when no accounts exist")
    void shouldReturnEmptyListWhenNoAccountsExist() {
        List<Account> allAccounts = repository.findAll();
        
        assertTrue(allAccounts.isEmpty());
    }

    @Test
    @DisplayName("Should delete account by account number")
    void shouldDeleteAccount() {
        repository.save(testAccount1);
        repository.save(testAccount2);
        String TA2AccountNumber = testAccount2.getAccountNumber();
        String TA1AccountNumber = testAccount1.getAccountNumber();
        
        repository.delete(TA1AccountNumber);
        
        assertFalse(repository.exists(TA1AccountNumber));
        assertTrue(repository.exists(TA2AccountNumber));
        assertEquals(1, repository.count());
    }

    @Test
    @DisplayName("Should not throw when deleting non-existent account")
    void shouldNotThrowWhenDeletingNonExistentAccount() {

        assertDoesNotThrow(() -> repository.delete("8877"));
        assertEquals(0, repository.count());
    }

    @Test
    @DisplayName("Should check if account exists")
    void shouldCheckAccountExists() {
        repository.save(testAccount1);
        String TA2AccountNumber = testAccount2.getAccountNumber();
        String TA1AccountNumber = testAccount1.getAccountNumber();
        assertTrue(repository.exists(TA1AccountNumber));
        assertFalse(repository.exists(TA2AccountNumber));
    }

    @Test
    @DisplayName("Should return correct account count")
    void shouldReturnCorrectCount() {
        String TA2AccountNumber = testAccount2.getAccountNumber();
        String TA1AccountNumber = testAccount1.getAccountNumber();
        assertEquals(0, repository.count());
        
        repository.save(testAccount1);
        assertEquals(1, repository.count());
        
        repository.save(testAccount2);
        assertEquals(2, repository.count());
        
        repository.delete(TA1AccountNumber);
        assertEquals(1, repository.count());
    }



}
