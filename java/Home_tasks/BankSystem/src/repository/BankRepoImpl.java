package repository;

import model.Bank;
import repository.BankRepo;
import java.util.*;

public class BankRepoImpl implements BankRepo {
    private Map<Long, Bank> banks = new HashMap<>();
    private Map<String, Bank> banksByCode = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public Bank save(Bank bank) {
        banksByCode.put(bank.getBankCode(), bank);
        return bank;
    }

    @Override
    public Optional<Bank> findById(Long id) {
        return Optional.ofNullable(banks.get(id));
    }

    @Override
    public Optional<Bank> findByBankCode(String bankCode) {
        return Optional.ofNullable(banksByCode.get(bankCode));
    }

    @Override
    public List<Bank> findAll() {
        return new ArrayList<>(banks.values());
    }

    @Override
    public void update(Bank bank) {
        banksByCode.put(bank.getBankCode(), bank);
    }
}