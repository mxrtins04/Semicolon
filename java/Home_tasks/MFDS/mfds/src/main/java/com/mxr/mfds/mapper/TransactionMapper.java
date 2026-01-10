package com.mxr.mfds.mapper;

import com.mxr.mfds.dto.TransactionDto;
import com.mxr.mfds.model.Transaction;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionMapper {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public TransactionDto toDto(Transaction transaction) {
		if (transaction == null) {
			throw new IllegalArgumentException("Transaction cannot be null");
		}

		return new TransactionDto(
			transaction.getTimestamp().format(FORMATTER),
			transaction.getFuelType(),
			transaction.getQuantity(),
			transaction.getTotalCost()
		);
	}

	public List<TransactionDto> toDtoList(List<Transaction> transactions) {
		if (transactions == null) {
			throw new IllegalArgumentException("Transaction list cannot be null");
		}

		return transactions.stream()
			.map(transaction -> {
				if (transaction == null) {
					throw new IllegalArgumentException("Transaction list cannot contain null elements");
				}
				return toDto(transaction);
			})
			.collect(Collectors.toList());
	}
}