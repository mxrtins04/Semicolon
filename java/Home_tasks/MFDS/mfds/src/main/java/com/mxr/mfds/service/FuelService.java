package com.mxr.mfds.service;

import com.mxr.mfds.model.Fuel;
import com.mxr.mfds.model.FuelType;
import com.mxr.mfds.repository.FuelRepository;

import java.util.List;

public class FuelService {

	private final FuelRepository fuelRepository;

	public FuelService(FuelRepository fuelRepository) {
		this.fuelRepository = fuelRepository;
	}

	public Fuel addFuel(FuelType fuelType, double pricePerLiter, double quantity) {

		if( fuelType == null)
			throw new IllegalArgumentException("Fuel cannot be empty");
		
		String name = fuelType.getDisplayName();
		validateNameNotEmpty(name);
		validatePricePositive(pricePerLiter);
		validateQuantityNonNegative(quantity);

			

		if (fuelRepository.existsByName(name)) {
			throw new IllegalStateException("Fuel with name '" + name + "' already exists");
		}
	

		Fuel fuel = new Fuel(fuelType, pricePerLiter, quantity);
		return fuelRepository.save(fuel);
	}

	public List<Fuel> getAllFuels() {
		return fuelRepository.findAll();
	}

	public Fuel getFuelByName(String name) {
		validateNameNotEmpty(name);

		return fuelRepository.findByName(name)
			.orElseThrow(() -> new IllegalArgumentException("Fuel with name '" + name + "' not found"));
	}

	public Fuel updateFuelPrice(String name, double newPrice) {
		validateNameNotEmpty(name);
		validatePricePositive(newPrice);

		Fuel fuel = getFuelByName(name);
		fuel.updatePrice(newPrice);
		return fuelRepository.update(fuel);
	}

	public Fuel restockFuel(String name, double quantity) {
		validateNameNotEmpty(name);
		validateQuantityPositive(quantity);

		Fuel fuel = getFuelByName(name);
		fuel.addQuantity(quantity);
		return fuelRepository.update(fuel);
	}

	private void validateNameNotEmpty(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Fuel name cannot be null or empty");
		}
	}

	private void validatePricePositive(double price) {
		if (price <= 0) {
			throw new IllegalArgumentException("Price must be positive");
		}
	}

	private void validateQuantityNonNegative(double quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("Quantity cannot be negative");
		}
	}

	private void validateQuantityPositive(double quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("Quantity must be positive");
		}
	}
}