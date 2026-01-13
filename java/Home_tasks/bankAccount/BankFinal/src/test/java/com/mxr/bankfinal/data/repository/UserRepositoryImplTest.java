package com.mxr.bankfinal.data.repository;

import com.mxr.bankfinal.data.model.User;
import com.mxr.bankfinal.data.repository.impl.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {

    private UserRepositoryImpl repository;
    private User testUser1;
    private User testUser2;
    private User testUser3;

    @BeforeEach
    void setUp() {
        repository = new UserRepositoryImpl();
        testUser1 = new User("John Doe", "john@email.com");
        testUser2 = new User("Jane Smith", "jane@email.com");
        testUser3 = new User("John Smith", "johnsmith@email.com");
    }

    @Test
    @DisplayName("Should save user successfully")
    void shouldSaveUser() {
        repository.save(testUser1);
        
        assertTrue(repository.exists(testUser1.getBvn()));
        assertEquals(1, repository.count());
    }

    @Test
    @DisplayName("Should find user by BVN")
    void shouldFindByBvn() {
        repository.save(testUser1);
        
        Optional<User> found = repository.findByBvn(testUser1.getBvn());
        
        assertTrue(found.isPresent());
        assertEquals("John Doe", found.get().getName());
        assertEquals("john@email.com", found.get().getEmail());
        assertEquals(testUser1.getBvn(), found.get().getBvn());
    }

    @Test
    @DisplayName("Should return empty when BVN not found")
    void shouldReturnEmptyWhenBvnNotFound() {
        Optional<User> found = repository.findByBvn("NONEXISTENT");
        
        assertFalse(found.isPresent());
    }

    @Test
    @DisplayName("Should find user by email")
    void shouldFindByEmail() {
        repository.save(testUser1);
        repository.save(testUser2);
        
        Optional<User> found = repository.findByEmail("john@email.com");
        
        assertTrue(found.isPresent());
        assertEquals("John Doe", found.get().getName());
    }

    @Test
    @DisplayName("Should return empty when email not found")
    void shouldReturnEmptyWhenEmailNotFound() {
        Optional<User> found = repository.findByEmail("nonexistent@email.com");
        
        assertFalse(found.isPresent());
    }

    @Test
    @DisplayName("Should find users by name (case insensitive)")
    void shouldFindByName() {
        repository.save(testUser1);
        repository.save(testUser2);
        repository.save(testUser3);
        
        List<User> johns = repository.findByName("john");
        List<User> does = repository.findByName("doe");
        List<User> smiths = repository.findByName("smith");
        
        assertEquals(2, johns.size()); 
        assertEquals(1, does.size()); 
        assertEquals(2, smiths.size()); 
    }

    @Test
    @DisplayName("Should return empty list when name not found")
    void shouldReturnEmptyListWhenNameNotFound() {
        List<User> users = repository.findByName("nonexistent");
        
        assertTrue(users.isEmpty());
    }

    @Test
    @DisplayName("Should find all users")
    void shouldFindAllUsers() {
        repository.save(testUser1);
        repository.save(testUser2);
        repository.save(testUser3);
        
        List<User> allUsers = repository.findAll();
        
        assertEquals(3, allUsers.size());
        assertTrue(allUsers.contains(testUser1));
        assertTrue(allUsers.contains(testUser2));
        assertTrue(allUsers.contains(testUser3));
    }

    @Test
    @DisplayName("Should return empty list when no users exist")
    void shouldReturnEmptyListWhenNoUsersExist() {
        List<User> allUsers = repository.findAll();
        
        assertTrue(allUsers.isEmpty());
    }


    @Test
    @DisplayName("Should not throw when deleting non-existent user")
    void shouldNotThrowWhenDeletingNonExistentUser() {
        assertDoesNotThrow(() -> repository.delete("NONEXISTENT"));
        assertEquals(0, repository.count());
    }

    @Test
    @DisplayName("Should check if user exists by BVN")
    void shouldCheckUserExists() {
        repository.save(testUser1);
        
        assertTrue(repository.exists(testUser1.getBvn()));
        assertFalse(repository.exists("NONEXISTENT"));
    }

    @Test
    @DisplayName("Should check if user exists by email")
    void shouldCheckEmailExists() {
        repository.save(testUser1);
        
        assertTrue(repository.existsByEmail("john@email.com"));
        assertFalse(repository.existsByEmail("nonexistent@email.com"));
    }


    @Test
    @DisplayName("Should handle users with same name")
    void shouldHandleUsersSameName() {
        User user4 = new User("John Doe", "johndoe2@email.com");
        repository.save(testUser1);
        repository.save(user4);
        
        List<User> johnDoes = repository.findByName("John Doe");
        
        assertEquals(2, johnDoes.size());
    }

    @Test
    @DisplayName("Should handle partial name matching")
    void shouldHandlePartialNameMatching() {
        repository.save(testUser1);
        repository.save(testUser2);
        
        List<User> partialMatch = repository.findByName("Jo");
        
        assertEquals(1, partialMatch.size());
    }

    @Test
    @DisplayName("Should handle empty name search")
    void shouldHandleEmptyNameSearch() {
        repository.save(testUser1);
        repository.save(testUser2);
        
        List<User> emptySearch = repository.findByName("");
        
    
        assertTrue(emptySearch.size() >= 2);
    }
}
