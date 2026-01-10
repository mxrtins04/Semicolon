package service;

import model.Bank;
import repository.BankRepo;
import util.validation.Validator;
import java.util.List;

public class BankService {
    private BankRepo bankRepository;

    public BankService(BankRepo bankRepository) {
        this.bankRepository = bankRepository;
    }

    public Bank registerBank(String bankCode, String bankName, String address) {
        if (!Validator.isValidBankCode(bankCode)) {
            throw new IllegalArgumentException("Invalid bank code format");
        }

        if (!Validator.isNotEmpty(bankName)) {
            throw new IllegalArgumentException("Bank name cannot be empty");
        }

        if (bankRepository.findByBankCode(bankCode).isPresent()) {
            throw new IllegalArgumentException("Bank with code " + bankCode + " already exists");
        }

        Bank bank = new Bank(bankCode, bankName, address);
        return bankRepository.save(bank);
    }

    public Bank getBank(String bankCode) {
        return bankRepository.findByBankCode(bankCode).orElseThrow(() -> new RuntimeException("Bank not found: " + bankCode));
    }

    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    public String getBankName(String bankCode) {
        return getBank(bankCode).getBankName();
    }
}
