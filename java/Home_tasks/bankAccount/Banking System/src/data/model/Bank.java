package data.model;
import java.util.ArrayList;

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
}













