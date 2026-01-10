package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private Long id;
    private String referenceNumber;
    private String sourceAccountNumber;
    private String sourceBankCode;
    private String destinationAccountNumber;
    private String destinationBankCode;
    private BigDecimal amount;
    private TransactionType type;
    private TransactionStatus status;
    private String narration;
    private final LocalDateTime createdAt;
    public Transaction() {
        this.createdAt = LocalDateTime.now();
        this.status = TransactionStatus.PENDING;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getReferenceNumber() { return referenceNumber; }
    public void setReferenceNumber(String ref) { this.referenceNumber = ref; }

    public String getSourceAccountNumber() { return sourceAccountNumber; }
    public void setSourceAccountNumber(String acc) { this.sourceAccountNumber = acc; }

    public String getSourceBankCode() { return sourceBankCode; }
    public void setSourceBankCode(String code) { this.sourceBankCode = code; }

    public String getDestinationAccountNumber() { return destinationAccountNumber; }
    public void setDestinationAccountNumber(String acc) { this.destinationAccountNumber = acc; }

    public String getDestinationBankCode() { return destinationBankCode; }
    public void setDestinationBankCode(String code) { this.destinationBankCode = code; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public TransactionType getType() { return type; }
    public void setType(TransactionType type) { this.type = type; }

    public TransactionStatus getStatus() { return status; }
    public void setStatus(TransactionStatus status) { this.status = status; }

    public String getNarration() { return narration; }
    public void setNarration(String narration) { this.narration = narration; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return "Transaction{" + referenceNumber + ", ₦" + amount + ", " + status + "}";
    }
}