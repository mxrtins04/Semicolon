package repository;

import model.Bank;
import java.util.List;
import java.util.Optional;

public interface BankRepo {
    Bank save(Bank bank);
    Optional<Bank> findById(Long id);
    Optional<Bank> findByBankCode(String bankCode);
    List<Bank> findAll();
    void update(Bank bank);
}