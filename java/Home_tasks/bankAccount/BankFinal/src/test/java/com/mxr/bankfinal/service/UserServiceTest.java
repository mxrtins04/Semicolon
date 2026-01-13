package service;

import data.model.User;
import data.repository.impl.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import service.UserService;

import java.util.List;
import java.util.Optional;

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
        User created = userService.createUser("John Doe", "john@email.com");
        
        assertNotNull(created);
        assertEquals("John Doe", created.getName());
        assertEquals("john@email.com", created.getEmail());
        assertNotNull(created.getBvn());
        assertTrue(userService.userExists(created.getBvn()));
        assertTrue(userService.emailExists("john@email.com"));
    }

    @Test
    @DisplayName("Should throw exception when creating user with existing email")
    void shouldThrowExceptionWhenCreatingUserWithExistingEmail() {
        userService.createUser("John Doe", "john@email.com");
        
        assertThrows(IllegalArgumentException.class, 
            () -> userService.createUser("Jane Smith", "john@email.com"));
    }

    @Test
    @DisplayName("Should create multiple users with unique BVNs")
    void shouldCreateMultipleUsersWithUniqueBvns() {
        User user1 = userService.createUser("John Doe", "john@email.com");
        User user2 = userService.createUser("Jane Smith", "jane@email.com");
        
        assertNotEquals(user1.getBvn(), user2.getBvn());
        assertTrue(userService.userExists(user1.getBvn()));
        assertTrue(userService.userExists(user2.getBvn()));
    }

    @Test
    @DisplayName("Should find user by BVN")
    void shouldFindByBvn() {
        User created = userService.createUser("John Doe", "john@email.com");
        
        Optional<User> found = userService.findByBvn(created.getBvn());
        
        assertTrue(found.isPresent());
        assertEquals(created.getName(), found.get().getName());
        assertEquals(created.getEmail(), found.get().getEmail());
        assertEquals(created.getBvn(), found.get().getBvn());
    }

    @Test
    @DisplayName("Should return empty when BVN not found")
    void shouldReturnEmptyWhenBvnNotFound() {
        Optional<User> found = userService.findByBvn("NONEXISTENT");
        
        assertFalse(found.isPresent());
    }

    @Test
    @DisplayName("Should find user by email")
    void shouldFindByEmail() {
        User created = userService.createUser("John Doe", "john@email.com");
        
        Optional<User> found = userService.findByEmail("john@email.com");
        
        assertTrue(found.isPresent());
        assertEquals(created.getName(), found.get().getName());
        assertEquals(created.getEmail(), found.get().getEmail());
    }

    @Test
    @DisplayName("Should return empty when email not found")
    void shouldReturnEmptyWhenEmailNotFound() {
        Optional<User> found = userService.findByEmail("nonexistent@email.com");
        
        assertFalse(found.isPresent());
    }

    @Test
    @DisplayName("Should find users by name (case insensitive)")
    void shouldFindByName() {
        User user1 = userService.createUser("John Doe", "john@email.com");
        User user2 = userService.createUser("Jane Smith", "jane@email.com");
        User user3 = userService.createUser("John Smith", "johnsmith@email.com");
        
        List<User> johns = userService.findByName("john");
        List<User> does = userService.findByName("doe");
        List<User> smiths = userService.findByName("smith");
        
        assertEquals(2, johns.size()); 
        assertEquals(1, does.size()); 
        assertEquals(2, smiths.size()); 
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
        User user1 = userService.createUser("John Doe", "john@email.com");
        User user2 = userService.createUser("Jane Smith", "jane@email.com");
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
        User user1 = userService.createUser("John Doe", "john@email.com");
        User user2 = userService.createUser("Jane Smith", "jane@email.com");
        
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
            () -> userService.createUser("John Doe", null));
    }

    @Test
    @DisplayName("Should check if user exists by BVN")
    void shouldCheckUserExists() {
        User created = userService.createUser("John Doe", "john@email.com");
        
        assertTrue(userService.userExists(created.getBvn()));
        assertFalse(userService.userExists("NONEXISTENT"));
    }

    @Test
    @DisplayName("Should check if email exists")
    void shouldCheckEmailExists() {
        userService.createUser("John Doe", "john@email.com");
        
        assertTrue(userService.emailExists("john@email.com"));
        assertFalse(userService.emailExists("nonexistent@email.com"));
    }

    @Test
    @DisplayName("Should handle users with same name")
    void shouldHandleUsersSameName() {
        User user1 = userService.createUser("John Doe", "john@email.com");
        User user2 = userService.createUser("John Doe", "johndoe2@email.com");
        
        List<User> johnDoes = userService.findByName("John Doe");
        
        assertEquals(2, johnDoes.size());
        assertTrue(johnDoes.contains(user1));
        assertTrue(johnDoes.contains(user2));
    }

    @Test
    @DisplayName("Should handle partial name matching")
    void shouldHandlePartialNameMatching() {
        User user1 = userService.createUser("John Doe", "john@email.com");
        User user2 = userService.createUser("Jane Smith", "jane@email.com");
        
        List<User> partialMatch = userService.findByName("Jo");
        
        assertEquals(1, partialMatch.size()); // Only "John Doe" matches
        assertEquals("John Doe", partialMatch.get(0).getName());
    }

    @Test
    @DisplayName("Should handle empty name search")
    void shouldHandleEmptyNameSearch() {
        User user1 = userService.createUser("John Doe", "john@email.com");
        User user2 = userService.createUser("Jane Smith", "jane@email.com");
        
        List<User> emptySearch = userService.findByName("");
        
        // Should return all users since empty string matches all names
        assertEquals(2, emptySearch.size());
    }

    @Test
    @DisplayName("Should handle case insensitive email search")
    void shouldHandleCaseInsensitiveEmailSearch() {
        userService.createUser("John Doe", "john@email.com");
        
        assertTrue(userService.emailExists("john@email.com"));
        assertTrue(userService.emailExists("JOHN@EMAIL.COM"));
        assertTrue(userService.emailExists("John@Email.Com"));
    }

    @Test
    @DisplayName("Should handle special characters in names")
    void shouldHandleSpecialCharactersInNames() {
        User user1 = userService.createUser("John O'Connor", "john@email.com");
        User user2 = userService.createUser("Jean-Claude Van Damme", "jean@email.com");
        User user3 = userService.createUser("Muhammad Ali", "muhammad@email.com");
        
        Optional<User> found1 = userService.findByEmail("john@email.com");
        Optional<User> found2 = userService.findByEmail("jean@email.com");
        Optional<User> found3 = userService.findByEmail("muhammad@email.com");
        
        assertTrue(found1.isPresent());
        assertTrue(found2.isPresent());
        assertTrue(found3.isPresent());
        assertEquals("John O'Connor", found1.get().getName());
        assertEquals("Jean-Claude Van Damme", found2.get().getName());
        assertEquals("Muhammad Ali", found3.get().getName());
    }

    @Test
    @DisplayName("Should handle long email addresses")
    void shouldHandleLongEmailAddresses() {
        String longEmail = "very.long.email.address.with.many.words.and.numbers.123456789@testdomain.com";
        User created = userService.createUser("John Doe", longEmail);
        
        assertTrue(userService.emailExists(longEmail));
        assertEquals(longEmail, created.getEmail());
    }

    @Test
    @DisplayName("Should handle users with different BVN formats")
    void shouldHandleUsersWithDifferentBvnFormats() {
        User user1 = userService.createUser("John Doe", "john@email.com");
        User user2 = userService.createUser("Jane Smith", "jane@email.com");
        
        String bvn1 = user1.getBvn();
        String bvn2 = user2.getBvn();
        
        assertNotNull(bvn1);
        assertNotNull(bvn2);
        assertNotEquals(bvn1, bvn2);
        
        // BVNs should not be empty
        assertFalse(bvn1.trim().isEmpty());
        assertFalse(bvn2.trim().isEmpty());
    }
}
