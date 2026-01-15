package com.mxr.bankfinal.service;

import com.mxr.bankfinal.data.model.User;
import com.mxr.bankfinal.data.repository.impl.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import com.mxr.bankfinal.service.UserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;
    private UserRepositoryImpl userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepositoryImpl();
        userService = new UserService(userRepository);
    }

    @Test
    @DisplayName("Should create user successfully")
    void shouldCreateUser() {
        User created = userService.createUser("Jegede", "jegede@rmail.com");
        
        assertNotNull(created);
        assertEquals("Jegede", created.getName());
        assertEquals("jegede@rmail.com", created.getEmail());
        assertNotNull(created.getBvn());
        assertTrue(userService.userExists(created.getBvn()));
        assertTrue(userService.emailExists("jegede@rmail.com"));
    }

    @Test
    @DisplayName("Should throw exception when creating user with existing email")
    void shouldThrowExceptionWhenCreatingUserWithExistingEmail() {
        userService.createUser("Jegede", "john@email.com");
        
        assertThrows(IllegalArgumentException.class, 
            () -> userService.createUser("Akande", "john@email.com"));
    }

    @Test
    @DisplayName("Should create multiple users with unique BVNs")
    void shouldCreateMultipleUsersWithUniqueBvns() {
        User user1 = userService.createUser("Jegede", "john@email.com");
        User user2 = userService.createUser("Akande", "jane@email.com");
        
        assertNotEquals(user1.getBvn(), user2.getBvn());
        assertTrue(userService.userExists(user1.getBvn()));
        assertTrue(userService.userExists(user2.getBvn()));
    }

    @Test
    @DisplayName("Should find user by BVN")
    void shouldFindByBvn() {
        User created = userService.createUser("Jegede", "jegede@rmail.com");
        
        User found = userService.findByBvn(created.getBvn());
        
        assertNotNull(found);
        assertEquals(created.getName(), found.getName());
        assertEquals(created.getEmail(), found.getEmail());
        assertEquals(created.getBvn(), found.getBvn());
    }

    @Test
    @DisplayName("Should return null when BVN not found")
    void shouldReturnNullWhenBvnNotFound() {
        User found = userService.findByBvn("NONEXISTENT");
        
        assertNull(found);
    }

    @Test
    @DisplayName("Should find user by email")
    void shouldFindByEmail() {
        User created = userService.createUser("Jegede", "jegede@rmail.com");
        
        User found = userService.findByEmail("jegede@rmail.com");
        
        assertNotNull(found);
        assertEquals(created.getName(), found.getName());
        assertEquals(created.getEmail(), found.getEmail());
    }

    @Test
    @DisplayName("Should return null when email not found")
    void shouldReturnNullWhenEmailNotFound() {
        User found = userService.findByEmail("nonexistent@rmail.com");
        
        assertNull(found);
    }

    @Test
    @DisplayName("Should find users by name")
    void shouldFindByName() {
        User user1 = userService.createUser("Jegede", "jegede@email.com");
        User user2 = userService.createUser("john", "john@email.com");
        User user3 = userService.createUser("John Smith", "johnsmith@email.com");
        
        List<User> johns = userService.findByName("john");
        
        assertEquals(2, johns.size()); 
         
    }

    @Test
    @DisplayName("Should return empty list when name not found")
    void shouldReturnEmptyListWhenNameNotFound() {
        List<User> users = userService.findByName("nonexistent");
        
        assertTrue(users.isEmpty());
    }

    @Test
    @DisplayName("Should get all users")
    void shouldGetAllUsers() {
        User user1 = userService.createUser("Jegede", "john@email.com");
        User user2 = userService.createUser("Akande", "jane@email.com");
        User user3 = userService.createUser("Bob Johnson", "bob@email.com");
        
        List<User> allUsers = userService.getAllUsers();
        
        assertEquals(3, allUsers.size());
        assertTrue(allUsers.contains(user1));
        assertTrue(allUsers.contains(user2));
        assertTrue(allUsers.contains(user3));
    }

    @Test
    @DisplayName("Should return empty list when no users exist")
    void shouldReturnEmptyListWhenNoUsersExist() {
        List<User> allUsers = userService.getAllUsers();
        
        assertTrue(allUsers.isEmpty());
    }

    @Test
    @DisplayName("Should delete user by BVN")
    void shouldDeleteUser() {
        User user1 = userService.createUser("Jegede", "john@email.com");
        User user2 = userService.createUser("Akande", "jane@email.com");
        
        userService.deleteUser(user1.getBvn());
        
        assertFalse(userService.userExists(user1.getBvn()));
        assertTrue(userService.userExists(user2.getBvn()));
        assertFalse(userService.emailExists("john@email.com"));
        assertTrue(userService.emailExists("jane@email.com"));
    }

    @Test
    @DisplayName("Should throw exception when creating user with null email")
    void shouldThrowExceptionWhenCreatingUserWithNullEmail() {
        assertThrows(IllegalArgumentException.class, 
            () -> userService.createUser("Jegede", null));
    }

    @Test
    @DisplayName("Should check if user exists by BVN")
    void shouldCheckUserExists() {
        User created = userService.createUser("Jegede", "jegede@rmail.com");
        
        assertTrue(userService.userExists(created.getBvn()));
        assertFalse(userService.userExists("NONEXISTENT"));
    }

    @Test
    @DisplayName("Should check if email exists")
    void shouldCheckEmailExists() {
        userService.createUser("jj", "john@email.com");
        
        assertTrue(userService.emailExists("john@email.com"));
        assertFalse(userService.emailExists("nonexistent@email.com"));
    }

    @Test
    @DisplayName("Should handle users with same name")
    void shouldHandleUsersSameName() {
        User user1 = userService.createUser("jj", "jj@email.com");
        User user2 = userService.createUser("jj", "kk@email.com");
        
        List<User> jjs = userService.findByName("jj");
        
        assertEquals(2, jjs.size());
        assertTrue(jjs.contains(user1));
        assertTrue(jjs.contains(user2));
    }

    @Test
    @DisplayName("Should handle partial name matching")
    void shouldHandlePartialNameMatching() {
        User user1 = userService.createUser("SS", "ss@rmail.com");
        User user2 = userService.createUser("John", "john@rmail.com");
        
        List<User> partialMatch = userService.findByName("s");
        
        assertEquals(1, partialMatch.size());
        assertTrue(partialMatch.contains(user1));
    }

    @Test
    @DisplayName("Should handle empty name search")
    void shouldHandleEmptyNameSearch() {
        User user1 = userService.createUser("Akande", "akande@rmail.com");
        User user2 = userService.createUser("JJ", "jj@rmail.com");
        
        List<User> emptySearch = userService.findByName("");
        
        assertEquals(2, emptySearch.size());
    }

    @Test
    @DisplayName("Should handle case insensitive email search")
    void shouldHandleCaseInsensitiveEmailSearch() {
        userService.createUser("Mo", "mo@rmail.com");
         
        assertTrue(userService.emailExists("mo@rmail.com"));
        assertFalse(userService.emailExists("MO@RMAIL.COM"));
    }

    @Test
    @DisplayName("Should handle special characters in names")
    void shouldHandleSpecialCharactersInNames() {
        User user1 = userService.createUser("Sade", "sade@rmail.com");
        User user2 = userService.createUser("Ekwethebabesnatcher", "ekwethebabesnatcher@rmail.com");
        User user3 = userService.createUser("Jegede", "jegede@rmail.com");
        
        User found1 = userService.findByEmail("sade@rmail.com");
        User found2 = userService.findByEmail("ekwethebabesnatcher@rmail.com");
        User found3 = userService.findByEmail("jegede@rmail.com");
        
        assertNotNull(found1);
        assertNotNull(found2);
        assertNotNull(found3);
        assertEquals("Sade", found1.getName());
        assertEquals("Ekwethebabesnatcher", found2.getName());
        assertEquals("Jegede", found3.getName());
    }

    @Test
    @DisplayName("Should handle long email addresses")
    void shouldHandleLongEmailAddresses() {
        String longEmail = "very.long.email.address.with.many.words.and.numbers.123456789@rmail.com";
        User created = userService.createUser("Akande", longEmail);
        
        assertTrue(userService.emailExists(longEmail));
        assertEquals(longEmail, created.getEmail());
    }

    @Test
    @DisplayName("Should handle users with different BVN formats")
    void shouldHandleUsersWithDifferentBvnFormats() {
        User user1 = userService.createUser("John", "john@rmail.com");
        User user2 = userService.createUser("Mo", "mo@rmail.com");
        
        String bvn1 = user1.getBvn();
        String bvn2 = user2.getBvn();
        
        assertNotNull(bvn1);
        assertNotNull(bvn2);
        assertNotEquals(bvn1, bvn2);
        assertFalse(bvn1.trim().isEmpty());
        assertFalse(bvn2.trim().isEmpty());
    }
}
