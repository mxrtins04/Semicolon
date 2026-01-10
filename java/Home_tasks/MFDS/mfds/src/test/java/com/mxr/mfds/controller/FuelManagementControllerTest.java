package com.mxr.mfds.controller;

import com.mxr.mfds.dto.FuelDto;
import com.mxr.mfds.mapper.FuelMapper;
import com.mxr.mfds.model.Fuel;
import com.mxr.mfds.service.FuelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.mxr.mfds.model.FuelType;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FuelManagementControllerTest {

	@Mock
	private FuelService fuelService;

	@Mock
	private FuelMapper fuelMapper;

	private FuelManagementController controller;

	@BeforeEach
	void setUp() {
		controller = new FuelManagementController(fuelService, fuelMapper);
	}

	@Test
	void addFuel_returnsSuccessMessage_whenFuelAddedSuccessfully() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 1000.0);
		when(fuelService.addFuel(FuelType.PETROL, 617.50, 1000.0)).thenReturn(fuel);

		String result = controller.addFuel(FuelType.PETROL, 617.50, 1000.0);

		assertNotNull(result);
		assertTrue(result.contains("successfully"));
		assertTrue(result.contains("PETROL"));
		verify(fuelService).addFuel(FuelType.PETROL, 617.50, 1000.0);
	}

	@Test
	void addFuel_returnsErrorMessage_whenFuelAlreadyExists() {
		when(fuelService.addFuel(FuelType.PETROL, 617.50, 1000.0))
			.thenThrow(new IllegalStateException("Fuel already exists"));

		String result = controller.addFuel(FuelType.PETROL, 617.50, 1000.0);

		assertNotNull(result);
		assertTrue(result.contains("Error") || result.contains("already exists"));
		verify(fuelService).addFuel(FuelType.PETROL, 617.50, 1000.0);
	}

	@Test
	void addFuel_returnsErrorMessage_whenInvalidParameters() {
		when(fuelService.addFuel(FuelType.PETROL, 617.50, 1000.0))
			.thenThrow(new IllegalArgumentException("Invalid name"));

		String result = controller.addFuel(FuelType.PETROL, 617.50, 1000.0);

		assertNotNull(result);
		assertTrue(result.contains("Error") || result.contains("Invalid"));
		verify(fuelService).addFuel(FuelType.DIESEL, 617.50, 1000.0);
	}

	@Test
	void listFuels_returnsFormattedList_whenFuelsExist() {
		List<Fuel> fuels = Arrays.asList(
			new Fuel(FuelType.PETROL, 617.50, 1000.0),
			new Fuel(FuelType.DIESEL, 580.0, 800.0)
		);
		List<FuelDto> dtos = Arrays.asList(
			new FuelDto("PETROL", 617.50, 1000.0),
			new FuelDto("DIESEL", 580.0, 800.0)
		);

		when(fuelService.getAllFuels()).thenReturn(fuels);
		when(fuelMapper.toDtoList(fuels)).thenReturn(dtos);

		String result = controller.listFuels();

		assertNotNull(result);
		assertTrue(result.contains("PETROL"));
		assertTrue(result.contains("DIESEL"));
		verify(fuelService).getAllFuels();
		verify(fuelMapper).toDtoList(fuels);
	}

	@Test
	void listFuels_returnsNoFuelsMessage_whenNoFuelsExist() {

		String result = controller.listFuels();

		assertNotNull(result);
		assertTrue(result.contains("No fuels") || result.contains("empty"));
		verify(fuelService).getAllFuels();
	}

	@Test
	void updatePrice_returnsSuccessMessage_whenPriceUpdatedSuccessfully() {
		Fuel fuel = new Fuel(FuelType.PETROL, 650.0, 1000.0);
		when(fuelService.updateFuelPrice("petrol", 650.0)).thenReturn(fuel);

		String result = controller.updatePrice("petrol", 650.0);

		assertNotNull(result);
		assertTrue(result.contains("updated") || result.contains("success"));
		assertTrue(result.contains("petrol"));
		verify(fuelService).updateFuelPrice("petrol", 650.0);
	}

	@Test
	void updatePrice_returnsErrorMessage_whenFuelNotFound() {
		when(fuelService.updateFuelPrice("Kerosene", 450.0))
			.thenThrow(new IllegalArgumentException("Fuel not found"));

		String result = controller.updatePrice("Kerosene", 450.0);

		assertNotNull(result);
		assertTrue(result.contains("Error") || result.contains("not found"));
		verify(fuelService).updateFuelPrice("Kerosene", 450.0);
	}

	@Test
	void updatePrice_returnsErrorMessage_whenInvalidPrice() {
		when(fuelService.updateFuelPrice("petrol", -100.0))
			.thenThrow(new IllegalArgumentException("Invalid price"));

		String result = controller.updatePrice("petrol", -100.0);

		assertNotNull(result);
		assertTrue(result.contains("Error") || result.contains("Invalid"));
		verify(fuelService).updateFuelPrice("petrol", -100.0);
	}

	@Test
	void restock_returnsSuccessMessage_whenRestockSuccessful() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 1500.0);
		when(fuelService.restockFuel("petrol", 500.0)).thenReturn(fuel);

		String result = controller.restock("petrol", 500.0);

		assertNotNull(result);
		assertTrue(result.contains("restocked") || result.contains("success"));
		assertTrue(result.contains("petrol"));
		verify(fuelService).restockFuel("petrol", 500.0);
	}

	@Test
	void restock_returnsErrorMessage_whenFuelNotFound() {
		when(fuelService.restockFuel("Kerosene", 500.0))
			.thenThrow(new IllegalArgumentException("Fuel not found"));

		String result = controller.restock("Kerosene", 500.0);

		assertNotNull(result);
		assertTrue(result.contains("Error") || result.contains("not found"));
		verify(fuelService).restockFuel("Kerosene", 500.0);
	}

	@Test
	void restock_returnsErrorMessage_whenInvalidQuantity() {
		when(fuelService.restockFuel("petrol", -100.0))
			.thenThrow(new IllegalArgumentException("Invalid quantity"));

		String result = controller.restock("petrol", -100.0);

		assertNotNull(result);
		assertTrue(result.contains("Error") || result.contains("Invalid"));
		verify(fuelService).restockFuel("petrol", -100.0);
	}
}