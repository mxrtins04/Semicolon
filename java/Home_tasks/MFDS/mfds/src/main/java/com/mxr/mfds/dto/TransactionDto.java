package com.mxr.mfds.dto;

public class TransactionDto {

	private final String timestamp;
	private final String fuelType;
	private final double quantity;
	private final double totalCost;

	public TransactionDto(String timestamp, String fuelType, double quantity, double totalCost) {
		this.timestamp = timestamp;
		this.fuelType = fuelType;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}

	public String getTimestamp() {
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
}