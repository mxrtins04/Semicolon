package com.evoter.evoterapp.domain.exception;

public class CandidateNotFoundException extends RuntimeException {

	public CandidateNotFoundException() {
		super();
	}

	public CandidateNotFoundException(String message) {
		super(message);
	}

}
