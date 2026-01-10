package com.evoter.evoterapp.service.support;

import com.evoter.evoterapp.domain.Election;
import com.evoter.evoterapp.repository.ElectionRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryElectionRepository implements ElectionRepository {

	private final Map<String, Election> store = new HashMap<>();

	public void add(Election e) { store.put(e.getId(), e); }

	@Override
	public Optional<Election> findById(String id) { return Optional.ofNullable(store.get(id)); }

	@Override
	public void save(Election election) { store.put(election.getId(), election); }

}
