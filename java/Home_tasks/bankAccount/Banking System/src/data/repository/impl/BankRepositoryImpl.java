package data.repository.impl;

import data.model.Bank;
import data.repository.BankRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankRepositoryImpl implements BankRepository {
    private final List<Bank> banks = new ArrayList<>();

    @Override
    public void save(Bank bank) {
        banks.add(bank);
    }

    @Override
    public Optional<Bank> findByCode(String code) {
        return banks.stream()
                .filter(bank -> bank.getCode().equals(code))
                .findFirst();
    }

    @Override
    public Optional<Bank> findByName(String name) {
        return banks.stream()
                .filter(bank -> bank.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst();
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
