package com.evoter.evoterapp.service;

import com.evoter.evoterapp.domain.Vote;
import com.evoter.evoterapp.domain.exception.CandidateNotFoundException;
import com.evoter.evoterapp.domain.exception.DuplicateVoteException;
import com.evoter.evoterapp.domain.exception.ElectionClosedException;
import com.evoter.evoterapp.repository.CandidateRepository;
import com.evoter.evoterapp.repository.ElectionRepository;
import com.evoter.evoterapp.repository.VoteRepository;
import com.evoter.evoterapp.repository.VoterRepository;

import java.time.Instant;
import org.springframework.stereotype.Service;

@Service
public class VotingServiceImpl implements VotingService {

    private final VoterRepository voterRepository;
    private final CandidateRepository candidateRepository;
    private final ElectionRepository electionRepository;
    private final VoteRepository voteRepository;

    public VotingServiceImpl(VoterRepository voterRepository,
                             CandidateRepository candidateRepository,
                             ElectionRepository electionRepository,
                             VoteRepository voteRepository) {
        this.voterRepository = voterRepository;
        this.candidateRepository = candidateRepository;
        this.electionRepository = electionRepository;
        this.voteRepository = voteRepository;
    }

    @Override
    public void castVote(String voterId, String electionId, String candidateId) {
        var electionOpt = electionRepository.findById(electionId);
        if (electionOpt.isEmpty()) throw new IllegalArgumentException("election not found");
        var election = electionOpt.get();
        if (!election.isOpen(Instant.now())) throw new ElectionClosedException("election is closed");
        if (!candidateRepository.existsById(candidateId)) throw new CandidateNotFoundException("candidate not found");
        if (voteRepository.existsByVoterIdAndElectionId(voterId, electionId)) throw new DuplicateVoteException("voter already voted");
        Vote vote = new com.evoter.evoterapp.domain.Vote(voterId, electionId, candidateId, Instant.now());
        voteRepository.save(vote);
    }

    @Override
    public boolean hasVoted(String voterId, String electionId) {
        return voteRepository.existsByVoterIdAndElectionId(voterId, electionId);
    }
}
