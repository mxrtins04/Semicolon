package com.mxr.mfds.controller;

import com.mxr.mfds.dto.ReceiptDto;
import com.mxr.mfds.dto.TransactionDto;
import com.mxr.mfds.mapper.ReceiptMapper;
import com.mxr.mfds.mapper.TransactionMapper;
import com.mxr.mfds.model.Transaction;
import com.mxr.mfds.service.DispensingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DispensingControllerTest {

	@Mock
	private DispensingService dispensingService;

	@Mock
	private TransactionMapper transactionMapper;

	@Mock
	private ReceiptMapper receiptMapper;

	private DispensingController controller;

	@BeforeEach
	void setUp() {
		controller = new DispensingController(dispensingService, transactionMapper, receiptMapper);
	}

	@Test
	void dispenseByLiters_returnsReceipt_whenDispensingSuccessful() {
		Transaction transaction = new Transaction(
			LocalDateTime.now(),
			"Petrol",
			10.0,
			6175.0
		);
		ReceiptDto receipt = new ReceiptDto(
			"2024-01-07 10:30:00",
			"Petrol",
			10.0,
			6175.0
		);

		when(dispensingService.dispenseByLiters("Petrol", 10.0)).thenReturn(transaction);
		when(receiptMapper.toReceipt(transaction)).thenReturn(receipt);

		String result = controller.dispenseByLiters("Petrol", 10.0);

		assertNotNull(result);
		assertTrue(result.contains("Receipt") || result.contains("RECEIPT"));
		assertTrue(result.contains("Petrol"));
		assertTrue(result.contains("10.0"));
		verify(dispensingService).dispenseByLiters("Petrol", 10.0);
		verify(receiptMapper).toReceipt(transaction);
	}

	@Test
	void dispenseByLiters_returnsErrorMessage_whenFuelNotFound() {
		when(dispensingService.dispenseByLiters("Kerosene", 10.0))
			.thenThrow(new IllegalArgumentException("Fuel not found"));

		String result = controller.dispenseByLiters("Kerosene", 10.0);

		assertNotNull(result);
		assertTrue(result.contains("Error") || result.contains("not found"));
		verify(dispensingService).dispenseByLiters("Kerosene", 10.0);
		verify(receiptMapper, never()).toReceipt(any());
	}

	@Test
	void dispenseByLiters_returnsErrorMessage_whenLitersOutOfRange() {
		when(dispensingService.dispenseByLiters("Petrol", 60.0))
			.thenThrow(new IllegalArgumentException("Liters must be between 1 and 50"));

		String result = controller.dispenseByLiters("Petrol", 60.0);

		assertNotNull(result);
		assertTrue(result.contains("Error") || result.contains("between"));
		verify(dispensingService).dispenseByLiters("Petrol", 60.0);
		verify(receiptMapper, never()).toReceipt(any());
	}

	@Test
	void dispenseByLiters_returnsErrorMessage_whenInsufficientFuel() {
		when(dispensingService.dispenseByLiters("Petrol", 10.0))
			.thenThrow(new IllegalStateException("Insufficient fuel available"));

		String result = controller.dispenseByLiters("Petrol", 10.0);

		assertNotNull(result);
		assertTrue(result.contains("Error") || result.contains("Insufficient"));
		verify(dispensingService).dispenseByLiters("Petrol", 10.0);
		verify(receiptMapper, never()).toReceipt(any());
	}

	@Test
	void dispenseByAmount_returnsReceipt_whenDispensingSuccessful() {
		Transaction transaction = new Transaction(
			LocalDateTime.now(),
			"Petrol",
			10.0,
			6175.0
		);
		ReceiptDto receipt = new ReceiptDto(
			"2024-01-07 10:30:00",
			"Petrol",
			10.0,
			6175.0
		);

		when(dispensingService.dispenseByAmount("Petrol", 6175.0)).thenReturn(transaction);
		when(receiptMapper.toReceipt(transaction)).thenReturn(receipt);

		String result = controller.dispenseByAmount("Petrol", 6175.0);

		assertNotNull(result);
		assertTrue(result.contains("Receipt") || result.contains("RECEIPT"));
		assertTrue(result.contains("Petrol"));
		assertTrue(result.contains("6175.0"));
		verify(dispensingService).dispenseByAmount("Petrol", 6175.0);
		verify(receiptMapper).toReceipt(transaction);
	}

	@Test
	void dispenseByAmount_returnsErrorMessage_whenFuelNotFound() {
		when(dispensingService.dispenseByAmount("Kerosene", 5000.0))
			.thenThrow(new IllegalArgumentException("Fuel not found"));

		String result = controller.dispenseByAmount("Kerosene", 5000.0);

		assertNotNull(result);
		assertTrue(result.contains("Error") || result.contains("not found"));
		verify(dispensingService).dispenseByAmount("Kerosene", 5000.0);
		verify(receiptMapper, never()).toReceipt(any());
	}

	@Test
	void dispenseByAmount_returnsErrorMessage_whenAmountTooLow() {
		when(dispensingService.dispenseByAmount("Petrol", 500.0))
			.thenThrow(new IllegalArgumentException("Amount must be at least the price of one liter"));

		String result = controller.dispenseByAmount("Petrol", 500.0);

		assertNotNull(result);
		assertTrue(result.contains("Error") || result.contains("at least"));
		verify(dispensingService).dispenseByAmount("Petrol", 500.0);
		verify(receiptMapper, never()).toReceipt(any());
	}

	@Test
	void dispenseByAmount_returnsErrorMessage_whenInsufficientFuel() {
		when(dispensingService.dispenseByAmount("Petrol", 6175.0))
			.thenThrow(new IllegalStateException("Insufficient fuel available"));

		String result = controller.dispenseByAmount("Petrol", 6175.0);

		assertNotNull(result);
		assertTrue(result.contains("Error") || result.contains("Insufficient"));
		verify(dispensingService).dispenseByAmount("Petrol", 6175.0);
		verify(receiptMapper, never()).toReceipt(any());
	}

	@Test
	void showTransactions_returnsFormattedList_whenTransactionsExist() {
		List<Transaction> transactions = Arrays.asList(
			new Transaction(
				LocalDateTime.now(),
				"Petrol",
				10.0,
				6175.0
			),
			new Transaction(
				LocalDateTime.now(),
				"Diesel",
				15.0,
				8700.0
			)
		);
		List<TransactionDto> dtos = Arrays.asList(
			new TransactionDto("2024-01-07 10:30:00", "Petrol", 10.0, 6175.0),
			new TransactionDto("2024-01-07 11:45:00", "Diesel", 15.0, 8700.0)
		);

		when(dispensingService.getAllTransactions()).thenReturn(transactions);
		when(transactionMapper.toDtoList(transactions)).thenReturn(dtos);

		String result = controller.showTransactions();

		assertNotNull(result);
		assertTrue(result.contains("Petrol"));
		assertTrue(result.contains("Diesel"));
		verify(dispensingService).getAllTransactions();
		verify(transactionMapper).toDtoList(transactions);
	}

	@Test
	void showTransactions_returnsNoTransactionsMessage_whenNoTransactionsExist() {

		String result = controller.showTransactions();

		assertNotNull(result);
		assertTrue(result.contains("No transactions") || result.contains("empty"));
		verify(dispensingService).getAllTransactions();
	}
}