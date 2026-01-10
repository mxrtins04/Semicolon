package com.evoter.evoterapp.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidateTest {

	@Test
	void constructorRejectsEmptyName() {
		assertThrows(IllegalArgumentException.class, () -> new Candidate("c1", "" , null));
	}

	@Test
	void constructsWithValidData() {
		Candidate c = new Candidate("c1", "Bob", "Independent");
		assertEquals("c1", c.getId());
		assertEquals("Bob", c.getName());
		assertEquals("Independent", c.getParty());
	}

}
