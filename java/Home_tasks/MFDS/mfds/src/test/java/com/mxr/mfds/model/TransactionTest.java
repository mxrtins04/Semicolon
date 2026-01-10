package com.mxr.mfds.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

	@Test
	void constructor_createsValidTransaction_whenAllParametersValid() {
		LocalDateTime timestamp = LocalDateTime.now();
		
		Transaction transaction = new Transaction(timestamp, "Petrol", 10.0, 6175.0);
		
		assertEquals(timestamp, transaction.getTimestamp());
		assertEquals("Petrol", transaction.getFuelType());
		assertEquals(10.0, transaction.getQuantity());
		assertEquals(6175.0, transaction.getTotalCost());
	}

	@Test
	void constructor_throwsException_whenTimestampIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Transaction(null, "Petrol", 10.0, 6175.0);
		});
	}

	@Test
	void constructor_throwsException_whenFuelTypeIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Transaction(LocalDateTime.now(), null, 10.0, 6175.0);
		});
	}

	@Test
	void constructor_throwsException_whenFuelTypeIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Transaction(LocalDateTime.now(), "", 10.0, 6175.0);
		});
	}

	@Test
	void constructor_throwsException_whenFuelTypeIsBlank() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Transaction(LocalDateTime.now(), "   ", 10.0, 6175.0);
		});
	}

	@Test
	void constructor_throwsException_whenQuantityIsZero() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Transaction(LocalDateTime.now(), "Petrol", 0.0, 6175.0);
		});
	}

	@Test
	void constructor_throwsException_whenQuantityIsNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Transaction(LocalDateTime.now(), "Petrol", -10.0, 6175.0);
		});
	}

	@Test
	void constructor_throwsException_whenTotalCostIsZero() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Transaction(LocalDateTime.now(), "Petrol", 10.0, 0.0);
		});
	}

	@Test
	void constructor_throwsException_whenTotalCostIsNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Transaction(LocalDateTime.now(), "Petrol", 10.0, -6175.0);
		});
	}

	@Test
	void transaction_isImmutable_allFieldsReadOnly() {
		LocalDateTime timestamp = LocalDateTime.now();
		Transaction transaction = new Transaction(timestamp, "Petrol", 10.0, 6175.0);
		
		assertEquals(timestamp, transaction.getTimestamp());
		assertEquals("Petrol", transaction.getFuelType());
		assertEquals(10.0, transaction.getQuantity());
		assertEquals(6175.0, transaction.getTotalCost());
	}
}