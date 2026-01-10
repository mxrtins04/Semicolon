package com.evoter.evoterapp.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Election {

	private final String id;
	private final String title;
	private final Instant start;
	private final Instant end;
	private final List<String> candidateIds;

	public Election(String id, String title, Instant start, Instant end, List<String> candidateIds) {
		if (id == null || id.isBlank()) throw new IllegalArgumentException("id required");
		if (title == null || title.isBlank()) throw new IllegalArgumentException("title required");
		if (start == null || end == null) throw new IllegalArgumentException("start and end required");
		if (!start.isBefore(end)) throw new IllegalArgumentException("start must be before end");
		if (candidateIds == null || candidateIds.isEmpty()) throw new IllegalArgumentException("candidates required");
		Set<String> set = new HashSet<>(candidateIds);
		if (set.size() != candidateIds.size()) throw new IllegalArgumentException("duplicate candidates not allowed");
		this.id = id;
		this.title = title;
		this.start = start;
		this.end = end;
		this.candidateIds = Collections.unmodifiableList(new ArrayList<>(candidateIds));
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Instant getStart() {
		return start;
	}

	public Instant getEnd() {
		return end;
	}

	public List<String> getCandidateIds() {
		return candidateIds;
	}

	public boolean isOpen(Instant at) {
		Instant when = at == null ? Instant.now() : at;
		return !when.isBefore(start) && when.isBefore(end);
	}

}
