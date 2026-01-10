package util.mapper;

import model.Account;
import model.Customer;
import model.Bank;
import dto.response.AccountResponse;

public class AccountMapper {

    public static AccountResponse toResponse(Account account, Customer customer, Bank bank) {
        AccountResponse response = new AccountResponse();
        response.setAccountNumber(account.getAccountNumber());
        response.setCustomerName(customer.getFullName());
        response.setBankName(bank.getBankName());
        response.setBankCode(bank.getBankCode());
        response.setBalance(account.getBalance());
        return response;
    }
}