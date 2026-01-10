package com.evoter.evoterapp.service;

import com.evoter.evoterapp.domain.Vote;
import com.evoter.evoterapp.service.dto.ElectionResult;
import com.evoter.evoterapp.service.support.InMemoryVoteRepository;
import java.util.Map;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CountingServiceTest {

	@Test
	void tallyCountsVotesCorrectly() {
		InMemoryVoteRepository votes = new InMemoryVoteRepository();
		votes.save(new Vote("v1", "e1", "c1", Instant.now()));
		votes.save(new Vote("v2", "e1", "c1", Instant.now()));
		votes.save(new Vote("v3", "e1", "c2", Instant.now()));
		CountingService counting = new com.evoter.evoterapp.service.CountingServiceImpl(votes);
		ElectionResult result = counting.tally("e1");
		Map<String, Long> counts = result.getCountsByCandidate();
		assertEquals(2L, counts.get("c1"));
		assertEquals(1L, counts.get("c2"));
	}

}
