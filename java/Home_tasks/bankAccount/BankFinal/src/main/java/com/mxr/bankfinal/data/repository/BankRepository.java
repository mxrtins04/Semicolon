package com.mxr.bankfinal.data.repository;
import com.mxr.bankfinal.data.model.Bank;
import com.mxr.bankfinal.data.model.BankCode;
import java.util.List;

public interface BankRepository {
    void save(Bank bank);
    Bank findByCode(String code);
    Bank findByName(String name);
    List<Bank> findAll();
    void delete(String code);
    boolean exists(String code);
    int count();
}
