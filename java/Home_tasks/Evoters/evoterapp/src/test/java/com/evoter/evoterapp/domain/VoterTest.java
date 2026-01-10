package com.evoter.evoterapp.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoterTest {

	@Test
	void constructorRejectsEmptyName() {
		assertThrows(IllegalArgumentException.class, () -> new Voter("v1", ""));
	}

	@Test
	void constructsWithValidData() {
		Voter voter = new Voter("v1", "Alice");
		assertEquals("v1", voter.getId());
		assertEquals("Alice", voter.getName());
	}

}
