package com.mxr.mfds.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FuelAttendant {
	
	private final String fullName;
	private final List<Transaction> transactions;

	public FuelAttendant(String fullName) {
		validateFullName(fullName);
		
		this.fullName = fullName;
		this.transactions = new ArrayList<>();
	}

	public String getFullName() {
		return fullName;
	}

	public void addTransaction(Transaction transaction) {
		if (transaction == null) {
			throw new IllegalArgumentException("Transaction cannot be null");
		}
		this.transactions.add(transaction);
	}

	public List<Transaction> getTransactions() {
		return Collections.unmodifiableList(transactions);
	}

	private void validateFullName(String fullName) {
		if (fullName == null || fullName.trim().isEmpty()) {
			throw new IllegalArgumentException("Full name cannot be null or empty");
		}
	}
}