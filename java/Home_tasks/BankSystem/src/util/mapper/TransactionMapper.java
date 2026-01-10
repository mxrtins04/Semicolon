package util.mapper;

import model.Transaction;
import model.Bank;
import dto.response.TransactionResponse;

public class TransactionMapper {

    public static TransactionResponse toResponse(Transaction transaction, Bank bank) {
        TransactionResponse response = new TransactionResponse();
        response.setReferenceNumber(transaction.getReferenceNumber());
        response.setSourceAccount(transaction.getSourceAccountNumber());
        response.setDestinationAccount(transaction.getDestinationAccountNumber());
        response.setDestinationBank(bank != null ? bank.getBankName() : "Unknown");
        response.setAmount(transaction.getAmount());
        response.setStatus(transaction.getStatus());
        response.setNarration(transaction.getNarration());
        response.setTimestamp(transaction.getCreatedAt());
        return response;
    }
}