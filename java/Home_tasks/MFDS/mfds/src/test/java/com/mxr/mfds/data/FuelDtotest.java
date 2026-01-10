package com.mxr.mfds.data;

import org.junit.jupiter.api.Test;

import com.mxr.mfds.dto.FuelDto;

import static org.junit.jupiter.api.Assertions.*;

class FuelDtoTest {

	@Test
	void constructor_createsDto_whenValidParametersProvided() {
		FuelDto dto = new FuelDto("Petrol", 617.50, 1000.0);

		assertEquals("Petrol", dto.getName());
		assertEquals(617.50, dto.getPricePerLiter());
		assertEquals(1000.0, dto.getAvailableQuantity());
	}

	@Test
	void dto_storesAllFields_correctly() {
		FuelDto dto = new FuelDto("Diesel", 580.0, 500.0);

		assertEquals("Diesel", dto.getName());
		assertEquals(580.0, dto.getPricePerLiter());
		assertEquals(500.0, dto.getAvailableQuantity());
	}
}