package dto.response;

import java.math.BigDecimal;

public class AccountResponse {
    private String accountNumber;
    private String customerName;
    private String bankName;
    private String bankCode;
    private BigDecimal balance;

    public AccountResponse() {}

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String acc) { this.accountNumber = acc; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String name) { this.customerName = name; }

    public String getBankName() { return bankName; }
    public void setBankName(String name) { this.bankName = name; }

    public String getBankCode() { return bankCode; }
    public void setBankCode(String code) { this.bankCode = code; }

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | ₦%s",
                accountNumber, customerName, bankName, balance);
    }
}