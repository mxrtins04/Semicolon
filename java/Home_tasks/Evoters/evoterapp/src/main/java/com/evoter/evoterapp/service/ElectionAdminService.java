package com.evoter.evoterapp.service;

import com.evoter.evoterapp.domain.Candidate;

import java.time.Instant;
import java.util.List;

public interface ElectionAdminService {

    void createElection(String id, String title, Instant start, Instant end, List<String> candidateIds);

    List<Candidate> listCandidates(String electionId);

}
