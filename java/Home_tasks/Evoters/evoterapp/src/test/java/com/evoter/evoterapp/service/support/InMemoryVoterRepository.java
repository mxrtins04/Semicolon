package com.evoter.evoterapp.service.support;

import com.evoter.evoterapp.domain.Voter;
import com.evoter.evoterapp.repository.VoterRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryVoterRepository implements VoterRepository {

	private final Map<String, Voter> store = new HashMap<>();

	public void add(Voter v) { store.put(v.getId(), v); }

	@Override
	public Optional<Voter> findById(String id) { return Optional.ofNullable(store.get(id)); }

	@Override
	public boolean existsById(String id) { return store.containsKey(id); }

}
