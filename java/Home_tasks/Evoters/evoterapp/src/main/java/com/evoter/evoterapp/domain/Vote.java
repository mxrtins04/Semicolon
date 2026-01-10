package com.evoter.evoterapp.domain;

import java.time.Instant;

public final class Vote {

	private final String voterId;
	private final String electionId;
	private final String candidateId;
	private final Instant timestamp;

	public Vote(String voterId, String electionId, String candidateId, Instant timestamp) {
		if (voterId == null || voterId.isBlank()) throw new IllegalArgumentException("voterId required");
		if (electionId == null || electionId.isBlank()) throw new IllegalArgumentException("electionId required");
		if (candidateId == null || candidateId.isBlank()) throw new IllegalArgumentException("candidateId required");
		if (timestamp == null) throw new IllegalArgumentException("timestamp required");
		this.voterId = voterId;
		this.electionId = electionId;
		this.candidateId = candidateId;
		this.timestamp = timestamp;
	}

	public String getVoterId() {
		return voterId;
	}

	public String getElectionId() {
		return electionId;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

}
