package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import validateInsufficientAmountException;
import validateNegativeAmountException;
import data.model.Account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    Account funds;

    @BeforeEach
    public void setup() {
        funds = new Account("eno", "1234","222",1);
    }


    @Test
    public void testThatBalanceIsZero() {
        assertEquals(0, funds.getBalance());
    }

    @Test
    public void testThatAccountCanReceive5hAndBalanceIs5h() {
        funds.deposit(500);
        assertEquals(500, funds.getBalance());

    }
    @Test
    public void testThatAccountCanNotReceiveNegativeDeposit() {

        assertThrows(validateNegativeAmountException.class, () -> funds.deposit(-500));
    }
    @Test
    public void testThatAccountCanReceive5hAndWithdraw3hAndBalanceIs2h() {

        funds.deposit(500);
        funds.withdraw(200);
        assertEquals(300, funds.getBalance());

    }
    @Test
    public void testThatAccountCannotHave5hAndYouWithdraw7h() {

        funds.deposit(500);
        assertThrows(validateInsufficientAmountException.class, () -> funds.withdraw(700));
    }
    @Test
    public void testThatYouCanNotWithdrawNegativeAmount() {

        funds.deposit(500);
        assertThrows(validateNegativeAmountException.class, () -> funds.withdraw(-500));
    }
}
