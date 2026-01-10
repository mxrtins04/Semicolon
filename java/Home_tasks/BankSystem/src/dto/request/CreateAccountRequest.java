package dto.request;

public class CreateAccountRequest {
    private String bvn;
    private String bankCode;

    public CreateAccountRequest() {}

    public String getBvn() { return bvn; }
    public void setBvn(String bvn) { this.bvn = bvn; }

    public String getBankCode() { return bankCode; }
    public void setBankCode(String bankCode) { this.bankCode = bankCode; }


}