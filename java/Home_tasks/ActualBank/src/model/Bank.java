package src.model;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String code;
    private BankCode bankType;
    private String name;
    ArrayList<Account> accounts = new ArrayList<>();

    public Bank(String bankCode) {
        this.code = bankCode;
        this.bankType = BankCode.fromCode(bankCode);
        this.name = bankType.getName();
    }

    public static String generateBvn() {
        Random random = new Random();
        StringBuilder bvn = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            bvn.append(random.nextInt(10));
        }
        return bvn.toString();
    }

    public String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }

	public Account createAccount(User user) {
		Account account = new Account(this, user);
        account.setAccountNumber(generateAccountNumber());
        return account;
	}

}
