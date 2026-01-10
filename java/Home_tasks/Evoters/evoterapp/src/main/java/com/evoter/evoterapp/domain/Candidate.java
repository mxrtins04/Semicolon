package com.evoter.evoterapp.domain;

public final class Candidate {

	private final String id;
	private final String name;
	private final String party;

	public Candidate(String id, String name, String party) {
		if (id == null || id.isBlank()) throw new IllegalArgumentException("id must be provided");
		if (name == null || name.isBlank()) throw new IllegalArgumentException("name must be provided");
		this.id = id;
		this.name = name;
		this.party = party;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getParty() {
		return party;
	}

}
