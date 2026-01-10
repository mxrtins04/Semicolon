package model;
import org.junit.jupiter.api.Test;

import data.model.User;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class UserTest {
    @Test
    public void bvnIsGenerated_whenUserIsCreated(){
        User user = new User("Marins", "jjk@email.com");
        
        assertNotNull(user.getBvn());
    }


}
