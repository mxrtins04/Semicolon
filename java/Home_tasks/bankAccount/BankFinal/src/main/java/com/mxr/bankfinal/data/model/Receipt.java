package com.mxr.bankfinal.data.model;

import java.time.LocalDateTime;

public class Receipt {
    private String receiptId;
    private String transactionId;
    private TransactionType transactionType;
    private String accountNumber;
    private String toAccountNumber;
    private double amount;
    private LocalDateTime timestamp;
    private String description;
    private TransactionStatus status;
    private String bankName;
    private String accountHolderName;

    public Receipt() {
        this.receiptId = generateReceiptId();
    }

    public Receipt(Transaction transaction, Account account, String bankName) {
        this();
        this.transactionId = transaction.getTransactionId();
        this.transactionType = transaction.getType();
        this.accountNumber = transaction.getFromAccount();
        this.toAccountNumber = transaction.getToAccount();
        this.amount = transaction.getAmount();
        this.timestamp = transaction.getTimestamp();
        this.description = transaction.getDescription();
        this.status = transaction.getStatus();
        this.bankName = bankName;
        this.accountHolderName = account.getName();
    }

    private String generateReceiptId() {
        return "RCP" + System.currentTimeMillis();
    }

 
    public String getReceiptId() {
        return receiptId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
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

    public TransactionStatus getStatus() {
        return status;
    }

    public String getBankName() {
        return bankName;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptId='" + receiptId + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", transactionType=" + transactionType +
                ", accountNumber='" + accountNumber + '\'' +
                ", toAccountNumber='" + toAccountNumber + '\'' +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", bankName='" + bankName + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                '}';
    }
}
