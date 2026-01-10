package com.mxr.mfds.data;

import org.junit.jupiter.api.Test;

import com.mxr.mfds.dto.ReceiptDto;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptDtoTest {

	@Test
	void constructor_createsReceipt_whenValidParametersProvided() {
		ReceiptDto receipt = new ReceiptDto(
			"2024-01-07 10:30:00",
			"Petrol",
			10.0,
			6175.0
		);

		assertEquals("2024-01-07 10:30:00", receipt.getTimestamp());
		assertEquals("Petrol", receipt.getFuelType());
		assertEquals(10.0, receipt.getQuantity());
		assertEquals(6175.0, receipt.getTotalCost());
	}

	@Test
	void receipt_storesAllFields_correctly() {
		ReceiptDto receipt = new ReceiptDto(
			"2024-01-07 11:45:00",
			"Diesel",
			15.0,
			8700.0
		);

		assertEquals("2024-01-07 11:45:00", receipt.getTimestamp());
		assertEquals("Diesel", receipt.getFuelType());
		assertEquals(15.0, receipt.getQuantity());
		assertEquals(8700.0, receipt.getTotalCost());
	}
}