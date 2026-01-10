package com.evoter.evoterapp.domain;

public final class Voter {

	private final String id;
	private final String name;

	public Voter(String id, String name) {
		if (id == null || id.isBlank()) throw new IllegalArgumentException("id must be provided");
		if (name == null || name.isBlank()) throw new IllegalArgumentException("name must be provided");
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
