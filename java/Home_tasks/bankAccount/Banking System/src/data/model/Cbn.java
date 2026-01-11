package data.model;

import java.util.ArrayList;

public static class Cbn{
    private BankCode[] bankCodes;
    private ArrayList<Bank> banks;

    public Cbn() {
        this.bankCodes = BankCode.values();
        this.banks = new ArrayList<>();
    }

    public void registerBank(String bankCode) {
        BankCode bank = BankCode.fromCode(bankCode);
        banks.add(new Bank(bank));
    }

    public BankCode[] getBankCodes() {
        return bankCodes;
    }

    public ArrayList<Bank> getBanks() {
        return banks;
    }
}
