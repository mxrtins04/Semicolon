package com.mxr.mfds.service;

import com.mxr.mfds.model.Fuel;
import com.mxr.mfds.model.Transaction;
import com.mxr.mfds.repository.FuelRepository;
import com.mxr.mfds.repository.TransactionRepository;

import java.time.LocalDateTime;
import java.util.List;

public class DispensingService {

	private static final double MINIMUM_LITERS = 1.0;
	private static final double MAXIMUM_LITERS = 50.0;

	private final FuelRepository fuelRepository;
	private final TransactionRepository transactionRepository;

	public DispensingService(FuelRepository fuelRepository, TransactionRepository transactionRepository) {
		this.fuelRepository = fuelRepository;
		this.transactionRepository = transactionRepository;
	}

	public Transaction dispenseByLiters(String fuelName, double liters) {
		validateFuelNameNotEmpty(fuelName);
		validateLitersWithinRange(liters);

		Fuel fuel = getFuel(fuelName);
		validateSufficientFuel(fuel, liters);

		double totalCost = calculateCost(fuel.getPricePerLiter(), liters);

		fuel.deductQuantity(liters);
		fuelRepository.update(fuel);

		Transaction transaction = new Transaction(
			LocalDateTime.now(),
			fuel.getName(),
			liters,
			totalCost
		);

		return transactionRepository.save(transaction);
	}

	public Transaction dispenseByAmount(String fuelName, double amount) {
		validateFuelNameNotEmpty(fuelName);

		Fuel fuel = getFuel(fuelName);
		validateAmountAbovePricePerLiter(amount, fuel.getPricePerLiter());

		double liters = calculateLiters(amount, fuel.getPricePerLiter());
		validateLitersWithinRange(liters);
		validateSufficientFuel(fuel, liters);

		fuel.deductQuantity(liters);
		fuelRepository.update(fuel);

		Transaction transaction = new Transaction(
			LocalDateTime.now(),
			fuel.getName(),
			liters,
			amount
		);

		return transactionRepository.save(transaction);
	}

	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	private Fuel getFuel(String fuelName) {
		return fuelRepository.findByName(fuelName)
			.orElseThrow(() -> new IllegalArgumentException("Fuel with name '" + fuelName + "' not found"));
	}

	private void validateFuelNameNotEmpty(String fuelName) {
		if (fuelName == null || fuelName.trim().isEmpty()) {
			throw new IllegalArgumentException("Fuel name cannot be null or empty");
		}
	}

	private void validateLitersWithinRange(double liters) {
		if (liters < MINIMUM_LITERS || liters > MAXIMUM_LITERS) {
			throw new IllegalArgumentException(
				"Liters must be between " + MINIMUM_LITERS + " and " + MAXIMUM_LITERS
			);
		}
	}

	private void validateAmountAbovePricePerLiter(double amount, double pricePerLiter) {
		if (amount < pricePerLiter) {
			throw new IllegalArgumentException("Amount must be at least the price of one liter");
		}
	}

	private void validateSufficientFuel(Fuel fuel, double liters) {
		if (!fuel.hasAvailableQuantity(liters)) {
			throw new IllegalStateException("Insufficient fuel available");
		}
	}

	private double calculateCost(double pricePerLiter, double liters) {
		return pricePerLiter * liters;
	}

	private double calculateLiters(double amount, double pricePerLiter) {
		return amount / pricePerLiter;
	}
}