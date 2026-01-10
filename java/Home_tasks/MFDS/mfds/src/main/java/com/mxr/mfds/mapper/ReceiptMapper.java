package com.mxr.mfds.mapper;

import com.mxr.mfds.dto.ReceiptDto;
import com.mxr.mfds.model.Transaction;

import java.time.format.DateTimeFormatter;

public class ReceiptMapper {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public ReceiptDto toReceipt(Transaction transaction) {
		if (transaction == null) {
			throw new IllegalArgumentException("Transaction cannot be null");
		}

		return new ReceiptDto(
			transaction.getTimestamp().format(FORMATTER),
			transaction.getFuelType(),
			transaction.getQuantity(),
			transaction.getTotalCost()
		);
	}
}