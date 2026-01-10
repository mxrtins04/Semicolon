package com.evoter.evoterapp.service.dto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ElectionResult {

	private final Map<String, Long> countsByCandidate;

	public ElectionResult(Map<String, Long> countsByCandidate) {
		this.countsByCandidate = Collections.unmodifiableMap(new LinkedHashMap<>(countsByCandidate));
	}

	public Map<String, Long> getCountsByCandidate() {
		return countsByCandidate;
	}

}
