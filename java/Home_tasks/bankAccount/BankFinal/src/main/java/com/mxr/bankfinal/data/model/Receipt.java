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


    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setToAccountNumber(String toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
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
