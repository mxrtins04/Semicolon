package dto.request;

import java.math.BigDecimal;

public class TransferRequest {
    private String sourceAccountNumber;
    private String destinationAccountNumber;
    private String destinationBankCode;
    private BigDecimal amount;
    private String narration;

    public TransferRequest() {}

    public String getSourceAccountNumber() { return sourceAccountNumber; }
    public void setSourceAccountNumber(String acc) { this.sourceAccountNumber = acc; }

    public String getDestinationAccountNumber() { return destinationAccountNumber; }
    public void setDestinationAccountNumber(String acc) { this.destinationAccountNumber = acc; }

    public String getDestinationBankCode() { return destinationBankCode; }
    public void setDestinationBankCode(String code) { this.destinationBankCode = code; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getNarration() { return narration; }
    public void setNarration(String narration) { this.narration = narration; }
}
