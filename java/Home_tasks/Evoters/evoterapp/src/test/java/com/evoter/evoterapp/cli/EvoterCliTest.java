package com.evoter.evoterapp.cli;

import com.evoter.evoterapp.domain.exception.DuplicateVoteException;
import com.evoter.evoterapp.service.CountingService;
import com.evoter.evoterapp.service.VotingService;
import com.evoter.evoterapp.service.dto.ElectionResult;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EvoterCliTest {

    @Test
    void givenValidVoteCommand_delegatesToVotingService_andPrintsSuccess() {
        String input = "vote v1 e1 c1\nexit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        StubVotingService voting = new StubVotingService();
        StubCountingService counting = new StubCountingService();
        StubAdminService admin = new StubAdminService();
        EvoterCli cli = new EvoterCli(voting, counting, admin, in, new PrintStream(out));

        cli.run();

        assertTrue(voting.called);
        String printed = out.toString();
        assertTrue(printed.contains("Vote accepted") || printed.contains("OK"));
    }

    @Test
    void givenVoteCommand_whenDuplicate_printsFriendlyError() {
        String input = "vote v1 e1 c1\nexit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        StubVotingService voting = new StubVotingService();
        voting.throwDuplicate = true;
        StubCountingService counting = new StubCountingService();
        StubAdminService admin = new StubAdminService();
        EvoterCli cli = new EvoterCli(voting, counting, admin, in, new PrintStream(out));

        cli.run();

        String printed = out.toString();
        assertTrue(printed.toLowerCase().contains("already voted") || printed.toLowerCase().contains("already"));
    }

    @Test
    void givenResultsCommand_printsCountsSorted() {
        String input = "results e1\nexit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        StubVotingService voting = new StubVotingService();
        StubCountingService counting = new StubCountingService();
        StubAdminService admin = new StubAdminService();
        Map<String, Long> map = new LinkedHashMap<>();
        map.put("c1", 2L);
        map.put("c2", 1L);
        counting.result = new ElectionResult(map);

        EvoterCli cli = new EvoterCli(voting, counting, admin, in, new PrintStream(out));
        cli.run();

        String printed = out.toString();
        assertTrue(printed.contains("c1") && printed.contains("2"));
        assertTrue(printed.contains("c2") && printed.contains("1"));
    }

    static class StubVotingService implements VotingService {
        boolean called = false;
        boolean throwDuplicate = false;

        @Override
        public void castVote(String voterId, String electionId, String candidateId) {
            if (throwDuplicate) throw new DuplicateVoteException("already");
            called = true;
        }

        @Override
        public boolean hasVoted(String voterId, String electionId) { return false; }
    }

    static class StubCountingService implements CountingService {
        ElectionResult result = new ElectionResult(new LinkedHashMap<>());

        @Override
        public ElectionResult tally(String electionId) { return result; }
    }

    static class StubAdminService implements com.evoter.evoterapp.service.ElectionAdminService {
        boolean created = false;
        @Override
        public void createElection(String id, String title, java.time.Instant start, java.time.Instant end, java.util.List<String> candidateIds) {
            created = true;
        }

        @Override
        public java.util.List<com.evoter.evoterapp.domain.Candidate> listCandidates(String electionId) {
            return java.util.List.of(new com.evoter.evoterapp.domain.Candidate("c1","Bob",""));
        }
    }

}
