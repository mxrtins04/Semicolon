package com.mxr.mfds.repository;

import com.mxr.mfds.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTransactionRepositoryTest {

	private TransactionRepository repository;

	@BeforeEach
	void setUp() {
		repository = new InMemoryTransactionRepository();
	}

	@Test
	void save_storesTransaction_whenValidTransactionProvided() {
		Transaction transaction = new Transaction(
			LocalDateTime.now(),
			"Petrol",
			10.0,
			6175.0
		);
		
		Transaction saved = repository.save(transaction);
		
		assertNotNull(saved);
		assertEquals("Petrol", saved.getFuelType());
		assertEquals(10.0, saved.getQuantity());
		assertEquals(6175.0, saved.getTotalCost());
	}

	@Test
	void save_throwsException_whenTransactionIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			repository.save(null);
		});
	}

	@Test
	void findAll_returnsEmptyList_whenNoTransactionsStored() {
		List<Transaction> transactions = repository.findAll();
		
		assertNotNull(transactions);
		assertTrue(transactions.isEmpty());
	}

	@Test
	void findAll_returnsAllTransactions_whenMultipleTransactionsStored() {
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
			8700.0
		);
		Transaction transaction3 = new Transaction(
			LocalDateTime.now(),
			"Petrol",
			20.0,
			12350.0
		);
		
		repository.save(transaction1);
		repository.save(transaction2);
		repository.save(transaction3);
		
		List<Transaction> transactions = repository.findAll();
		
		assertEquals(3, transactions.size());
	}

	@Test
	void findAll_returnsTransactionsInOrderOfInsertion_whenMultipleTransactionsStored() {
		Transaction transaction1 = new Transaction(
			LocalDateTime.of(2024, 1, 1, 10, 0),
			"Petrol",
			10.0,
			6175.0
		);
		Transaction transaction2 = new Transaction(
			LocalDateTime.of(2024, 1, 1, 11, 0),
			"Diesel",
			15.0,
			8700.0
		);
		Transaction transaction3 = new Transaction(
			LocalDateTime.of(2024, 1, 1, 12, 0),
			"Kerosene",
			20.0,
			9000.0
		);
		
		repository.save(transaction1);
		repository.save(transaction2);
		repository.save(transaction3);
		
		List<Transaction> transactions = repository.findAll();
		
		assertEquals("Petrol", transactions.get(0).getFuelType());
		assertEquals("Diesel", transactions.get(1).getFuelType());
		assertEquals("Kerosene", transactions.get(2).getFuelType());
	}

	@Test
	void findAll_returnsUnmodifiableList_preventingExternalModification() {
		Transaction transaction = new Transaction(
			LocalDateTime.now(),
			"Petrol",
			10.0,
			6175.0
		);
		repository.save(transaction);
		
		List<Transaction> transactions = repository.findAll();
		
		assertThrows(UnsupportedOperationException.class, () -> {
			transactions.add(new Transaction(
				LocalDateTime.now(),
				"Diesel",
				5.0,
				2900.0
			));
		});
	}

	@Test
	void repository_allowsDuplicateTransactions_forSameFuelType() {
		Transaction transaction1 = new Transaction(
			LocalDateTime.now(),
			"Petrol",
			10.0,
			6175.0
		);
		Transaction transaction2 = new Transaction(
			LocalDateTime.now(),
			"Petrol",
			10.0,
			6175.0
		);
		
		repository.save(transaction1);
		repository.save(transaction2);
		
		List<Transaction> transactions = repository.findAll();
		
		assertEquals(2, transactions.size());
	}

	@Test
	void repository_maintainsTransactionHistory_acrossMultipleSaves() {
		for (int index = 1; index <= 10; index++) {
			Transaction transaction = new Transaction(
				LocalDateTime.now(),
				"Fuel" + index,
				index * 5.0,
				index * 1000.0
			);
			repository.save(transaction);
		}
		
		List<Transaction> transactions = repository.findAll();
		
		assertEquals(10, transactions.size());
	}
}