package data.repository;

import data.model.Bank;
import data.repository.impl.BankRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BankRepositoryImplTest {

    private BankRepositoryImpl repository;
    private Bank testBank1;
    private Bank testBank2;

    @BeforeEach
    void setUp() {
        repository = new BankRepositoryImpl();
        testBank1 = new Bank("044");
        testBank2 = new Bank("058");
    }

    @Test
    @DisplayName("Should save bank successfully")
    void shouldSaveBank() {
        repository.save(testBank1);
        
        assertTrue(repository.exists("044"));
        assertEquals(1, repository.count());
    }

    @Test
    @DisplayName("Should find bank by code")
    void shouldFindByCode() {
        repository.save(testBank1);
        
        Optional<Bank> found = repository.findByCode("044");
        
        assertTrue(found.isPresent());
        assertEquals("044", found.get().getCode());
        assertEquals("Access Bank", found.get().getName());
    }

    @Test
    @DisplayName("Should return empty when bank code not found")
    void shouldReturnEmptyWhenBankCodeNotFound() {
        Optional<Bank> found = repository.findByCode("999");
        
        assertFalse(found.isPresent());
    }

    @Test
    @DisplayName("Should find bank by name (case insensitive)")
    void shouldFindByName() {
        repository.save(testBank1);
        repository.save(testBank2);
        
        Optional<Bank> accessBank = repository.findByName("access");
        Optional<Bank> gtbBank = repository.findByName("GTB");
        Optional<Bank> nonExistent = repository.findByName("Nonexistent");
        
        assertTrue(accessBank.isPresent());
        assertTrue(gtbBank.isPresent());
        assertFalse(nonExistent.isPresent());
    }

    @Test
    @DisplayName("Should return empty when bank name not found")
    void shouldReturnEmptyWhenBankNameNotFound() {
        Optional<Bank> found = repository.findByName("Nonexistent Bank");
        
        assertFalse(found.isPresent());
    }

    @Test
    @DisplayName("Should find all banks")
    void shouldFindAllBanks() {
        repository.save(testBank1);
        repository.save(testBank2);
        
        List<Bank> allBanks = repository.findAll();
        
        assertEquals(2, allBanks.size());
        assertTrue(allBanks.contains(testBank1));
        assertTrue(allBanks.contains(testBank2));
    }

    @Test
    @DisplayName("Should return empty list when no banks exist")
    void shouldReturnEmptyListWhenNoBanksExist() {
        List<Bank> allBanks = repository.findAll();
        
        assertTrue(allBanks.isEmpty());
    }

    @Test
    @DisplayName("Should delete bank by code")
    void shouldDeleteBank() {
        repository.save(testBank1);
        repository.save(testBank2);
        
        repository.delete("044");
        
        assertFalse(repository.exists("044"));
        assertTrue(repository.exists("058"));
        assertEquals(1, repository.count());
    }

    @Test
    @DisplayName("Should not throw when deleting non-existent bank")
    void shouldNotThrowWhenDeletingNonExistentBank() {
        assertDoesNotThrow(() -> repository.delete("999"));
        assertEquals(0, repository.count());
    }

    @Test
    @DisplayName("Should check if bank exists")
    void shouldCheckBankExists() {
        repository.save(testBank1);
        
        assertTrue(repository.exists("044"));
        assertFalse(repository.exists("999"));
    }

    @Test
    @DisplayName("Should return correct bank count")
    void shouldReturnCorrectCount() {
        assertEquals(0, repository.count());
        
        repository.save(testBank1);
        assertEquals(1, repository.count());
        
        repository.save(testBank2);
        assertEquals(2, repository.count());
        
        repository.delete("044");
        assertEquals(1, repository.count());
    }

    @Test
    @DisplayName("Should handle banks with unique codes")
    void shouldHandleBanksWithUniqueCodes() {
        repository.save(testBank1);
        repository.save(testBank2);
        
        assertNotEquals(testBank1.getCode(), testBank2.getCode());
        assertTrue(repository.exists("044"));
        assertTrue(repository.exists("058"));
    }

    @Test
    @DisplayName("Should handle partial name matching")
    void shouldHandlePartialNameMatching() {
        repository.save(testBank1);
        repository.save(testBank2);
        
        Optional<Bank> partialMatch = repository.findByName("Access");
        Optional<Bank> anotherPartial = repository.findByName("Guaranty");
        
        assertTrue(partialMatch.isPresent());
        assertTrue(anotherPartial.isPresent());
    }

    @Test
    @DisplayName("Should handle banks with similar names")
    void shouldHandleBanksWithSimilarNames() {
        Bank bank3 = new Bank("032"); // Union Bank
        repository.save(testBank1); // Access Bank
        repository.save(bank3);      // Union Bank
        
        Optional<Bank> found = repository.findByName("Bank");
        
        // Should find at least one bank with "Bank" in name
        assertTrue(found.isPresent());
    }

    @Test
    @DisplayName("Should handle empty name search")
    void shouldHandleEmptyNameSearch() {
        repository.save(testBank1);
        repository.save(testBank2);
        
        Optional<Bank> emptySearch = repository.findByName("");
        
        // Should return empty since empty string doesn't match any bank name
        assertFalse(emptySearch.isPresent());
    }

    @Test
    @DisplayName("Should verify bank names from BankCode enum")
    void shouldVerifyBankNamesFromBankCodeEnum() {
        repository.save(testBank1);
        repository.save(testBank2);
        
        Optional<Bank> accessBank = repository.findByCode("044");
        Optional<Bank> gtbBank = repository.findByCode("058");
        
        assertTrue(accessBank.isPresent());
        assertTrue(gtbBank.isPresent());
        assertEquals("Access Bank", accessBank.get().getName());
        assertEquals("Guaranty Trust Bank", gtbBank.get().getName());
    }
}
