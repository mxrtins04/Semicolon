package com.mxr.bankfinal.data.model;
import java.util.ArrayList;

import com.mxr.bankfinal.data.repository.AccountRepository;
import com.mxr.bankfinal.data.repository.BankRepository;

public class Cbn{
    private BankCode[] bankCodes;
    private BankRepository bankRepository;
    private AccountRepository accountRepository;

    public Cbn(BankRepository bankRepository, AccountRepository accountRepository) {
        this.bankCodes = BankCode.values();
        this.bankRepository = bankRepository;
        this.accountRepository = accountRepository;
    }

    public void registerBank(String bankCode) {
        bankRepository.save(new Bank(bankCode));
    }

    public BankCode[] getBankCodes() {
        return bankCodes;
    }

    public BankRepository getBanks() {
        return bankRepository;
    }
}
