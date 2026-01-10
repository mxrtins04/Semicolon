package test.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import src.model.Bank;
import src.model.Account;
import src.model.User;

public class AccountTest {

    Bank bank;
    User user;

    @Before
    public void setup(){
        bank = new Bank("044");
        user = new User("mxr", "mm@Email.com");
    }

    
    @Test
    public void createAccount_givenValidUser_CreatesAccount(){
        Bank bank1 = new Bank("044");
        User user1 = new User("Marins", "jjk@email.com");
        Account account = bank1.createAccount(user1);
        
        assertNotNull(account);
    }

    @Test
    public void accountDefaultBalanceIsZero(){
        Account account = bank.createAccount(user);
        assertEquals(0, account.getBalance());

    }

    @Test
    public void credit_givenValidAmount_increasesBalance(){
        Account account = bank.createAccount(user);
        account.credit(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    public void credit_givenNegativeAmount_throwsException(){
        Account account = bank.createAccount(user);
        assertThrows(IllegalArgumentException.class, () -> account.credit(-100));        
    }

    @Test
    public void credit_givenZeroAmount_throwsException(){
        Account account = bank.createAccount(user);
        assertThrows(IllegalArgumentException.class, () -> account.credit(0));        
    }

    @Test
    public void debit_givenValidAmount_decreasesBalance(){
        Account account = bank.createAccount(user);
        account.credit(100);
        account.debit(50);
        assertEquals(50, account.getBalance());
    }

    @Test
    public void debit_givenAmountGreaterThanBalance_throwsException(){
        Account account = bank.createAccount(user);
        account.credit(100);
        assertThrows(IllegalArgumentException.class, () -> account.debit(150));
    }

    @Test
    public void debit_givenNegativeAmount_throwsException(){
        Account account = bank.createAccount(user);
        account.credit(100);
        assertThrows(IllegalArgumentException.class, () -> account.debit(-50));
    }

    @Test
    public void debit_givenZeroAmount_throwsException(){
        Account account = bank.createAccount(user);
        account.credit(100);
        assertThrows(IllegalArgumentException.class, () -> account.debit(0));
    }

}
