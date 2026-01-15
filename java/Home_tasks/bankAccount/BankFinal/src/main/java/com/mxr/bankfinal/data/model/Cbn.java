package com.mxr.bankfinal.data.model;

import com.mxr.bankfinal.data.repository.BankRepository;
import com.mxr.bankfinal.service.TransactionService;

public class Cbn{
    private final BankCode[] bankCodes;
    private final BankRepository bankRepository;
    private final TransactionService transactionService;

    public Cbn(BankRepository bankRepository, TransactionService transactionService) {
        this.bankCodes = BankCode.values();
        this.bankRepository = bankRepository;
        this.transactionService = transactionService;
    }

    public void registerBank(String bankCode) {
        Bank bank = new Bank(bankCode, transactionService);
        bankRepository.save(bank);
    }

    public BankCode[] getBankCodes() {
        return bankCodes;
    }

    public BankRepository getBanks() {
        return bankRepository;
    }
}
