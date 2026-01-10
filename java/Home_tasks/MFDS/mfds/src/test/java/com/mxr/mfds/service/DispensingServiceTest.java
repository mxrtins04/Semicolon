package com.mxr.mfds.service;

import com.mxr.mfds.model.Fuel;
import com.mxr.mfds.model.Transaction;
import com.mxr.mfds.repository.FuelRepository;
import com.mxr.mfds.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DispensingServiceTest {

	@Mock
	private FuelRepository fuelRepository;

	@Mock
	private TransactionRepository transactionRepository;

	private DispensingService dispensingService;

	@BeforeEach
	void setUp() {
		dispensingService = new DispensingService(fuelRepository, transactionRepository);
	}

	@Test
	void dispenseByLiters_dispensesSuccessfully_whenValidParametersProvided() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);
		when(fuelRepository.findByName("Petrol")).thenReturn(Optional.of(fuel));
		when(fuelRepository.update(fuel)).thenReturn(fuel);
		when(transactionRepository.save(any(Transaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

		Transaction result = dispensingService.dispenseByLiters("Petrol", 10.0);

		assertNotNull(result);
		assertEquals("Petrol", result.getFuelType());
		assertEquals(10.0, result.getQuantity());
		assertEquals(6175.0, result.getTotalCost());
		assertEquals(990.0, fuel.getAvailableQuantity());
		verify(fuelRepository).findByName("Petrol");
		verify(fuelRepository).update(fuel);
		verify(transactionRepository).save(any(Transaction.class));
	}

	@Test
	void dispenseByLiters_throwsException_whenFuelDoesNotExist() {
		when(fuelRepository.findByName("Kerosene")).thenReturn(Optional.empty());

		assertThrows(IllegalArgumentException.class, () -> {
			dispensingService.dispenseByLiters("Kerosene", 10.0);
		});

		verify(fuelRepository).findByName("Kerosene");
		verify(fuelRepository, never()).update(any(Fuel.class));
		verify(transactionRepository, never()).save(any(Transaction.class));
	}

	@Test
	void dispenseByLiters_throwsException_whenFuelNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			dispensingService.dispenseByLiters(null, 10.0);
		});

		verify(fuelRepository, never()).findByName(anyString());
		verify(fuelRepository, never()).update(any(Fuel.class));
		verify(transactionRepository, never()).save(any(Transaction.class));
	}

	@Test
	void dispenseByLiters_throwsException_whenFuelNameIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			dispensingService.dispenseByLiters("", 10.0);
		});

		verify(fuelRepository, never()).findByName(anyString());
		verify(fuelRepository, never()).update(any(Fuel.class));
		verify(transactionRepository, never()).save(any(Transaction.class));
	}

	@Test
	void dispenseByLiters_throwsException_whenLitersLessThanOne() {
		assertThrows(IllegalArgumentException.class, () -> {
			dispensingService.dispenseByLiters("Petrol", 0.5);
		});

		verify(fuelRepository, never()).findByName(anyString());
		verify(fuelRepository, never()).update(any(Fuel.class));
		verify(transactionRepository, never()).save(any(Transaction.class));
	}

	@Test
	void dispenseByLiters_throwsException_whenLitersExceedsFifty() {
		assertThrows(IllegalArgumentException.class, () -> {
			dispensingService.dispenseByLiters("Petrol", 51.0);
		});

		verify(fuelRepository, never()).findByName(anyString());
		verify(fuelRepository, never()).update(any(Fuel.class));
		verify(transactionRepository, never()).save(any(Transaction.class));
	}

	@Test
	void dispenseByLiters_allowsExactlyOneLiter_whenAtMinimumBoundary() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);
		when(fuelRepository.findByName("Petrol")).thenReturn(Optional.of(fuel));
		when(fuelRepository.update(fuel)).thenReturn(fuel);
		when(transactionRepository.save(any(Transaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

		Transaction result = dispensingService.dispenseByLiters("Petrol", 1.0);

		assertEquals(1.0, result.getQuantity());
		assertEquals(617.50, result.getTotalCost());
	}

	@Test
	void dispenseByLiters_allowsExactlyFiftyLiters_whenAtMaximumBoundary() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);
		when(fuelRepository.findByName("Petrol")).thenReturn(Optional.of(fuel));
		when(fuelRepository.update(fuel)).thenReturn(fuel);
		when(transactionRepository.save(any(Transaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

		Transaction result = dispensingService.dispenseByLiters("Petrol", 50.0);

		assertEquals(50.0, result.getQuantity());
		assertEquals(30875.0, result.getTotalCost());
	}

	@Test
	void dispenseByLiters_throwsException_whenInsufficientFuel() {
		Fuel fuel = new Fuel("Petrol", 617.50, 5.0);
		when(fuelRepository.findByName("Petrol")).thenReturn(Optional.of(fuel));

		assertThrows(IllegalStateException.class, () -> {
			dispensingService.dispenseByLiters("Petrol", 10.0);
		});

		verify(fuelRepository).findByName("Petrol");
		verify(fuelRepository, never()).update(any(Fuel.class));
		verify(transactionRepository, never()).save(any(Transaction.class));
	}

	@Test
	void dispenseByAmount_dispensesSuccessfully_whenValidParametersProvided() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);
		when(fuelRepository.findByName("Petrol")).thenReturn(Optional.of(fuel));
		when(fuelRepository.update(fuel)).thenReturn(fuel);
		when(transactionRepository.save(any(Transaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

		Transaction result = dispensingService.dispenseByAmount("Petrol", 6175.0);

		assertNotNull(result);
		assertEquals("Petrol", result.getFuelType());
		assertEquals(10.0, result.getQuantity());
		assertEquals(6175.0, result.getTotalCost());
		assertEquals(990.0, fuel.getAvailableQuantity());
		verify(fuelRepository).findByName("Petrol");
		verify(fuelRepository).update(fuel);
		verify(transactionRepository).save(any(Transaction.class));
	}

	@Test
	void dispenseByAmount_throwsException_whenFuelDoesNotExist() {
		when(fuelRepository.findByName("Kerosene")).thenReturn(Optional.empty());

		assertThrows(IllegalArgumentException.class, () -> {
			dispensingService.dispenseByAmount("Kerosene", 5000.0);
		});

		verify(fuelRepository).findByName("Kerosene");
		verify(fuelRepository, never()).update(any(Fuel.class));
		verify(transactionRepository, never()).save(any(Transaction.class));
	}

	@Test
	void dispenseByAmount_throwsException_whenFuelNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			dispensingService.dispenseByAmount(null, 5000.0);
		});

		verify(fuelRepository, never()).findByName(anyString());
		verify(fuelRepository, never()).update(any(Fuel.class));
		verify(transactionRepository, never()).save(any(Transaction.class));
	}

	@Test
	void dispenseByAmount_throwsException_whenFuelNameIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			dispensingService.dispenseByAmount("", 5000.0);
		});

		verify(fuelRepository, never()).findByName(anyString());
		verify(fuelRepository, never()).update(any(Fuel.class));
		verify(transactionRepository, never()).save(any(Transaction.class));
	}

	@Test
	void dispenseByAmount_throwsException_whenAmountLessThanPricePerLiter() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);
		when(fuelRepository.findByName("Petrol")).thenReturn(Optional.of(fuel));

		assertThrows(IllegalArgumentException.class, () -> {
			dispensingService.dispenseByAmount("Petrol", 500.0);
		});

		verify(fuelRepository).findByName("Petrol");
		verify(fuelRepository, never()).update(any(Fuel.class));
		verify(transactionRepository, never()).save(any(Transaction.class));
	}

	@Test
	void dispenseByAmount_allowsExactlyPricePerLiter_whenAtMinimumBoundary() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);
		when(fuelRepository.findByName("Petrol")).thenReturn(Optional.of(fuel));
		when(fuelRepository.update(fuel)).thenReturn(fuel);
		when(transactionRepository.save(any(Transaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

		Transaction result = dispensingService.dispenseByAmount("Petrol", 617.50);

		assertEquals(1.0, result.getQuantity());
		assertEquals(617.50, result.getTotalCost());
	}

	@Test
	void dispenseByAmount_throwsException_whenCalculatedLitersExceedFifty() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);
		when(fuelRepository.findByName("Petrol")).thenReturn(Optional.of(fuel));

		assertThrows(IllegalArgumentException.class, () -> {
			dispensingService.dispenseByAmount("Petrol", 35000.0);
		});

		verify(fuelRepository).findByName("Petrol");
		verify(fuelRepository, never()).update(any(Fuel.class));
		verify(transactionRepository, never()).save(any(Transaction.class));
	}

	@Test
	void dispenseByAmount_throwsException_whenInsufficientFuel() {
		Fuel fuel = new Fuel("Petrol", 617.50, 5.0);
		when(fuelRepository.findByName("Petrol")).thenReturn(Optional.of(fuel));

		assertThrows(IllegalStateException.class, () -> {
			dispensingService.dispenseByAmount("Petrol", 6175.0);
		});

		verify(fuelRepository).findByName("Petrol");
		verify(fuelRepository, never()).update(any(Fuel.class));
		verify(transactionRepository, never()).save(any(Transaction.class));
	}

	@Test
	void getAllTransactions_returnsAllTransactions_whenTransactionsExist() {
		List<Transaction> transactions = Arrays.asList(
			new Transaction(java.time.LocalDateTime.now(), "Petrol", 10.0, 6175.0),
			new Transaction(java.time.LocalDateTime.now(), "Diesel", 15.0, 8700.0)
		);
		when(transactionRepository.findAll()).thenReturn(transactions);

		List<Transaction> result = dispensingService.getAllTransactions();

		assertEquals(2, result.size());
		verify(transactionRepository).findAll();
	}

	@Test
	void getAllTransactions_returnsEmptyList_whenNoTransactionsExist() {
		when(transactionRepository.findAll()).thenReturn(Arrays.asList());

		List<Transaction> result = dispensingService.getAllTransactions();

		assertTrue(result.isEmpty());
		verify(transactionRepository).findAll();
	}

	@Test
	void dispenseByLiters_createsTransactionWithTimestamp_whenDispensing() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);
		when(fuelRepository.findByName("Petrol")).thenReturn(Optional.of(fuel));
		when(fuelRepository.update(fuel)).thenReturn(fuel);

		ArgumentCaptor<Transaction> transactionCaptor = ArgumentCaptor.forClass(Transaction.class);
		when(transactionRepository.save(transactionCaptor.capture())).thenAnswer(invocation -> invocation.getArgument(0));

		dispensingService.dispenseByLiters("Petrol", 10.0);

		Transaction savedTransaction = transactionCaptor.getValue();
		assertNotNull(savedTransaction.getTimestamp());
		assertTrue(savedTransaction.getTimestamp().isBefore(java.time.LocalDateTime.now().plusSeconds(1)));
	}

	@Test
	void dispenseByAmount_createsTransactionWithTimestamp_whenDispensing() {
		Fuel fuel = new Fuel("Petrol", 617.50, 1000.0);
		when(fuelRepository.findByName("Petrol")).thenReturn(Optional.of(fuel));
		when(fuelRepository.update(fuel)).thenReturn(fuel);

		ArgumentCaptor<Transaction> transactionCaptor = ArgumentCaptor.forClass(Transaction.class);
		when(transactionRepository.save(transactionCaptor.capture())).thenAnswer(invocation -> invocation.getArgument(0));

		dispensingService.dispenseByAmount("Petrol", 6175.0);

		Transaction savedTransaction = transactionCaptor.getValue();
		assertNotNull(savedTransaction.getTimestamp());
		assertTrue(savedTransaction.getTimestamp().isBefore(java.time.LocalDateTime.now().plusSeconds(1)));
	}
}