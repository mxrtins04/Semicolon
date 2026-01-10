package com.evoter.evoterapp.service;

import com.evoter.evoterapp.domain.Candidate;
import com.evoter.evoterapp.domain.Election;
import com.evoter.evoterapp.domain.Voter;
import com.evoter.evoterapp.domain.Vote;
import com.evoter.evoterapp.domain.exception.CandidateNotFoundException;
import com.evoter.evoterapp.domain.exception.DuplicateVoteException;
import com.evoter.evoterapp.domain.exception.ElectionClosedException;
import com.evoter.evoterapp.service.support.InMemoryCandidateRepository;
import com.evoter.evoterapp.service.support.InMemoryElectionRepository;
import com.evoter.evoterapp.service.support.InMemoryVoteRepository;
import com.evoter.evoterapp.service.support.InMemoryVoterRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class VotingServiceTest {

	private InMemoryVoterRepository voters;
	private InMemoryCandidateRepository candidates;
	private InMemoryElectionRepository elections;
	private InMemoryVoteRepository votes;
	private VotingService service;

	@BeforeEach
	void setUp() {
		voters = new InMemoryVoterRepository();
		candidates = new InMemoryCandidateRepository();
		elections = new InMemoryElectionRepository();
		votes = new InMemoryVoteRepository();
		service = new com.evoter.evoterapp.service.VotingServiceImpl(voters, candidates, elections, votes);
	}

	@Test
	void castVote_whenElectionClosed_throwsElectionClosedException() {
		Instant start = Instant.parse("2026-01-01T00:00:00Z");
		Instant end = Instant.parse("2026-01-02T00:00:00Z");
		Election e = new Election("e1", "Past", start, end, java.util.List.of("c1"));
		elections.add(e);
		voters.add(new Voter("v1", "Alice"));
		candidates.add(new Candidate("c1", "Bob", ""));
		assertThrows(ElectionClosedException.class, () -> service.castVote("v1", "e1", "c1"));
	}

	@Test
	void castVote_whenCandidateMissing_throwsCandidateNotFoundException() {
		Instant start = Instant.now().minusSeconds(3600);
		Instant end = Instant.now().plusSeconds(3600);
		Election e = new Election("e1", "Open", start, end, java.util.List.of("c1"));
		elections.add(e);
		voters.add(new Voter("v1", "Alice"));
		assertThrows(CandidateNotFoundException.class, () -> service.castVote("v1", "e1", "c1"));
	}

	@Test
	void castVote_whenVoterAlreadyVoted_throwsDuplicateVoteException() {
		Instant start = Instant.now().minusSeconds(3600);
		Instant end = Instant.now().plusSeconds(3600);
		Election e = new Election("e1", "Open", start, end, java.util.List.of("c1"));
		elections.add(e);
		voters.add(new Voter("v1", "Alice"));
		candidates.add(new Candidate("c1", "Bob", ""));
		votes.save(new Vote("v1", "e1", "c1", Instant.now().minusSeconds(100)));
		assertThrows(DuplicateVoteException.class, () -> service.castVote("v1", "e1", "c1"));
	}


}
