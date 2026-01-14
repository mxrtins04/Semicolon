package com.mxr.bankfinal.service;

import com.mxr.bankfinal.data.model.Account;
import com.mxr.bankfinal.data.model.Receipt;
import com.mxr.bankfinal.data.model.Transaction;
import com.mxr.bankfinal.data.model.TransactionType;
import com.mxr.bankfinal.data.repository.AccountRepository;

public class ReceiptService {
    private final AccountRepository accountRepository;

    public ReceiptService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Receipt generateReceipt(Transaction transaction, String bankName) {
        Account account = accountRepository.findByAccountNumber(transaction.getFromAccount());
        if (account == null) {
            throw new IllegalArgumentException("Account not found for transaction: " + transaction.getFromAccount());
        }

        return new Receipt(transaction, account, bankName);
    }

    public Receipt generateReceipt(Transaction transaction, Account account, String bankName) {
        return new Receipt(transaction, account, bankName);
    }

    public String formatReceipt(Receipt receipt) {
        StringBuilder sb = new StringBuilder();
        sb.append("================================\n");
        sb.append("       TRANSACTION RECEIPT      \n");
        sb.append("================================\n");
        sb.append("Receipt ID: ").append(receipt.getReceiptId()).append("\n");
        sb.append("Transaction ID: ").append(receipt.getTransactionId()).append("\n");
        sb.append("Bank: ").append(receipt.getBankName()).append("\n");
        sb.append("Type: ").append(receipt.getTransactionType()).append("\n");
        sb.append("Account: ").append(receipt.getAccountNumber()).append("\n");
        sb.append("Account Holder: ").append(receipt.getAccountHolderName()).append("\n");
        
        if (receipt.getTransactionType() == TransactionType.TRANSFER) {
            sb.append("To Account: ").append(receipt.getToAccountNumber()).append("\n");
        }
        
        sb.append("Amount: ₦").append(String.format("%.2f", receipt.getAmount())).append("\n");
        sb.append("Status: ").append(receipt.getStatus()).append("\n");
        sb.append("Date: ").append(receipt.getTimestamp()).append("\n");
        sb.append("Description: ").append(receipt.getDescription()).append("\n");
        sb.append("================================\n");
        
        return sb.toString();
    }

    public String formatReceiptCompact(Receipt receipt) {
        StringBuilder sb = new StringBuilder();
        sb.append("RCP: ").append(receipt.getReceiptId()).append(" | ");
        sb.append("TXN: ").append(receipt.getTransactionId()).append(" | ");
        sb.append("Type: ").append(receipt.getTransactionType()).append(" | ");
        sb.append("Acct: ").append(receipt.getAccountNumber()).append(" | ");
        
        if (receipt.getTransactionType() == TransactionType.TRANSFER) {
            sb.append("To: ").append(receipt.getToAccountNumber()).append(" | ");
        }
        
        sb.append("Amt: ₦").append(String.format("%.2f", receipt.getAmount())).append(" | ");
        sb.append("Status: ").append(receipt.getStatus()).append(" | ");
        sb.append("Time: ").append(receipt.getTimestamp());
        
        return sb.toString();
    }

    public String formatReceiptJSON(Receipt receipt) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("  \"receiptId\": \"").append(receipt.getReceiptId()).append("\",\n");
        sb.append("  \"transactionId\": \"").append(receipt.getTransactionId()).append("\",\n");
        sb.append("  \"bankName\": \"").append(receipt.getBankName()).append("\",\n");
        sb.append("  \"transactionType\": \"").append(receipt.getTransactionType()).append("\",\n");
        sb.append("  \"accountNumber\": \"").append(receipt.getAccountNumber()).append("\",\n");
        sb.append("  \"accountHolderName\": \"").append(receipt.getAccountHolderName()).append("\",\n");
        
        if (receipt.getTransactionType() == TransactionType.TRANSFER) {
            sb.append("  \"toAccountNumber\": \"").append(receipt.getToAccountNumber()).append("\",\n");
        }
        
        sb.append("  \"amount\": ").append(receipt.getAmount()).append(",\n");
        sb.append("  \"status\": \"").append(receipt.getStatus()).append("\",\n");
        sb.append("  \"timestamp\": \"").append(receipt.getTimestamp()).append("\",\n");
        sb.append("  \"description\": \"").append(receipt.getDescription()).append("\"\n");
        sb.append("}");
        
        return sb.toString();
    }

    public void printReceipt(Receipt receipt) {
        System.out.println(formatReceipt(receipt));
    }

    public void printReceiptCompact(Receipt receipt) {
        System.out.println(formatReceiptCompact(receipt));
    }

    public void printReceiptJSON(Receipt receipt) {
        System.out.println(formatReceiptJSON(receipt));
    }
}
