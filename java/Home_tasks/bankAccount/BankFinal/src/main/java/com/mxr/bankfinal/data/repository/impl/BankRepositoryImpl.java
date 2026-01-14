package com.mxr.bankfinal.data.repository.impl;
import com.mxr.bankfinal.data.model.Bank;
import com.mxr.bankfinal.data.repository.BankRepository;
import java.util.ArrayList;
import java.util.List;

public class BankRepositoryImpl implements BankRepository {
    private final List<Bank> banks = new ArrayList<>();

    @Override
    public void save(Bank bank) {
        banks.add(bank);
    }

    @Override
    public Bank findByCode(String code) {
        return banks.stream()
                .filter(bank -> bank.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Bank findByName(String name) {
        return banks.stream()
                .filter(bank -> bank.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Bank> findAll() {
        return new ArrayList<>(banks);
    }

    @Override
    public void delete(String code) {
        banks.removeIf(bank -> bank.getCode().equals(code));
    }

    @Override
    public boolean exists(String code) {
        return banks.stream()
                .anyMatch(bank -> bank.getCode().equals(code));
    }

    @Override
    public int count() {
        return banks.size();
    }
}
