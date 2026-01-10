package repository;

import model.Account;
import repository.AccountRepo;
import java.util.*;
import java.util.stream.Collectors;

public class AccountRepoImpl implements AccountRepo {
    private Map<String, Account> accounts = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public Account save(Account account) {
        if (account.getId() == null) {
            account.setId(currentId++);
        }
        accounts.put(account.getAccountNumber(), account);
        return account;
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return Optional.ofNullable(accounts.get(accountNumber));
    }

    @Override
    public List<Account> findByCustomerId(Long customerId) {
        return accounts.values().stream()
                .filter(acc -> acc.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Account> findByBankCode(String bankCode) {
        return accounts.values().stream()
                .filter(acc -> acc.getBankCode().equals(bankCode))
                .collect(Collectors.toList());
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accounts.values());
    }

    @Override
    public void update(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }
}