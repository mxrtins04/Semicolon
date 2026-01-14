package com.mxr.bankfinal.data.model;
import java.util.ArrayList;

import com.mxr.bankfinal.data.repository.AccountRepository;
import com.mxr.bankfinal.data.repository.UserRepository;

public class Bank {
    private String code;
    private BankCode bankType;
    private String name;
    private AccountRepository accountRepository;

    public Bank(String bankCode) {
        this.code = bankCode;
        this.bankType = BankCode.fromCode(bankCode);
        this.name = bankType.getName();
    }

    public void setDataStorage(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }
}













