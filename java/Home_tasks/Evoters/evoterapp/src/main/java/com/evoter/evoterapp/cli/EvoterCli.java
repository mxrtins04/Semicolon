package com.evoter.evoterapp.cli;

import com.evoter.evoterapp.domain.exception.DuplicateVoteException;
import com.evoter.evoterapp.domain.exception.ElectionClosedException;
import com.evoter.evoterapp.domain.exception.CandidateNotFoundException;
import com.evoter.evoterapp.service.CountingService;
import com.evoter.evoterapp.service.ElectionAdminService;
import com.evoter.evoterapp.service.VotingService;
import com.evoter.evoterapp.domain.Candidate;
import com.evoter.evoterapp.service.dto.ElectionResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Map;

public class EvoterCli {

    private final VotingService votingService;
    private final CountingService countingService;
    private final ElectionAdminService adminService;
    private final InputStream in;
    private final PrintStream out;

    public EvoterCli(VotingService votingService, CountingService countingService, ElectionAdminService adminService, InputStream in, PrintStream out) {
        this.votingService = votingService;
        this.countingService = countingService;
        this.adminService = adminService;
        this.in = in;
        this.out = out;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                boolean shouldExit = runOnce(line.trim());
                if (shouldExit) break;
            }
        } catch (IOException e) {
            out.println("IO error: " + e.getMessage());
        }
    }

    public boolean runOnce(String line) {
        if (line.isBlank()) return false;
        String[] parts = line.split("\\s+");
        String cmd = parts[0].toLowerCase();
        try {
            switch (cmd) {
                case "vote":
                    if (parts.length < 4) {
                        out.println("Usage: vote <voterId> <electionId> <candidateId>");
                        return false;
                    }
                    votingService.castVote(parts[1], parts[2], parts[3]);
                    out.println("Vote accepted");
                    return false;
                case "results":
                    if (parts.length < 2) {
                        out.println("Usage: results <electionId>");
                        return false;
                    }
                    ElectionResult result = countingService.tally(parts[1]);
                    for (Map.Entry<String, Long> e : result.getCountsByCandidate().entrySet()) {
                        out.println(e.getKey() + ": " + e.getValue());
                    }
                    return false;
                case "create-election":
                    // Usage: create-election <id> <title> <start-iso> <end-iso> <candidateIdsCommaSeparated>
                    if (parts.length < 6) {
                        out.println("Usage: create-election <id> <title> <start-iso> <end-iso> <candidateIdsCommaSeparated>");
                        return false;
                    }
                    try {
                        java.time.Instant start = java.time.Instant.parse(parts[3]);
                        java.time.Instant end = java.time.Instant.parse(parts[4]);
                        java.util.List<String> candidateIds = java.util.Arrays.stream(parts[5].split(","))
                                .map(String::trim).filter(s -> !s.isEmpty()).toList();
                        adminService.createElection(parts[1], parts[2], start, end, candidateIds);
                        out.println("Election created");
                    } catch (java.time.format.DateTimeParseException dtpe) {
                        out.println("Invalid date format. Use ISO-8601, e.g. 2026-01-01T00:00:00Z");
                    }
                    return false;
                case "list-candidates":
                    if (parts.length < 2) {
                        out.println("Usage: list-candidates <electionId>");
                        return false;
                    }
                    java.util.List<Candidate> list = adminService.listCandidates(parts[1]);
                    for (Candidate c : list) {
                        out.println(c.getId() + " - " + c.getName());
                    }
                    return false;
                case "help":
                    out.println("Commands: vote, results, create-election, list-candidates, help, exit");
                    return false;
                case "exit":
                    out.println("Goodbye");
                    return true;
                default:
                    out.println("Unknown command. Type 'help' for commands.");
                    return false;
            }
        } catch (DuplicateVoteException dve) {
            out.println("You have already voted in this election");
        } catch (ElectionClosedException ece) {
            out.println("Election is closed");
        } catch (CandidateNotFoundException cnfe) {
            out.println("Candidate not found");
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
        return false;
    }

}
