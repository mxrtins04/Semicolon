package test.model;

import org.junit.Test;

import src.model.Account;
import src.model.Bank;
import src.model.User;

import static org.junit.Assert.*;

import org.junit.Before;

public class BankTest {
    Bank bank;
    User user;
    @Before
    public void setup() {
        bank = new Bank("044");
        user = new User("Martins", "mxr@email.com");
    }
    
    @Test
    public void generateBvn_returnsValidBvn(){
        
        String bvn = bank.generateBvn();
        
        assertNotNull(bvn);
        assertEquals(11, bvn.length());
    }

    @Test
    public void createAccount_givenValidUser_accountIsCreated(){
        Account account = bank.createAccount(user);
        assertNotNull(account);
    }

    @Test
    public void createAccount_givenValidUser_assignsAccountNumberToUser(){
        Account account = bank.createAccount(user);
        assertNotNull(account.getAccountNumber());
    }
}
