package com.mxr.mfds.mapper;

import com.mxr.mfds.dto.ReceiptDto;
import com.mxr.mfds.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptMapperTest {

	private ReceiptMapper mapper;

	@BeforeEach
	void setUp() {
		mapper = new ReceiptMapper();
	}

	@Test
	void toReceipt_convertsTransactionToReceipt_whenValidTransactionProvided() {
		Transaction transaction = new Transaction(
			LocalDateTime.of(2024, 1, 7, 10, 30, 0),
			"Petrol",
			10.0,
			6175.0
		);

		ReceiptDto receipt = mapper.toReceipt(transaction);

		assertNotNull(receipt);
		assertEquals("2024-01-07 10:30:00", receipt.getTimestamp());
		assertEquals("Petrol", receipt.getFuelType());
		assertEquals(10.0, receipt.getQuantity());
		assertEquals(6175.0, receipt.getTotalCost());
	}

	@Test
	void toReceipt_formatsTimestampCorrectly_whenConverting() {
		Transaction transaction = new Transaction(
			LocalDateTime.of(2024, 12, 25, 9, 5, 30),
			"Diesel",
			15.0,
			8700.0
		);

		ReceiptDto receipt = mapper.toReceipt(transaction);

		assertEquals("2024-12-25 09:05:30", receipt.getTimestamp());
	}

	@Test
	void toReceipt_throwsException_whenTransactionIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			mapper.toReceipt(null);
		});
	}

	@Test
	void toReceipt_preservesAllTransactionData_whenConverting() {
		Transaction transaction = new Transaction(
			LocalDateTime.of(2024, 1, 7, 14, 22, 15),
			"Kerosene",
			25.5,
			11475.0
		);

		ReceiptDto receipt = mapper.toReceipt(transaction);

		assertEquals("2024-01-07 14:22:15", receipt.getTimestamp());
		assertEquals("Kerosene", receipt.getFuelType());
		assertEquals(25.5, receipt.getQuantity());
		assertEquals(11475.0, receipt.getTotalCost());
	}
}