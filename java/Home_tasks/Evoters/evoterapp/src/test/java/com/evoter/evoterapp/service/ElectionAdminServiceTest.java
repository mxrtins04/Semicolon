package com.evoter.evoterapp.service;

import com.evoter.evoterapp.domain.Election;
import com.evoter.evoterapp.service.support.InMemoryCandidateRepository;
import com.evoter.evoterapp.service.support.InMemoryElectionRepository;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElectionAdminServiceTest {

    @Test
    void createElection_savesElection() {
        InMemoryElectionRepository electionRepo = new InMemoryElectionRepository();
        InMemoryCandidateRepository candidateRepo = new InMemoryCandidateRepository();
        ElectionAdminService admin = new com.evoter.evoterapp.service.ElectionAdminServiceImpl(electionRepo, candidateRepo);

        Instant start = Instant.now().plusSeconds(60);
        Instant end = start.plusSeconds(3600);
        admin.createElection("e1", "Test Election", start, end, List.of("c1","c2"));

        var opt = electionRepo.findById("e1");
        assertTrue(opt.isPresent());
        Election e = opt.get();
        assertEquals("e1", e.getId());
        assertEquals(2, e.getCandidateIds().size());
    }

    @Test
    void listCandidates_returnsCandidatesFromRepository() {
        InMemoryElectionRepository electionRepo = new InMemoryElectionRepository();
        InMemoryCandidateRepository candidateRepo = new InMemoryCandidateRepository();
        // add candidates
        candidateRepo.add(new com.evoter.evoterapp.domain.Candidate("c1", "Alice", ""));
        candidateRepo.add(new com.evoter.evoterapp.domain.Candidate("c2", "Bob", ""));

        ElectionAdminService admin = new com.evoter.evoterapp.service.ElectionAdminServiceImpl(electionRepo, candidateRepo);
        var list = admin.listCandidates("e1");
        assertNotNull(list);
        assertTrue(list.size() >= 2);
    }

}
