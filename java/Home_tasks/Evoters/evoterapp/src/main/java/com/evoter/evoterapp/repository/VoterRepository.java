package com.evoter.evoterapp.repository;

import com.evoter.evoterapp.domain.Voter;
import java.util.Optional;

public interface VoterRepository {

	Optional<Voter> findById(String id);

	boolean existsById(String id);

}
