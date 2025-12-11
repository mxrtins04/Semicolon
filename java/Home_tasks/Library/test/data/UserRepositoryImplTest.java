package data;

import data.models.User;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest{

    UserRepository userRepositoryImplementation;
    @BeforeEach
    void startWith() {
        userRepositoryImplementation = new UserRepositoryImpl();
    }

    @Test
    void repositoryIsEmptyUponCreation(){
        assertEquals(0L,userRepositoryImplementation.count());
    }

    @Test
    void saveUserCountIncreases(){
        User user = new User();
        userRepositoryImplementation.save(user);
        assertEquals(1L,userRepositoryImplementation.count());
    }

    @Test
    void saveUserIsReturned(){
        User user = new User();
        assertEquals(user, userRepositoryImplementation.save(user));
    }

    @Test
    void saveUserIdIsSet(){
        User user = new User();
        userRepositoryImplementation.save(user);
        assertEquals(1,user.getUserId());
    }

    @Test
    void findByIdUserIsReturned(){
        User user = new User();
        userRepositoryImplementation.save(user);
        assertEquals(user, userRepositoryImplementation.findById(1));
    }

    @Test
    void findByIdWithNumberGreaterThanCountReturnNull(){
        assertNull(userRepositoryImplementation.findById(1));
    }

    @Test
    void findByIdWithNumberEqualTo0OrLessThan0ReturnNull(){
        assertNull(userRepositoryImplementation.findById(0));
        assertNull(userRepositoryImplementation.findById(-1));
    }

    @Test
    void existsByIdTest(){
        User user = new User();
        userRepositoryImplementation.save(user);
        assertTrue(userRepositoryImplementation.existsById(1));
    }

    @Test
    void existsByIdWithInvalidIdTest(){
        assertFalse(userRepositoryImplementation.existsById(1));
        assertFalse(userRepositoryImplementation.existsById(-1));
        assertFalse(userRepositoryImplementation.existsById(0));
    }

    @Test
    void deleteByIdUserIsDeletedCountDecreases(){
        User user = new User();
        userRepositoryImplementation.save(user);
        userRepositoryImplementation.deleteById(1);
        assertEquals(0L, userRepositoryImplementation.count());
    }

    @Test
    void deleteAll_CountIs0(){
        User user = new User();
        userRepositoryImplementation.save(user);
        userRepositoryImplementation.deleteAll();
        assertEquals(0L, userRepositoryImplementation.count());
    }

    @Test
    void saveUserWithSameId(){
        User user = new User();
        userRepositoryImplementation.save(user);
        User user2 = new User();
        user2.setUserId(1);
        userRepositoryImplementation.save(user2);
        assertEquals(1L, userRepositoryImplementation.count());
    }


}