package com.evoter.evoterapp.domain.exception;

public class ElectionClosedException extends RuntimeException {

	public ElectionClosedException() {
		super();
	}

	public ElectionClosedException(String message) {
		super(message);
	}

}
