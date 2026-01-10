package com.mxr.mfds.data;

import org.junit.jupiter.api.Test;

import com.mxr.mfds.dto.TransactionDto;

import static org.junit.jupiter.api.Assertions.*;

class TransactionDtoTest {

	@Test
	void constructor_createsDto_whenValidParametersProvided() {
		TransactionDto dto = new TransactionDto(
			"2024-01-07 10:30:00",
			"Petrol",
			10.0,
			6175.0
		);

		assertEquals("2024-01-07 10:30:00", dto.getTimestamp());
		assertEquals("Petrol", dto.getFuelType());
		assertEquals(10.0, dto.getQuantity());
		assertEquals(6175.0, dto.getTotalCost());
	}

	@Test
	void dto_storesAllFields_correctly() {
		TransactionDto dto = new TransactionDto(
			"2024-01-07 11:45:00",
			"Diesel",
			15.0,
			8700.0
		);

		assertEquals("2024-01-07 11:45:00", dto.getTimestamp());
		assertEquals("Diesel", dto.getFuelType());
		assertEquals(15.0, dto.getQuantity());
		assertEquals(8700.0, dto.getTotalCost());
	}
}