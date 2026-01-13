package com.mxr.bankfinal.data.repository;
import com.mxr.bankfinal.data.model.Bank;
import com.mxr.bankfinal.data.model.BankCode;
import java.util.List;
import java.util.Optional;

public interface BankRepository {
    void save(Bank bank);
    Optional<Bank> findByCode(String code);
    Optional<Bank> findByName(String name);
    List<Bank> findAll();
    void delete(String code);
    boolean exists(String code);
    int count();
}
