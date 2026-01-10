package com.mxr.mfds.repository;

import com.mxr.mfds.model.Fuel;

import java.util.List;
import java.util.Optional;

public interface FuelRepository {

    Fuel save(Fuel fuel);

    Optional<Fuel> findByName(String name);

    List<Fuel> findAll();

    boolean existsByName(String name);

    Fuel update(Fuel fuel);

    void delete(String name);
}
