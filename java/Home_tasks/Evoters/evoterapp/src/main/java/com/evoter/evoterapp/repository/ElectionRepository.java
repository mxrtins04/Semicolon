package com.evoter.evoterapp.repository;

import com.evoter.evoterapp.domain.Election;
import java.util.Optional;

public interface ElectionRepository {

	Optional<Election> findById(String id);

	void save(Election election);

}
