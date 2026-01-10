package dto.response;

import model.TransactionStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {
    private String referenceNumber;
    private String sourceAccount;
    private String destinationAccount;
    private String destinationBank;
    private BigDecimal amount;
    private TransactionStatus status;
    private String narration;
    private LocalDateTime timestamp;

    public TransactionResponse() {}

    public String getReferenceNumber() { return referenceNumber; }
    public void setReferenceNumber(String ref) { this.referenceNumber = ref; }

    public String getSourceAccount() { return sourceAccount; }
    public void setSourceAccount(String acc) { this.sourceAccount = acc; }

    public String getDestinationAccount() { return destinationAccount; }
    public void setDestinationAccount(String acc) { this.destinationAccount = acc; }

    public String getDestinationBank() { return destinationBank; }
    public void setDestinationBank(String bank) { this.destinationBank = bank; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public TransactionStatus getStatus() { return status; }
    public void setStatus(TransactionStatus status) { this.status = status; }

    public String getNarration() { return narration; }
    public void setNarration(String narration) { this.narration = narration; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime time) { this.timestamp = time; }

    @Override
    public String toString() {
        return String.format("%s | ₦%s | %s | %s",
                referenceNumber, amount, status, timestamp.toLocalDate());
    }
}