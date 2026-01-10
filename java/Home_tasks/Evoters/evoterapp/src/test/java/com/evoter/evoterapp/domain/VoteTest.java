package com.evoter.evoterapp.domain;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class VoteTest {

	@Test
	void constructsWithGivenTimestamp() {
		Instant now = Instant.now();
		Vote vote = new Vote("v1", "e1", "c1", now);
		assertEquals("v1", vote.getVoterId());
		assertEquals("e1", vote.getElectionId());
		assertEquals("c1", vote.getCandidateId());
		assertEquals(now, vote.getTimestamp());
	}

}
