import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BankingTest {
    BankingSystem firstBank;


    @Before
    public void setUp() {
        firstBank =  new BankingSystem();

    }

    @Test
    public void firstBank_HasNoAccount(){
        assertEquals(0,firstBank.getAccounts());
    }

    @Test
    public void firstBank_AccountContainsMoreAccounts(){
        firstBank.createAccount("Ade","12345");
        assertEquals(1,firstBank.getAccounts());
    }
    @Test
    public void firstBank_AccountCanDeposit5handBalanceIs5h(){

        firstBank.createAccount("Ade","12345");
        firstBank.deposit(500,1);

        assertEquals(500,firstBank.checkBalance(1,"12345"));

    }

    @Test
    public void firstBank_canGetClientAccountNumber(){
        assertEquals(1, firstBank.createAccount("ade","12345"));
    }
    @Test
    public void firstBank_canWithdraw200AndBalanceIs200(){
        firstBank.createAccount("ade","12345");
        firstBank.deposit(500,1);
        firstBank.withDraw("12345",1,200);
        assertEquals(300, firstBank.checkBalance(1,"12345"));
    }
    @Test
    public void firstBank_canNotWithdrawWithWrongPassword(){
        firstBank.createAccount("ade","12345");
        firstBank.deposit(500,1);
        assertThrows(validatePasswordException.class,()->firstBank.withDraw("1245",1,200));
        assertEquals(500,firstBank.checkBalance(1,"12345"));
    }

    @Test
    public void firstBank_canTransferFromAccount1toAccount2(){
        firstBank.createAccount("ade","12345");
        firstBank.createAccount("nife","1244");
        firstBank.deposit(1000,1);
        firstBank.Transfer(1,2,500,"12345");
        assertEquals(500,firstBank.checkBalance(2,"1244"));
    }


}
