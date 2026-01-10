package com.mxr.mfds.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FuelTest {

    @Test
	void addQuantity_throwsException_whenAmountIsNegative() {
		Fuel fuel = new Fuel(FuelType.DIESEL, 617.50, 100.0);
		
		assertThrows(IllegalArgumentException.class, () -> {
			fuel.addQuantity(-50.0);
		});
	}

	@Test
	void constructor_createsValidFuel_whenAllParametersValid() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 1000.0);
		
		assertEquals("Petrol 95", fuel.getName());
		assertEquals(617.50, fuel.getPricePerLiter());
		assertEquals(1000.0, fuel.getAvailableQuantity());
	}

	@Test
	void constructor_throwsException_whenFuelTypeIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Fuel(null, 617.50, 1000.0);
		});
	}

	@Test
	void constructor_throwsException_whenPriceIsZero() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Fuel(FuelType.PETROL, 0.0, 1000.0);
		});
	}

	@Test
	void constructor_throwsException_whenPriceIsNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Fuel(FuelType.PETROL, -100.0, 1000.0);
		});
	}

	@Test
	void constructor_throwsException_whenQuantityIsNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Fuel(FuelType.PETROL, 617.50, -10.0);
		});
	}

	@Test
	void constructor_createsValidFuel_whenQuantityIsZero() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 0.0);
		
		assertEquals(0.0, fuel.getAvailableQuantity());
	}

	@Test
	void deductQuantity_reducesAvailableQuantity_whenSufficientFuelAvailable() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 1000.0);
		
		fuel.deductQuantity(50.0);
		
		assertEquals(950.0, fuel.getAvailableQuantity());
	}

	@Test
	void deductQuantity_reducesToZero_whenDeductingAllAvailableFuel() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 100.0);
		
		fuel.deductQuantity(100.0);
		
		assertEquals(0.0, fuel.getAvailableQuantity());
	}

	@Test
	void deductQuantity_throwsException_whenAmountIsNegative() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 1000.0);
		
		assertThrows(IllegalArgumentException.class, () -> {
			fuel.deductQuantity(-10.0);
		});
	}

	@Test
	void deductQuantity_throwsException_whenAmountIsZero() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 1000.0);
		
		assertThrows(IllegalArgumentException.class, () -> {
			fuel.deductQuantity(0.0);
		});
	}

	@Test
	void deductQuantity_throwsException_whenInsufficientFuel() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 50.0);
		
		assertThrows(IllegalStateException.class, () -> {
			fuel.deductQuantity(100.0);
		});
	}

	@Test
	void addQuantity_increasesAvailableQuantity_whenValidAmount() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 100.0);
		
		fuel.addQuantity(500.0);
		
		assertEquals(600.0, fuel.getAvailableQuantity());
	}

	@Test
	void addQuantity_increasesFromZero_whenRestockingEmptyFuel() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 0.0);
		
		fuel.addQuantity(1000.0);
		
		assertEquals(1000.0, fuel.getAvailableQuantity());
	}

	@Test
	void addQuantity_throwsException_whenAmountIsZero() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 100.0);
		
		assertThrows(IllegalArgumentException.class, () -> {
			fuel.addQuantity(0.0);
		});
	}

	@Test
	void updatePrice_changesPrice_whenValidNewPrice() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 1000.0);
		
		fuel.updatePrice(650.0);
		
		assertEquals(650.0, fuel.getPricePerLiter());
	}

	@Test
	void updatePrice_throwsException_whenNewPriceIsZero() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 1000.0);
		
		assertThrows(IllegalArgumentException.class, () -> {
			fuel.updatePrice(0.0);
		});
	}

	@Test
	void updatePrice_throwsException_whenNewPriceIsNegative() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 1000.0);
		
		assertThrows(IllegalArgumentException.class, () -> {
			fuel.updatePrice(-100.0);
		});
	}

	@Test
	void hasAvailableQuantity_returnsTrue_whenSufficientFuelAvailable() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 1000.0);
		
		assertTrue(fuel.hasAvailableQuantity(500.0));
	}

	@Test
	void hasAvailableQuantity_returnsTrue_whenExactAmountAvailable() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 100.0);
		
		assertTrue(fuel.hasAvailableQuantity(100.0));
	}

	@Test
	void hasAvailableQuantity_returnsFalse_whenInsufficientFuel() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 50.0);
		
		assertFalse(fuel.hasAvailableQuantity(100.0));
	}

	@Test
	void hasAvailableQuantity_returnsFalse_whenFuelIsEmpty() {
		Fuel fuel = new Fuel(FuelType.PETROL, 617.50, 0.0);
		
		assertFalse(fuel.hasAvailableQuantity(10.0));
	}
}