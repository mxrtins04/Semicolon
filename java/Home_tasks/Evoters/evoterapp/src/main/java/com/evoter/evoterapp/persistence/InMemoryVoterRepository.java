package com.evoter.evoterapp.persistence;

import com.evoter.evoterapp.domain.Voter;
import com.evoter.evoterapp.repository.VoterRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryVoterRepository implements VoterRepository {

    private final Map<String, Voter> store = new HashMap<>();

    @Override
    public Optional<Voter> findById(String id) { return Optional.ofNullable(store.get(id)); }

    @Override
    public boolean existsById(String id) { return store.containsKey(id); }

    public void save(Voter v) { store.put(v.getId(), v); }

}
