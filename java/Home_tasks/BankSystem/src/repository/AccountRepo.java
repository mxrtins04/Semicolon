package repository;

import model.Account;
import java.util.List;
import java.util.Optional;

public interface AccountRepo {
    Account save(Account account);
    Optional<Account> findByAccountNumber(String accountNumber);
    List<Account> findByCustomerId(Long customerId);
    List<Account> findByBankCode(String bankCode);
    List<Account> findAll();
    void update(Account account);
}