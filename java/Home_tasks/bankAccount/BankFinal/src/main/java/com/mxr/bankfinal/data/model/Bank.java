package com.mxr.bankfinal.data.model;
import java.util.ArrayList;

public class Bank {
    private String code;
    private BankCode bankType;
    private String name;
    ArrayList<Account> accounts = new ArrayList<>();

    public Bank(String bankCode) {
        this.code = bankCode;
        this.bankType = bankType.fromCode(bankCode);
        this.name = bankType.getName();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}













