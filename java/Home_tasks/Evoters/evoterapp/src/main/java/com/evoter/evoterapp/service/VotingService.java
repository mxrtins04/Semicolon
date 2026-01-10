package com.evoter.evoterapp.service;

public interface VotingService {

	void castVote(String voterId, String electionId, String candidateId);

	boolean hasVoted(String voterId, String electionId);

}
