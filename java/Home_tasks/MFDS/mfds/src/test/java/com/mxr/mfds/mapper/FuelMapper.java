package com.mxr.mfds.mapper;

import com.mxr.mfds.dto.FuelDto;
import com.mxr.mfds.model.Fuel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FuelMapperTest {

	private FuelMapper mapper;

	@BeforeEach
	void setUp() {
		mapper = new FuelMapper();
	}

	@Test
	void toDto_convertsModelToDto_whenValidFuelProvided() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);

		FuelDto dto = mapper.toDto(fuel);

		assertNotNull(dto);
		assertEquals("Petrol", dto.getName());
		assertEquals(617.50, dto.getPricePerLiter());
		assertEquals(1000.0, dto.getAvailableQuantity());
	}

	@Test
	void toDto_throwsException_whenFuelIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			mapper.toDto(null);
		});
	}

	@Test
	void toDtoList_convertsMultipleFuels_whenValidListProvided() {
		List<Fuel> fuels = Arrays.asList(
			new Fuel("Petrol", 617.50, 1000.0),
			new Fuel("Diesel", 580.0, 800.0),
			new Fuel("Kerosene", 450.0, 600.0)
		);

		List<FuelDto> dtos = mapper.toDtoList(fuels);

		assertNotNull(dtos);
		assertEquals(3, dtos.size());
		assertEquals("Petrol", dtos.get(0).getName());
		assertEquals("Diesel", dtos.get(1).getName());
		assertEquals("Kerosene", dtos.get(2).getName());
	}

	@Test
	void toDtoList_returnsEmptyList_whenEmptyListProvided() {
		List<Fuel> fuels = Arrays.asList();

		List<FuelDto> dtos = mapper.toDtoList(fuels);

		assertNotNull(dtos);
		assertTrue(dtos.isEmpty());
	}

	@Test
	void toDtoList_throwsException_whenListIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			mapper.toDtoList(null);
		});
	}

	@Test
	void toDtoList_throwsException_whenListContainsNullFuel() {
		List<Fuel> fuels = Arrays.asList(
			new Fuel("Petrol", 617.50, 1000.0),
			null,
			new Fuel("Diesel", 580.0, 800.0)
		);

		assertThrows(IllegalArgumentException.class, () -> {
			mapper.toDtoList(fuels);
		});
	}
}