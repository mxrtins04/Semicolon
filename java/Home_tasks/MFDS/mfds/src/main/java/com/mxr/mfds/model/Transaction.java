package com.mxr.mfds.model;

import java.time.LocalDateTime;

public class Transaction {
	
	private final LocalDateTime timestamp;
	private final String fuelType;
	private final double quantity;
	private final double totalCost;

	public Transaction(LocalDateTime timestamp, String fuelType, double quantity, double totalCost) {
		validateTimestamp(timestamp);
		validateFuelType(fuelType);
		validateQuantity(quantity);
		validateTotalCost(totalCost);
		
		this.timestamp = timestamp;
		this.fuelType = fuelType;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getFuelType() {
		return fuelType;
	}

	public double getQuantity() {
		return quantity;
	}

	public double getTotalCost() {
		return totalCost;
	}

	private void validateTimestamp(LocalDateTime timestamp) {
		if (timestamp == null) {
			throw new IllegalArgumentException("Timestamp cannot be null");
		}
	}

	private void validateFuelType(String fuelType) {
		if (fuelType == null || fuelType.trim().isEmpty()) {
			throw new IllegalArgumentException("Fuel type cannot be null or empty");
		}
	}

	private void validateQuantity(double quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("Quantity must be positive");
		}
	}

	private void validateTotalCost(double totalCost) {
		if (totalCost <= 0) {
			throw new IllegalArgumentException("Total cost must be positive");
		}
	}
}