package com.mxr.bankfinal.data.model;
import java.util.ArrayList;

import com.mxr.bankfinal.data.repository.AccountRepository;
import com.mxr.bankfinal.data.repository.UserRepository;
import com.mxr.bankfinal.service.BankService;
import com.mxr.bankfinal.service.TransactionService;
import com.mxr.bankfinal.data.repository.impl.AccountRepositoryImpl;

public class Bank {
    private String code;
    private BankCode bankType;
    private String name;
    private AccountRepository accountRepository;
    private BankService bankService;

    public Bank(String bankCode, TransactionService transactionService) {
        this.code = bankCode;
        this.bankType = BankCode.fromCode(bankCode);
        this.name = bankType.getName();
        this.accountRepository = new AccountRepositoryImpl();
        this.bankService = new BankService(bankCode, (com.mxr.bankfinal.data.repository.impl.AccountRepositoryImpl) this.accountRepository, transactionService);
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

    public BankService getBankService() {
        return bankService;
    }
}













