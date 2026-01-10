package com.mxr.mfds.controller;

import com.mxr.mfds.dto.ReceiptDto;
import com.mxr.mfds.dto.TransactionDto;
import com.mxr.mfds.mapper.ReceiptMapper;
import com.mxr.mfds.mapper.TransactionMapper;
import com.mxr.mfds.model.Transaction;
import com.mxr.mfds.service.DispensingService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class DispensingController {

	private final DispensingService dispensingService;
	private final TransactionMapper transactionMapper;
	private final ReceiptMapper receiptMapper;

	public DispensingController(
		DispensingService dispensingService,
		TransactionMapper transactionMapper,
		ReceiptMapper receiptMapper
	) {
		this.dispensingService = dispensingService;
		this.transactionMapper = transactionMapper;
		this.receiptMapper = receiptMapper;
	}

	@ShellMethod(value = "Dispense fuel by liters", key = "dispense-liters")
	public String dispenseByLiters(
		@ShellOption(help = "Fuel name") String fuel,
		@ShellOption(help = "Number of liters (1-50)") double liters
	) {
		try {
			Transaction transaction = dispensingService.dispenseByLiters(fuel, liters);
			ReceiptDto receipt = receiptMapper.toReceipt(transaction);
			return formatReceipt(receipt);
		} catch (IllegalArgumentException | IllegalStateException exception) {
			return "✗ Error: " + exception.getMessage();
		}
	}

	@ShellMethod(value = "Dispense fuel by amount", key = "dispense-amount")
	public String dispenseByAmount(
		@ShellOption(help = "Fuel name") String fuel,
		@ShellOption(help = "Amount in Naira") double amount
	) {
		try {
			Transaction transaction = dispensingService.dispenseByAmount(fuel, amount);
			ReceiptDto receipt = receiptMapper.toReceipt(transaction);
			return formatReceipt(receipt);
		} catch (IllegalArgumentException | IllegalStateException exception) {
			return "✗ Error: " + exception.getMessage();
		}
	}

	@ShellMethod(value = "Show all transactions", key = "show-transactions")
	public String showTransactions() {
		try {
			List<Transaction> transactions = dispensingService.getAllTransactions();
			
			if (transactions.isEmpty()) {
				return "No transactions recorded yet.";
			}

			List<TransactionDto> transactionDtos = transactionMapper.toDtoList(transactions);
			
			StringBuilder output = new StringBuilder();
			output.append("\n=== TRANSACTION HISTORY ===\n\n");
			output.append(String.format("%-20s %-15s %-15s %-15s%n",
				"Timestamp", "Fuel Type", "Quantity (L)", "Total Cost"));
			output.append("-".repeat(70)).append("\n");
			
			for (TransactionDto dto : transactionDtos) {
				output.append(String.format("%-20s %-15s %-15.2f ₦%-14.2f%n",
					dto.getTimestamp(),
					dto.getFuelType(),
					dto.getQuantity(),
					dto.getTotalCost()));
			}
			
			return output.toString();
		} catch (Exception exception) {
			return "✗ Error: " + exception.getMessage();
		}
	}

	private String formatReceipt(ReceiptDto receipt) {
		StringBuilder output = new StringBuilder();
		output.append("\n");
		output.append("═".repeat(50)).append("\n");
		output.append("              FUEL DISPENSING RECEIPT\n");
		output.append("═".repeat(50)).append("\n\n");
		output.append(String.format("  Date/Time    : %s%n", receipt.getTimestamp()));
		output.append(String.format("  Fuel Type    : %s%n", receipt.getFuelType()));
		output.append(String.format("  Quantity     : %.2f liters%n", receipt.getQuantity()));
		output.append(String.format("  Total Cost   : ₦%.2f%n", receipt.getTotalCost()));
		output.append("\n");
		output.append("═".repeat(50)).append("\n");
		output.append("           Thank you for your purchase!\n");
		output.append("═".repeat(50)).append("\n");
		
		return output.toString();
	}
}