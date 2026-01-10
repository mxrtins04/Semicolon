package test.model;

import org.junit.Test;

import src.model.User;

import static org.junit.Assert.*;

public class UserTest {
    
    @Test
    public void bvnIsGenerated_whenUserIsCreated(){
        User user = new User("Marins", "jjk@email.com");
        
        assertNotNull(user.getBvn());
    }

    @Test
    public void getBvn_returnsValidBvn(){
        User user = new User("Marins", "jjk@email.com");
        
        String bvn = user.getBvn();
        
        assertNotNull(bvn);
        assertEquals(11, bvn.length());
    }
}
