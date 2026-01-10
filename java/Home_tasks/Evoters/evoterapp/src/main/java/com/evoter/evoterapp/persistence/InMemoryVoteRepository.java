package com.evoter.evoterapp.persistence;

import com.evoter.evoterapp.domain.Vote;
import com.evoter.evoterapp.repository.VoteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Repository
public class InMemoryVoteRepository implements VoteRepository {

    private final List<Vote> store = new CopyOnWriteArrayList<>();

    @Override
    public Vote save(Vote vote) {
        store.add(vote);
        return vote;
    }

    @Override
    public List<Vote> findByElectionId(String electionId) {
        return store.stream().filter(v -> v.getElectionId().equals(electionId)).collect(Collectors.toList());
    }

    @Override
    public boolean existsByVoterIdAndElectionId(String voterId, String electionId) {
        return store.stream().anyMatch(v -> v.getVoterId().equals(voterId));
    }
}
