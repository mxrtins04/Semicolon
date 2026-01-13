package com.mxr.bankfinal.data.repository;
import com.mxr.bankfinal.data.model.Account;
import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    void save(Account account);
    Account findByAccountNumber(String accountNumber);
    List<Account> findByEmail(String email);
    List<Account> findAll();
    void delete(String accountNumber);
    boolean exists(String accountNumber);
    int count();
}
