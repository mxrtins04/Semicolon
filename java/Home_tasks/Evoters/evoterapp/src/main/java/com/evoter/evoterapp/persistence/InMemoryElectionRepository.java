package com.evoter.evoterapp.persistence;

import com.evoter.evoterapp.domain.Election;
import com.evoter.evoterapp.repository.ElectionRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryElectionRepository implements ElectionRepository {

    private final Map<String, Election> store = new HashMap<>();

    @Override
    public Optional<Election> findById(String id) { return Optional.ofNullable(store.get(id)); }

    @Override
    public void save(Election election) { store.put(election.getId(), election); }

}
