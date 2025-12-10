import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    Account myaccount;
    @Before
    public void setup() {
        myaccount = new Account("ade","1234");
    }

    @Test
    public void myAccount_BalanaceIsEmptyTest(){
    assertEquals(0,myaccount.getBalance("1234"));
    }

    @Test
    public void myAccount_caDeposit5hAndBalance5hTest(){
        myaccount.deposit(500);
        assertEquals(500,myaccount.getBalance("1234"));
    }

    @Test
    public void myAccount_canNotDepositNegativeIntoBalance0hTest(){
        assertThrows(validateAmount.class,() -> myaccount.deposit(-500));
        assertEquals(0,myaccount.getBalance("1234"));
    }

    @Test
    public void myAccount_canWithdraw2hAndBalance2hTest(){
        myaccount.deposit(400);
        assertEquals(400,myaccount.getBalance("1234"));
        myaccount.withdraw(200,"1234");
        assertEquals(200,myaccount.getBalance("1234"));
    }

    @Test
    public void myAccount_CanNotWithdrawNegativeAmountAndBalance5hTest(){
        myaccount.deposit(500);
        assertEquals(500,myaccount.getBalance("1234"));
        assertThrows(validateAmount.class,() -> myaccount.withdraw(-200, "1234"));
    }

    @Test
    public void myAccount_canWithdraw5hAndBalance2hTest(){
        myaccount.deposit(200);
        assertEquals(200,myaccount.getBalance("1234"));
        assertThrows(validateAmount.class,() -> myaccount.withdraw(500, "1234"));
    }



}
