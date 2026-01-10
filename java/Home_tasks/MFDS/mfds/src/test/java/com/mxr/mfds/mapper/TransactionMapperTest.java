package com.mxr.mfds.mapper;

import com.mxr.mfds.dto.TransactionDto;
import com.mxr.mfds.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionMapperTest {

	private TransactionMapper mapper;

	@BeforeEach
	void setUp() {
		mapper = new TransactionMapper();
	}

	@Test
	void toDto_convertsModelToDto_whenValidTransactionProvided() {
		Transaction transaction = new Transaction(
			LocalDateTime.of(2024, 1, 7, 10, 30, 0),
			"Petrol",
			10.0,
			6175.0
		);

		TransactionDto dto = mapper.toDto(transaction);

		assertNotNull(dto);
		assertEquals("2024-01-07 10:30:00", dto.getTimestamp());
		assertEquals("Petrol", dto.getFuelType());
		assertEquals(10.0, dto.getQuantity());
		assertEquals(6175.0, dto.getTotalCost());
	}

	@Test
	void toDto_formatsTimestampCorrectly_whenConverting() {
		Transaction transaction = new Transaction(
			LocalDateTime.of(2024, 12, 25, 9, 5, 30),
			"Diesel",
			15.0,
			8700.0
		);

		TransactionDto dto = mapper.toDto(transaction);

		assertEquals("2024-12-25 09:05:30", dto.getTimestamp());
	}

	@Test
	void toDto_throwsException_whenTransactionIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			mapper.toDto(null);
		});
	}

	@Test
	void toDtoList_convertsMultipleTransactions_whenValidListProvided() {
		List<Transaction> transactions = Arrays.asList(
			new Transaction(
				LocalDateTime.of(2024, 1, 7, 10, 30, 0),
				"Petrol",
				10.0,
				6175.0
			),
			new Transaction(
				LocalDateTime.of(2024, 1, 7, 11, 45, 0),
				"Diesel",
				15.0,
				8700.0
			)
		);

		List<TransactionDto> dtos = mapper.toDtoList(transactions);

		assertNotNull(dtos);
		assertEquals(2, dtos.size());
		assertEquals("Petrol", dtos.get(0).getFuelType());
		assertEquals("Diesel", dtos.get(1).getFuelType());
	}

	@Test
	void toDtoList_returnsEmptyList_whenEmptyListProvided() {
		List<Transaction> transactions = Arrays.asList();

		List<TransactionDto> dtos = mapper.toDtoList(transactions);

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
	void toDtoList_throwsException_whenListContainsNullTransaction() {
		List<Transaction> transactions = Arrays.asList(
			new Transaction(
				LocalDateTime.of(2024, 1, 7, 10, 30, 0),
				"Petrol",
				10.0,
				6175.0
			),
			null
		);

		assertThrows(IllegalArgumentException.class, () -> {
			mapper.toDtoList(transactions);
		});
	}
}