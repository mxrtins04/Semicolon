package com.mxr.mfds.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FuelAttendantTest {

	@Test
	void constructor_createsValidAttendant_whenNameIsValid() {
		FuelAttendant attendant = new FuelAttendant("John Doe");
		
		assertEquals("John Doe", attendant.getFullName());
		assertTrue(attendant.getTransactions().isEmpty());
	}

	@Test
	void constructor_throwsException_whenNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new FuelAttendant(null);
		});
	}

	@Test
	void constructor_throwsException_whenNameIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new FuelAttendant("");
		});
	}

	@Test
	void constructor_throwsException_whenNameIsBlank() {
		assertThrows(IllegalArgumentException.class, () -> {
			new FuelAttendant("   ");
		});
	}

	@Test
	void addTransaction_addsTransactionToHistory_whenValidTransaction() {
		FuelAttendant attendant = new FuelAttendant("John Doe");
		Transaction transaction = new Transaction(
			LocalDateTime.now(),
			"Petrol",
			10.0,
			6175.0
		);
		
		attendant.addTransaction(transaction);
		
		assertEquals(1, attendant.getTransactions().size());
		assertTrue(attendant.getTransactions().contains(transaction));
	}

	@Test
	void addTransaction_throwsException_whenTransactionIsNull() {
		FuelAttendant attendant = new FuelAttendant("John Doe");
		
		assertThrows(IllegalArgumentException.class, () -> {
			attendant.addTransaction(null);
		});
	}

	@Test
	void addTransaction_addsMultipleTransactions_whenCalledMultipleTimes() {
		FuelAttendant attendant = new FuelAttendant("John Doe");
		Transaction transaction1 = new Transaction(
			LocalDateTime.now(),
			"Petrol",
			10.0,
			6175.0
		);
		Transaction transaction2 = new Transaction(
			LocalDateTime.now(),
			"Diesel",
			15.0,
			9000.0
		);
		
		attendant.addTransaction(transaction1);
		attendant.addTransaction(transaction2);
		
		assertEquals(2, attendant.getTransactions().size());
		assertTrue(attendant.getTransactions().contains(transaction1));
		assertTrue(attendant.getTransactions().contains(transaction2));
	}

	@Test
	void getTransactions_returnsUnmodifiableList_preventingExternalModification() {
		FuelAttendant attendant = new FuelAttendant("John Doe");
		Transaction transaction = new Transaction(
			LocalDateTime.now(),
			"Petrol",
			10.0,
			6175.0
		);
		attendant.addTransaction(transaction);
		
		List<Transaction> transactions = attendant.getTransactions();
		
		assertThrows(UnsupportedOperationException.class, () -> {
			transactions.add(new Transaction(
				LocalDateTime.now(),
				"Diesel",
				5.0,
				3000.0
			));
		});
	}

	@Test
	void getTransactions_returnsEmptyList_whenNoTransactionsAdded() {
		FuelAttendant attendant = new FuelAttendant("John Doe");
		
		List<Transaction> transactions = attendant.getTransactions();
		
		assertNotNull(transactions);
		assertTrue(transactions.isEmpty());
	}
}