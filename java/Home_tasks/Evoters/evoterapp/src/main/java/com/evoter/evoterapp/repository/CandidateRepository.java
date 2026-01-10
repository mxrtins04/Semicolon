package com.evoter.evoterapp.repository;

import com.evoter.evoterapp.domain.Candidate;
import java.util.Optional;
import java.util.List;

public interface CandidateRepository {

	Optional<Candidate> findById(String id);

	List<Candidate> findAllByElectionId(String electionId);

	boolean existsById(String id);

}
