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
        testUser1 = new User("Ekwethebabesnatcher", "ekwethebabesnatcher@rmail.com");
        testUser2 = new User("Jegede", "jegede@rmail.com");
        testUser3 = new User("Akande", "akande@rmail.com");
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
        
        User found = repository.findByBvn(testUser1.getBvn());
        
        assertNotNull(found);
        assertEquals("Ekwethebabesnatcher", found.getName());
        assertEquals("ekwethebabesnatcher@rmail.com", found.getEmail());
        assertEquals(testUser1.getBvn(), found.getBvn());
    }

    @Test
    @DisplayName("Should return empty when BVN not found")
    void shouldReturnEmptyWhenBvnNotFound() {
        User found = repository.findByBvn("NONEXISTENT");
        
        assertNull(found);
    }

    @Test
    @DisplayName("Should find user by email")
    void shouldFindByEmail() {
        repository.save(testUser1);
        repository.save(testUser2);
        
        User found = repository.findByEmail("ekwethebabesnatcher@rmail.com");
        
        assertNotNull(found);
        assertEquals("Ekwethebabesnatcher", found.getName());
    }

    @Test
    @DisplayName("Should return empty when email not found")
    void shouldReturnEmptyWhenEmailNotFound() {
        User found = repository.findByEmail("nonexistent@rmail.com");
        
        assertNull(found);
    }

    @Test
    @DisplayName("Should find users by name (case insensitive)")
    void shouldFindByName() {
        repository.save(testUser1);
        repository.save(testUser2);
        repository.save(testUser3);
        
        List<User> akandes = repository.findByName("akande");
        List<User> jegedes = repository.findByName("jegede");
        List<User> ekwethebabesnatchers = repository.findByName("ekwethebabesnatcher");
        
        assertEquals(1, akandes.size()); 
        assertEquals(1, jegedes.size()); 
        assertEquals(1, ekwethebabesnatchers.size()); 
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
        
        assertTrue(repository.existsByEmail("ekwethebabesnatcher@rmail.com"));
        assertFalse(repository.existsByEmail("nonexistent@rmail.com"));
    }


    @Test
    @DisplayName("Should handle users with same name")
    void shouldHandleUsersSameName() {
        User user4 = new User("Ekwethebabesnatcher", "ekwethebabesnatcher2@rmail.com");
        repository.save(testUser1);
        repository.save(user4);
        
        List<User> ekwethebabesnatchers = repository.findByName("Ekwethebabesnatcher");
        
        assertEquals(2, ekwethebabesnatchers.size());
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
