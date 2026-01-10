package com.evoter.evoterapp.domain;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElectionTest {

	@Test
	void rejectsEndBeforeStart() {
		Instant start = Instant.parse("2026-01-10T10:00:00Z");
		Instant end = Instant.parse("2026-01-09T10:00:00Z");
		assertThrows(IllegalArgumentException.class, () -> new Election("e1", "Test", start, end, List.of("c1")));
	}

	@Test
	void rejectsDuplicateCandidates() {
		Instant start = Instant.now();
		Instant end = start.plusSeconds(3600);
		assertThrows(IllegalArgumentException.class, () -> new Election("e1", "Test", start, end, List.of("c1", "c1")));
	}

	@Test
	void isOpenReflectsWindow() {
		Instant start = Instant.now().minusSeconds(3600);
		Instant end = Instant.now().plusSeconds(3600);
		Election e = new Election("e1", "OpenElection", start, end, List.of("c1", "c2"));
		assertTrue(e.isOpen(Instant.now()));
	}

}
