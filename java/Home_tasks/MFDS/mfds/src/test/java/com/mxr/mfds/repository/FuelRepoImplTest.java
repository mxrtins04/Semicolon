package com.mxr.mfds.repository;

import com.mxr.mfds.model.Fuel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryFuelRepositoryTest {

	private FuelRepository repository;

	@BeforeEach
	void setUp() {
		repository = new InMemoryFuelRepository();
	}

	@Test
	void save_storesFuel_whenValidFuelProvided() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);
		
		Fuel saved = repository.save(fuel);
		
		assertNotNull(saved);
		assertEquals("Petrol", saved.getName());
		assertEquals(617.50, saved.getPricePerLiter());
		assertEquals(1000.0, saved.getAvailableQuantity());
	}

	@Test
	void save_throwsException_whenFuelIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			repository.save(null);
		});
	}

	@Test
	void save_throwsException_whenFuelWithSameNameAlreadyExists() {
		Fuel fuel1 = new Fuel("Petrol", 617.50, 1000.0);
		repository.save(fuel1);
		
		Fuel fuel2 = new Fuel("Petrol", 650.0, 500.0);
		
		assertThrows(IllegalStateException.class, () -> {
			repository.save(fuel2);
		});
	}

	@Test
	void findByName_returnsFuel_whenFuelExists() {
		Fuel fuel = new Fuel("Diesel", 580.0, 800.0);
		repository.save(fuel);
		
		Optional<Fuel> found = repository.findByName("Diesel");
		
		assertTrue(found.isPresent());
		assertEquals("Diesel", found.get().getName());
		assertEquals(580.0, found.get().getPricePerLiter());
		assertEquals(800.0, found.get().getAvailableQuantity());
	}

	@Test
	void findByName_returnsEmpty_whenFuelDoesNotExist() {
		Optional<Fuel> found = repository.findByName("Kerosene");
		
		assertFalse(found.isPresent());
	}

	@Test
	void findByName_isCaseInsensitive_whenSearchingForFuel() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);
		repository.save(fuel);
		
		Optional<Fuel> found = repository.findByName("petrol");
		
		assertTrue(found.isPresent());
		assertEquals("Petrol", found.get().getName());
	}

	@Test
	void findByName_throwsException_whenNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			repository.findByName(null);
		});
	}

	@Test
	void findByName_throwsException_whenNameIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			repository.findByName("");
		});
	}

	@Test
	void findAll_returnsEmptyList_whenNoFuelsStored() {
		List<Fuel> fuels = repository.findAll();
		
		assertNotNull(fuels);
		assertTrue(fuels.isEmpty());
	}

	@Test
	void findAll_returnsAllFuels_whenMultipleFuelsStored() {
		Fuel petrol = new Fuel("Petrol", 617.50, 1000.0);
		Fuel diesel = new Fuel("Diesel", 580.0, 800.0);
		Fuel kerosene = new Fuel("Kerosene", 450.0, 600.0);
		
		repository.save(petrol);
		repository.save(diesel);
		repository.save(kerosene);
		
		List<Fuel> fuels = repository.findAll();
		
		assertEquals(3, fuels.size());
		assertTrue(fuels.stream().anyMatch(fuel -> fuel.getName().equals("Petrol")));
		assertTrue(fuels.stream().anyMatch(fuel -> fuel.getName().equals("Diesel")));
		assertTrue(fuels.stream().anyMatch(fuel -> fuel.getName().equals("Kerosene")));
	}

	@Test
	void findAll_returnsUnmodifiableList_preventingExternalModification() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);
		repository.save(fuel);
		
		List<Fuel> fuels = repository.findAll();
		
		assertThrows(UnsupportedOperationException.class, () -> {
			fuels.add(new Fuel("Diesel", 580.0, 800.0));
		});
	}

	@Test
	void existsByName_returnsTrue_whenFuelExists() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);
		repository.save(fuel);
		
		assertTrue(repository.existsByName("Petrol"));
	}

	@Test
	void existsByName_returnsFalse_whenFuelDoesNotExist() {
		assertFalse(repository.existsByName("Diesel"));
	}

	@Test
	void existsByName_isCaseInsensitive_whenCheckingExistence() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);
		repository.save(fuel);
		
		assertTrue(repository.existsByName("petrol"));
		assertTrue(repository.existsByName("PETROL"));
		assertTrue(repository.existsByName("PeTrOl"));
	}

	@Test
	void existsByName_throwsException_whenNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			repository.existsByName(null);
		});
	}

	@Test
	void existsByName_throwsException_whenNameIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			repository.existsByName("");
		});
	}

	@Test
	void update_updatesFuel_whenFuelExists() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);
		repository.save(fuel);
		
		fuel.updatePrice(650.0);
		fuel.deductQuantity(200.0);
		
		Fuel updated = repository.update(fuel);
		
		assertEquals(650.0, updated.getPricePerLiter());
		assertEquals(800.0, updated.getAvailableQuantity());
	}

	@Test
	void update_throwsException_whenFuelIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			repository.update(null);
		});
	}

	@Test
	void update_throwsException_whenFuelDoesNotExist() {
		Fuel fuel = new Fuel("Kerosene", 450.0, 600.0);
		
		assertThrows(IllegalStateException.class, () -> {
			repository.update(fuel);
		});
	}

	@Test
	void delete_removesFuel_whenFuelExists() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);
		repository.save(fuel);
		
		repository.delete("Petrol");
		
		assertFalse(repository.existsByName("Petrol"));
	}

	@Test
	void delete_throwsException_whenNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			repository.delete(null);
		});
	}

	@Test
	void delete_throwsException_whenNameIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			repository.delete("");
		});
	}

	@Test
	void delete_throwsException_whenFuelDoesNotExist() {
		assertThrows(IllegalStateException.class, () -> {
			repository.delete("NonExistent");
		});
	}

	@Test
	void repository_maintainsDataIntegrity_acrossMultipleOperations() {
		Fuel petrol = new Fuel("Petrol", 617.50, 1000.0);
		Fuel diesel = new Fuel("Diesel", 580.0, 800.0);
		
		repository.save(petrol);
		repository.save(diesel);
		
		assertEquals(2, repository.findAll().size());
		
		petrol.updatePrice(650.0);
		repository.update(petrol);
		
		Optional<Fuel> found = repository.findByName("Petrol");
		assertTrue(found.isPresent());
		assertEquals(650.0, found.get().getPricePerLiter());
		
		repository.delete("Diesel");
		
		assertEquals(1, repository.findAll().size());
		assertTrue(repository.existsByName("Petrol"));
		assertFalse(repository.existsByName("Diesel"));
	}
}