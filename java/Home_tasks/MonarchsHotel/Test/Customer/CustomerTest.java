package Customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    Customer customer;
    @BeforeEach
    void setUp() {
        customer = new Customer();
    }
    @Test
    public void testCustomerHasNoNameByDefault() {
        assertNull(customer.getName());
    }

    @Test
    public void testCustomerCanGetAName(){
        customer.setName("jjk");
        assertNotNull(customer.getName());
    }


    @Test
    public void testSetNameOnlyTakesInAlphabets() {
        assertThrows(IllegalArgumentException.class, () -> {customer.setName("jjk3");});
    }

    @Test
    public void testSetNameAlsoTakesInSpace(){
        customer.setName("jjk nnm");
        assertEquals("jjk nnm", customer.getName());
    }

    @Test
    public void customersPhoneNumberisNullByDefault(){
        assertNull(customer.getPhoneNumber());
    }

    @Test
    public void testSetPhoneNumberOnlyTakesInOnlyDigits() {
        assertThrows(IllegalArgumentException.class, () -> {customer.setPhoneNumber("j8w7");});
    }


    @Test
    public void testSetPhoneNumberOnlyCollectsInputWithElevenDigits() {
        assertThrows(IllegalArgumentException.class, () -> {customer.setPhoneNumber("0342");});
    }

    @Test
    public void testSetPhoneNumberCanSetOnlyValidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, ()  -> {customer.setPhoneNumber("j8w7");});
        assertThrows(IllegalArgumentException.class, ()  -> {customer.setPhoneNumber("0989");});
        assertThrows(IllegalArgumentException.class, ()  -> {customer.setPhoneNumber("34563642343624643242662");});
        customer.setPhoneNumber("08138483954");
        assertEquals("08138483954", customer.getPhoneNumber());
    }

    @Test
    public void testCustomersEmailIsNullByDefault(){
        assertNull(customer.getEmail());
    }

    @Test
    public void testCustomerCanSetEmail(){
        customer.setEmail("jjk@gmail.com");
        assertEquals("jjk@gmail.com", customer.getEmail());
    }


}

