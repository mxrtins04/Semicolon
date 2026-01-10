package com.mxr.mfds.controller;

import com.mxr.mfds.dto.FuelDto;
import com.mxr.mfds.mapper.FuelMapper;
import com.mxr.mfds.model.Fuel;
import com.mxr.mfds.model.FuelType;
import com.mxr.mfds.service.FuelService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class FuelManagementController {

	private final FuelService fuelService;
	private final FuelMapper fuelMapper;

	public FuelManagementController(FuelService fuelService, FuelMapper fuelMapper) {
		this.fuelService = fuelService;
		this.fuelMapper = fuelMapper;
	}

	@ShellMethod(value = "Add a new fuel type", key = "add-fuel")
	public String addFuel(
		@ShellOption(help = "Fuel name") FuelType fuelType,
		@ShellOption(help = "Price per liter") double price,
		@ShellOption(help = "Initial quantity") double quantity
	) {
		try {
			Fuel fuel = fuelService.addFuel(fuelType, price, quantity);
			return String.format("✓ Fuel '%s' added successfully with price ₦%.2f per liter and quantity %.2f liters",
				fuel.getName(), fuel.getPricePerLiter(), fuel.getAvailableQuantity());
		} catch (IllegalStateException | IllegalArgumentException exception) {
			return "✗ Error: " + exception.getMessage();
		}
	}

	@ShellMethod(value = "List all available fuels", key = "list-fuels")
	public String listFuels() {
		try {
			List<Fuel> fuels = fuelService.getAllFuels();
			
			if (fuels.isEmpty()) {
				return "No fuels available in the system.";
			}

			List<FuelDto> fuelDtos = fuelMapper.toDtoList(fuels);
			
			StringBuilder output = new StringBuilder();
			output.append("\n=== AVAILABLE FUELS ===\n\n");
			output.append(String.format("%-15s %-20s %-20s%n", "Fuel Name", "Price per Liter", "Available Quantity"));
			output.append("-".repeat(60)).append("\n");
			
			for (FuelDto dto : fuelDtos) {
				output.append(String.format("%-15s ₦%-19.2f %-20.2f%n",
					dto.getName(),
					dto.getPricePerLiter(),
					dto.getAvailableQuantity()));
			}
			
			return output.toString();
		} catch (Exception exception) {
			return "✗ Error: " + exception.getMessage();
		}
	}

	@ShellMethod(value = "Update fuel price", key = "update-price")
	public String updatePrice(
		@ShellOption(help = "Fuel name") String name,
		@ShellOption(help = "New price per liter") double price
	) {
		try {
			Fuel fuel = fuelService.updateFuelPrice(name, price);
			return String.format("✓ Price for '%s' updated successfully to ₦%.2f per liter",
				fuel.getName(), fuel.getPricePerLiter());
		} catch (IllegalArgumentException exception) {
			return "✗ Error: " + exception.getMessage();
		}
	}

	@ShellMethod(value = "Restock fuel", key = "restock")
	public String restock(
		@ShellOption(help = "Fuel name") String name,
		@ShellOption(help = "Quantity to add") double quantity
	) {
		try {
			Fuel fuel = fuelService.restockFuel(name, quantity);
			return String.format("✓ Fuel '%s' restocked successfully. New quantity: %.2f liters",
				fuel.getName(), fuel.getAvailableQuantity());
		} catch (IllegalArgumentException exception) {
			return "✗ Error: " + exception.getMessage();
		}
	}
}