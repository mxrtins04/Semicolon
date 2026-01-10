package com.mxr.mfds.app;

import com.mxr.mfds.controller.DispensingController;
import com.mxr.mfds.controller.FuelManagementController;
import com.mxr.mfds.mapper.FuelMapper;
import com.mxr.mfds.mapper.ReceiptMapper;
import com.mxr.mfds.mapper.TransactionMapper;
import com.mxr.mfds.repository.FuelRepository;
import com.mxr.mfds.repository.InMemoryFuelRepository;
import com.mxr.mfds.repository.InMemoryTransactionRepository;
import com.mxr.mfds.repository.TransactionRepository;
import com.mxr.mfds.service.DispensingService;
import com.mxr.mfds.service.FuelService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public FuelRepository fuelRepository() {
		return new InMemoryFuelRepository();
	}

	@Bean
	public TransactionRepository transactionRepository() {
		return new InMemoryTransactionRepository();
	}

	@Bean
	public FuelService fuelService(FuelRepository fuelRepository) {
		return new FuelService(fuelRepository);
	}

	@Bean
	public DispensingService dispensingService(
		FuelRepository fuelRepository,
		TransactionRepository transactionRepository
	) {
		return new DispensingService(fuelRepository, transactionRepository);
	}

	@Bean
	public FuelMapper fuelMapper() {
		return new FuelMapper();
	}

	@Bean
	public TransactionMapper transactionMapper() {
		return new TransactionMapper();
	}

	@Bean
	public ReceiptMapper receiptMapper() {
		return new ReceiptMapper();
	}

	@Bean
	public FuelManagementController fuelManagementController(
		FuelService fuelService,
		FuelMapper fuelMapper
	) {
		return new FuelManagementController(fuelService, fuelMapper);
	}

	@Bean
	public DispensingController dispensingController(
		DispensingService dispensingService,
		TransactionMapper transactionMapper,
		ReceiptMapper receiptMapper
	) {
		return new DispensingController(dispensingService, transactionMapper, receiptMapper);
	}
}