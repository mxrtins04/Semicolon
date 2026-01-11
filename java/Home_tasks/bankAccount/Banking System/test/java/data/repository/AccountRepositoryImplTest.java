package test.java.data.repository;

import data.model.Account;
import data.repository.impl.AccountRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {

    private AccountRepositoryImpl repository;
    private Account testAccount1;
    private Account testAccount2;

    @BeforeEach
    void setUp() {
        repository = new AccountRepositoryImpl();
        testAccount1 = new Account("John Doe", "john@email.com", "password123", 1001);
        testAccount2 = new Account("Jane Smith", "jane@email.com", "password456", 1002);
    }

    @Test
    @DisplayName("Should save account successfully")
    void shouldSaveAccount() {
        repository.save(testAccount1);
        
        assertTrue(repository.exists(1001));
        assertEquals(1, repository.count());
    }

    @Test
    @DisplayName("Should find account by account number")
    void shouldFindByAccountNumber() {
        repository.save(testAccount1);
        
        Optional<Account> found = repository.findByAccountNumber(1001);
        
        assertTrue(found.isPresent());
        assertEquals("John Doe", found.get().getName());
        assertEquals("john@email.com", found.get().getEmail());
        assertEquals(1001, found.get().getAccountNumber());
    }

    @Test
    @DisplayName("Should return empty when account not found")
    void shouldReturnEmptyWhenAccountNotFound() {
        Optional<Account> found = repository.findByAccountNumber(9999);
        
        assertFalse(found.isPresent());
    }

    @Test
    @DisplayName("Should find accounts by email")
    void shouldFindByEmail() {
        repository.save(testAccount1);
        repository.save(testAccount2);
        
        List<Account> johnsAccounts = repository.findByEmail("john@email.com");
        
        assertEquals(1, johnsAccounts.size());
        assertEquals("John Doe", johnsAccounts.get(0).getName());
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
        
        repository.delete(1001);
        
        assertFalse(repository.exists(1001));
        assertTrue(repository.exists(1002));
        assertEquals(1, repository.count());
    }

    @Test
    @DisplayName("Should not throw when deleting non-existent account")
    void shouldNotThrowWhenDeletingNonExistentAccount() {
        assertDoesNotThrow(() -> repository.delete(9999));
        assertEquals(0, repository.count());
    }

    @Test
    @DisplayName("Should check if account exists")
    void shouldCheckAccountExists() {
        repository.save(testAccount1);
        
        assertTrue(repository.exists(1001));
        assertFalse(repository.exists(9999));
    }

    @Test
    @DisplayName("Should return correct account count")
    void shouldReturnCorrectCount() {
        assertEquals(0, repository.count());
        
        repository.save(testAccount1);
        assertEquals(1, repository.count());
        
        repository.save(testAccount2);
        assertEquals(2, repository.count());
        
        repository.delete(1001);
        assertEquals(1, repository.count());
    }

    @Test
    @DisplayName("Should handle multiple accounts with same email")
    void shouldHandleMultipleAccountsSameEmail() {
        Account account3 = new Account("John Doe", "john@email.com", "password789", 1003);
        repository.save(testAccount1);
        repository.save(account3);
        
        List<Account> johnsAccounts = repository.findByEmail("john@email.com");
        
        assertEquals(2, johnsAccounts.size());
    }

    @Test
    @DisplayName("Should save accounts with different account numbers")
    void shouldSaveAccountsWithDifferentNumbers() {
        repository.save(testAccount1);
        repository.save(testAccount2);
        
        Optional<Account> found1 = repository.findByAccountNumber(1001);
        Optional<Account> found2 = repository.findByAccountNumber(1002);
        
        assertTrue(found1.isPresent());
        assertTrue(found2.isPresent());
        assertNotSame(found1.get(), found2.get());
    }
}
