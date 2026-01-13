package com.mxr.bankfinal.data.model;
import java.util.ArrayList;

public class Cbn{
    private BankCode[] bankCodes;
    private ArrayList<Bank> banks;

    public Cbn() {
        this.bankCodes = BankCode.values();
        this.banks = new ArrayList<>();
    }

    public void registerBank(String bankCode) {
        banks.add(new Bank(bankCode));
    }

    public BankCode[] getBankCodes() {
        return bankCodes;
    }

    public ArrayList<Bank> getBanks() {
        return banks;
    }
}
