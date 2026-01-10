package com.evoter.evoterapp.persistence;

import com.evoter.evoterapp.domain.Candidate;
import com.evoter.evoterapp.repository.CandidateRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryCandidateRepository implements CandidateRepository {

    private final Map<String, Candidate> store = new HashMap<>();

    @Override
    public Optional<Candidate> findById(String id) { return Optional.ofNullable(store.get(id)); }

    @Override
    public List<Candidate> findAllByElectionId(String electionId) { return new ArrayList<>(store.values()); }

    @Override
    public boolean existsById(String id) { return store.containsKey(id); }

    public void save(Candidate c) { store.put(c.getId(), c); }

}
