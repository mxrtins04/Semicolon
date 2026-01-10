package model;
import org.junit.jupiter.api.Test;

import validateInsufficientAmountException;
import validateNegativeAmountException;
import data.model.Bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {

    @Test
    public void testThatNewBankHasNoAccount() {
        Bank stanbic = new Bank("fff","hdbwdj","234");
        assertEquals(0, stanbic.getAccount());
    }
    @Test
    public void testThatBankCanCreateAccount() {
        Bank stanbic = new Bank("fff","hdbwdj","234");
        stanbic.createAccount("moses","hdhdhdhd","1234");
        assertEquals(stanbic.getAccount(), 1);


    }

    @Test
    public void CreateAccount_deposit5h_balanceIs5h_Test() {
        Bank stanbic = new Bank("moses","mososos","1234");
        stanbic.createAccount("michael","mos@gmail.com", "1234");
        stanbic.deposit(1,500);
        assertEquals(500, stanbic.getBalance(1));
    }
    @Test
    public void CreateAccount_deposit5h_withdraw2h_balanceIs3h_Test() {
        Bank stanbic = new Bank("moses","mososos","1234");
        stanbic.createAccount("dotun","hghgh","1234");
        stanbic.deposit(1,500);
        stanbic.withdraw(300,1);
        assertEquals(200, stanbic.getBalance(1));
    }

    @Test
    public void createMultipleAccount_deposit5hEach_withdrawFrom1stOneAndReturnbalance_returnBalance_forTheSecond_Test() {
        Bank stanbic = new Bank("moses","mososos","1234");
        stanbic.createAccount("mmm","mmm","1234");
        stanbic.createAccount("mrrr", "mmm","1234");
        stanbic.deposit(1,500);
        stanbic.deposit(2,3000);
        stanbic.withdraw(2000,2);
        assertEquals(1000, stanbic.getBalance(2));
        assertEquals(500, stanbic.getBalance(1));


    }
    @Test
    public void createAccount_A_and_B_DepositInA_TransferToB_Test() {
        Bank stanbic = new Bank("moses","mososos","1234");
        stanbic.createAccount("mmm","mmm","1234");
        stanbic.deposit(1,2500);
        stanbic.createAccount("mmm","mmm","1234");
        stanbic.transfer(2000, 1,2);
        assertEquals(2000, stanbic.getBalance(2));
    }

    @Test
    public void createAccount_deposit5h_withdraw1k_throwInsufficientAmountException_Test() {
        Bank stanbic = new Bank("moses","mososos","1234");
        stanbic.createAccount("mmm","mmm","1234");
        stanbic.deposit(1,500);
        assertThrows(validateInsufficientAmountException.class, () -> stanbic.withdraw(1000,1));
    }
    @Test
    public void createAccount_deposit5h_withdrawMinus2k_throwNegativeAmountException_Test() {
        Bank stanbic = new Bank("moses","mososos","1234");
        stanbic.createAccount("mmm","mmm","1234");
        stanbic.deposit(1,500);
        assertThrows(validateNegativeAmountException.class, () -> stanbic.withdraw(-2000,1));
    }

}
