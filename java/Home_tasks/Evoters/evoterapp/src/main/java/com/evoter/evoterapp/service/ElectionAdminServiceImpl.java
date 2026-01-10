package com.evoter.evoterapp.service;

import com.evoter.evoterapp.domain.Election;
import com.evoter.evoterapp.domain.Candidate;
import com.evoter.evoterapp.repository.CandidateRepository;
import com.evoter.evoterapp.repository.ElectionRepository;

import java.time.Instant;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ElectionAdminServiceImpl implements ElectionAdminService {

    private final ElectionRepository electionRepository;
    private final CandidateRepository candidateRepository;

    public ElectionAdminServiceImpl(ElectionRepository electionRepository, CandidateRepository candidateRepository) {
        this.electionRepository = electionRepository;
        this.candidateRepository = candidateRepository;
    }

    @Override
    public void createElection(String id, String title, Instant start, Instant end, List<String> candidateIds) {
        Election e = new Election(id, title, start, end, candidateIds);
        electionRepository.save(e);
    }

    @Override
    public List<Candidate> listCandidates(String electionId) {
        return candidateRepository.findAllByElectionId(electionId);
    }
}
