package com.evoter.evoterapp.repository;

import com.evoter.evoterapp.domain.Vote;
import java.util.List;
import java.util.Optional;

public interface VoteRepository {

	Vote save(Vote vote);

	List<Vote> findByElectionId(String electionId);

	boolean existsByVoterIdAndElectionId(String voterId, String electionId);

}
