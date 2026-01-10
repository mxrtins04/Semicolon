package com.evoter.evoterapp.service.support;

import com.evoter.evoterapp.domain.Candidate;
import com.evoter.evoterapp.repository.CandidateRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryCandidateRepository implements CandidateRepository {

	private final Map<String, Candidate> store = new HashMap<>();

	public void add(Candidate c) { store.put(c.getId(), c); }

	@Override
	public Optional<Candidate> findById(String id) { return Optional.ofNullable(store.get(id)); }

	@Override
	public List<Candidate> findAllByElectionId(String electionId) {
		return store.values().stream().collect(Collectors.toList());
	}

	@Override
	public boolean existsById(String id) { return store.containsKey(id); }

}
