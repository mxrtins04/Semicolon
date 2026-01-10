package com.mxr.mfds.service;

import com.mxr.mfds.model.Fuel;
import com.mxr.mfds.repository.FuelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.mxr.mfds.model.FuelType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FuelServiceTest {

	@Mock
	private FuelRepository fuelRepository;

	private FuelService fuelService;

	@BeforeEach
	void setUp() {
		fuelService = new FuelService(fuelRepository);
	}

	@Test
	void addFuel_createsFuel_whenValidParametersProvided() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 1000.0);
		when(fuelRepository.existsByName("Petrol")).thenReturn(false);
		when(fuelRepository.save(any(Fuel.class))).thenReturn(fuel);

		Fuel result = fuelService.addFuel(FuelType.PETROL, 617.50, 1000.0);

		assertNotNull(result);
		assertEquals("Petrol", result.getName());
		assertEquals(617.50, result.getPricePerLiter());
		assertEquals(1000.0, result.getAvailableQuantity());
		verify(fuelRepository).existsByName("Petrol");
		verify(fuelRepository).save(any(Fuel.class));
	}

	@Test
	void addFuel_throwsException_whenFuelAlreadyExists() {
		when(fuelRepository.existsByName("Petrol")).thenReturn(true);

		assertThrows(IllegalStateException.class, () -> {
			fuelService.addFuel(FuelType.PETROL, 617.50, 1000.0);
		});

		verify(fuelRepository).existsByName("Petrol");
		verify(fuelRepository, never()).save(any(Fuel.class));
	}

	@Test
	void addFuel_throwsException_whenNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.addFuel(null, 617.50, 1000.0);
		});

		verify(fuelRepository, never()).existsByName(anyString());
		verify(fuelRepository, never()).save(any(Fuel.class));
	}

	@Test
	void addFuel_throwsException_whenPriceIsZero() {
		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.addFuel(FuelType.PETROL, 0.0, 1000.0);
		});

		verify(fuelRepository, never()).existsByName(anyString());
		verify(fuelRepository, never()).save(any(Fuel.class));
	}

	@Test
	void addFuel_throwsException_whenPriceIsNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.addFuel(FuelType.PETROL, -100.0, 1000.0);
		});

		verify(fuelRepository, never()).existsByName(anyString());
		verify(fuelRepository, never()).save(any(Fuel.class));
	}

	@Test
	void addFuel_throwsException_whenQuantityIsNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.addFuel(FuelType.PETROL, 617.50, -100.0);
		});

		verify(fuelRepository, never()).existsByName(anyString());
		verify(fuelRepository, never()).save(any(Fuel.class));
	}

	@Test
	void getAllFuels_returnsAllFuels_whenFuelsExist() {
		List<Fuel> fuels = Arrays.asList(
			new Fuel(FuelType.PETROL, 617.50, 1000.0),
			new Fuel(FuelType.DIESEL, 580.0, 800.0)
		);
		when(fuelRepository.findAll()).thenReturn(fuels);

		List<Fuel> result = fuelService.getAllFuels();

		assertEquals(2, result.size());
		verify(fuelRepository).findAll();
	}

	@Test
	void getAllFuels_returnsEmptyList_whenNoFuelsExist() {
		when(fuelRepository.findAll()).thenReturn(Arrays.asList());

		List<Fuel> result = fuelService.getAllFuels();

		assertTrue(result.isEmpty());
		verify(fuelRepository).findAll();
	}

	@Test
	void getFuelByName_returnsFuel_whenFuelExists() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 1000.0);
		when(fuelRepository.findByName("Petrol")).thenReturn(Optional.of(fuel));

		Fuel result = fuelService.getFuelByName("Petrol");

		assertNotNull(result);
		assertEquals("Petrol", result.getName());
		verify(fuelRepository).findByName("Petrol");
	}

	@Test
	void getFuelByName_throwsException_whenFuelDoesNotExist() {
		when(fuelRepository.findByName("Kerosene")).thenReturn(Optional.empty());

		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.getFuelByName("Kerosene");
		});

		verify(fuelRepository).findByName("Kerosene");
	}

	@Test
	void getFuelByName_throwsException_whenNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.getFuelByName(null);
		});

		verify(fuelRepository, never()).findByName(anyString());
	}

	@Test
	void getFuelByName_throwsException_whenNameIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.getFuelByName("");
		});

		verify(fuelRepository, never()).findByName(anyString());
	}

	@Test
	void updateFuelPrice_updatesPrice_whenFuelExists() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 1000.0);
		when(fuelRepository.findByName("Petrol")).thenReturn(Optional.of(fuel));
		when(fuelRepository.update(fuel)).thenReturn(fuel);

		Fuel result = fuelService.updateFuelPrice("Petrol", 650.0);

		assertEquals(650.0, result.getPricePerLiter());
		verify(fuelRepository).findByName("Petrol");
		verify(fuelRepository).update(fuel);
	}

	@Test
	void updateFuelPrice_throwsException_whenFuelDoesNotExist() {
		when(fuelRepository.findByName("Kerosene")).thenReturn(Optional.empty());

		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.updateFuelPrice("Kerosene", 450.0);
		});

		verify(fuelRepository).findByName("Kerosene");
		verify(fuelRepository, never()).update(any(Fuel.class));
	}

	@Test
	void updateFuelPrice_throwsException_whenNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.updateFuelPrice(null, 650.0);
		});

		verify(fuelRepository, never()).findByName(anyString());
		verify(fuelRepository, never()).update(any(Fuel.class));
	}

	@Test
	void updateFuelPrice_throwsException_whenNameIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.updateFuelPrice("", 650.0);
		});

		verify(fuelRepository, never()).findByName(anyString());
		verify(fuelRepository, never()).update(any(Fuel.class));
	}

	@Test
	void updateFuelPrice_throwsException_whenNewPriceIsZero() {
		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.updateFuelPrice("Petrol", 0.0);
		});

		verify(fuelRepository, never()).findByName(anyString());
		verify(fuelRepository, never()).update(any(Fuel.class));
	}

	@Test
	void updateFuelPrice_throwsException_whenNewPriceIsNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.updateFuelPrice("Petrol", -100.0);
		});

		verify(fuelRepository, never()).findByName(anyString());
		verify(fuelRepository, never()).update(any(Fuel.class));
	}

	@Test
	void restockFuel_addsQuantity_whenFuelExists() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 500.0);
		when(fuelRepository.findByName("Petrol")).thenReturn(Optional.of(fuel));
		when(fuelRepository.update(fuel)).thenReturn(fuel);

		Fuel result = fuelService.restockFuel("Petrol", 500.0);

		assertEquals(1000.0, result.getAvailableQuantity());
		verify(fuelRepository).findByName("Petrol");
		verify(fuelRepository).update(fuel);
	}

	@Test
	void restockFuel_throwsException_whenFuelDoesNotExist() {
		when(fuelRepository.findByName("Kerosene")).thenReturn(Optional.empty());

		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.restockFuel("Kerosene", 500.0);
		});

		verify(fuelRepository).findByName("Kerosene");
		verify(fuelRepository, never()).update(any(Fuel.class));
	}

	@Test
	void restockFuel_throwsException_whenNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.restockFuel(null, 500.0);
		});

		verify(fuelRepository, never()).findByName(anyString());
		verify(fuelRepository, never()).update(any(Fuel.class));
	}

	@Test
	void restockFuel_throwsException_whenNameIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.restockFuel("", 500.0);
		});

		verify(fuelRepository, never()).findByName(anyString());
		verify(fuelRepository, never()).update(any(Fuel.class));
	}

	@Test
	void restockFuel_throwsException_whenQuantityIsZero() {
		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.restockFuel("Petrol", 0.0);
		});

		verify(fuelRepository, never()).findByName(anyString());
		verify(fuelRepository, never()).update(any(Fuel.class));
	}

	@Test
	void restockFuel_throwsException_whenQuantityIsNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			fuelService.restockFuel("Petrol", -100.0);
		});

		verify(fuelRepository, never()).findByName(anyString());
		verify(fuelRepository, never()).update(any(Fuel.class));
	}
}