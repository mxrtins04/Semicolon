package com.evoter.evoterapp.domain.exception;

public class DuplicateVoteException extends RuntimeException {

	public DuplicateVoteException() {
		super();
	}

	public DuplicateVoteException(String message) {
		super(message);
	}

}
