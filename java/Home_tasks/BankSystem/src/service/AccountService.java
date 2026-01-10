package service;

import model.Account;
import model.Bank;
import model.Customer;
import model.AccountType;
import repository.AccountRepo;
import repository.BankRepo;
import repository.CustomerRepo;
import dto.request.CreateAccountRequest;
import dto.response.AccountResponse;
import util.generator.NUBANGenerator;
import util.mapper.AccountMapper;
import util.validation.Validator;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class AccountService {
    private AccountRepo accountRepository;
    private CustomerRepo customerRepository;
    private BankRepo bankRepository;

    public AccountService(AccountRepo accountRepository,
                          CustomerRepo customerRepository,
                          BankRepo bankRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.bankRepository = bankRepository;
    }

    public AccountResponse createAccount(CreateAccountRequest request) {
        if (!Validator.isValidBVN(request.getBvn())) {
            throw new IllegalArgumentException("Invalid BVN format");
        }

        Customer customer = customerRepository.findByBvn(request.getBvn())
                .orElseThrow(() -> new RuntimeException("Customer not found. Please register first."));

        Bank bank = bankRepository.findByBankCode(request.getBankCode())
                .orElseThrow(() -> new RuntimeException("Bank not found"));

        Long serialNumber = bank.getNextAccountSerial();
        String nubanAccountNumber = NUBANGenerator.generateNUBAN(
                bank.getBankCode(),
                serialNumber
        );

        if (!NUBANGenerator.validateNUBAN(bank.getBankCode(), nubanAccountNumber)) {
            throw new RuntimeException("Generated NUBAN validation failed");
        }

        // Create account
        Account account = new Account();
        account.setAccountNumber(nubanAccountNumber);
        account.setCustomerId(customer.getId());
        account.setBankCode(bank.getBankCode());
        account.setAccountType(request.getAccountType());
        account.setBalance(BigDecimal.ZERO);
        account.setActive(true);

        Account savedAccount = accountRepository.save(account);

        bankRepository.update(bank);

        return AccountMapper.toResponse(savedAccount, customer, bank);
    }

    public AccountResponse getAccount(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        Customer customer = customerRepository.findById(account.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Bank bank = bankRepository.findByBankCode(account.getBankCode())
                .orElseThrow(() -> new RuntimeException("Bank not found"));

        return AccountMapper.toResponse(account, customer, bank);
    }

    public List<AccountResponse> getCustomerAccounts(String bvn) {
        Customer customer = customerRepository.findByBvn(bvn)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        List<Account> accounts = accountRepository.findByCustomerId(customer.getId());

        return accounts.stream()
                .map(account -> {
                    Bank bank = bankRepository.findByBankCode(account.getBankCode()).get();
                    return AccountMapper.toResponse(account, customer, bank);
                })
                .collect(Collectors.toList());
    }

    public void deposit(String accountNumber, BigDecimal amount) {
        if (!Validator.isPositiveAmount(amount)) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.credit(amount);
        accountRepository.update(account);
    }

    public BigDecimal getBalance(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return account.getBalance();
    }

    public String getAccountHolderName(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        Customer customer = customerRepository.findById(account.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return customer.getFullName();
    }
}
