package com.mxr.mfds.model;

public class Fuel {
	
	private final FuelType fuelType;
	private double pricePerLiter;
	private double availableQuantity;

	public Fuel(FuelType fuelType, double pricePerLiter, double availableQuantity) {
		validateFuelType(fuelType);
		validatePrice(pricePerLiter);
		validateQuantityNonNegative(availableQuantity);
		
		this.fuelType = fuelType;
		this.pricePerLiter = pricePerLiter;
		this.availableQuantity = availableQuantity;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public String getName() {
		return fuelType.getDisplayName();
	}

	public double getPricePerLiter() {
		return pricePerLiter;
	}

	public double getAvailableQuantity() {
		return availableQuantity;
	}

	public void deductQuantity(double amount) {
		validatePositiveAmount(amount);
		
		if (!hasAvailableQuantity(amount)) {
			throw new IllegalStateException("Insufficient fuel available");
		}
		
		this.availableQuantity -= amount;
	}

	public void addQuantity(double amount) {
		validatePositiveAmount(amount);
		this.availableQuantity += amount;
	}

	public void updatePrice(double newPrice) {
		validatePrice(newPrice);
		this.pricePerLiter = newPrice;
	}

	public boolean hasAvailableQuantity(double amount) {
		return this.availableQuantity >= amount;
	}

	private void validateFuelType(FuelType fuelType) {
		if (fuelType == null) {
			throw new IllegalArgumentException("Fuel type cannot be null");
		}
	}

	private void validatePrice(double price) {
		if (price <= 0) {
			throw new IllegalArgumentException("Price must be positive");
		}
	}

	private void validateQuantityNonNegative(double quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("Quantity cannot be negative");
		}
	}

	private void validatePositiveAmount(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Amount must be positive");
		}
	}
} 
