package com.mxr.mfds.dto;

public class FuelDto {

	private final String name;
	private final double pricePerLiter;
	private final double availableQuantity;

	public FuelDto(String name, double pricePerLiter, double availableQuantity) {
		this.name = name;
		this.pricePerLiter = pricePerLiter;
		this.availableQuantity = availableQuantity;
	}

	public String getName() {
		return name;
	}

	public double getPricePerLiter() {
		return pricePerLiter;
	}

	public double getAvailableQuantity() {
		return availableQuantity;
	}
}