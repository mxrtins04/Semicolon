package com.mxr.mfds.mapper;

import com.mxr.mfds.dto.FuelDto;
import com.mxr.mfds.model.Fuel;

import java.util.List;
import java.util.stream.Collectors;

public class FuelMapper {

	public FuelDto toDto(Fuel fuel) {
		if (fuel == null) {
			throw new IllegalArgumentException("Fuel cannot be null");
		}

		return new FuelDto(
			fuel.getName(),
			fuel.getPricePerLiter(),
			fuel.getAvailableQuantity()
		);
	}

	public List<FuelDto> toDtoList(List<Fuel> fuels) {
		if (fuels == null) {
			throw new IllegalArgumentException("Fuel list cannot be null");
		}

		return fuels.stream()
			.map(fuel -> {
				if (fuel == null) {
					throw new IllegalArgumentException("Fuel list cannot contain null elements");
				}
				return toDto(fuel);
			})
			.collect(Collectors.toList());
	}
}