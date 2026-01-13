package com.mxr.bankfinal.data.model;
import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    private com.mxr.bankfinal.data.model.TransactionType type;
    private String fromAccount;
    private String toAccount;
    private double amount;
    private LocalDateTime timestamp;
    private String description;
    private com.mxr.bankfinal.data.model.TransactionStatus status;
    
    public Transaction(com.mxr.bankfinal.data.model.TransactionType type, String fromAccount, double amount, String description) {
        this.transactionId = generateTransactionId();
        this.type = type;
        this.fromAccount = fromAccount;
        this.toAccount = fromAccount;
        this.amount = amount;
        this.description = description;
        this.timestamp = LocalDateTime.now();
        this.status = status.PENDING;
    }
    
    public Transaction(com.mxr.bankfinal.data.model.TransactionType type, String fromAccount, String toAccount, double amount, String description) {
        this(type, fromAccount, amount, description);
        this.toAccount = toAccount;
    }
    
    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }
    
    public void complete() {
        this.status = status.COMPLETED;
    }
    
    public void fail() {
        this.status = status.FAILED;
    }
    
    public String getTransactionId() {
        return transactionId;
    }
    
    public com.mxr.bankfinal.data.model.TransactionType getType() {
        return type;
    }
    
    public String getFromAccount() {
        return fromAccount;
    }
    
    public String getToAccount() {
        return toAccount;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public String getDescription() {
        return description;
    }
    
    public com.mxr.bankfinal.data.model.TransactionStatus getStatus() {
        return status;
    }
    
    @Override
    public String toString() {
        if (type == type.TRANSFER) {
            return String.format("Transaction[%s] %s: Account %s -> Account %s, Amount: %.2f, Status: %s, Time: %s",
                transactionId, type, fromAccount, toAccount, amount, status, timestamp);
        } else {
            return String.format("Transaction[%s] %s: Account %s, Amount: %.2f, Status: %s, Time: %s",
                transactionId, type, fromAccount, amount, status, timestamp);
        }
    }
}


