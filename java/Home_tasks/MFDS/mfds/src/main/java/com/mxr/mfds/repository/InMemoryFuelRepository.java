package com.mxr.mfds.repository;

import com.mxr.mfds.model.Fuel;

import java.util.*;

public class InMemoryFuelRepository implements FuelRepository {

    private final Map<String, Fuel> store = new LinkedHashMap<>();

    @Override
    public Fuel save(Fuel fuel) {
        if (fuel == null) {
            throw new IllegalArgumentException("Fuel cannot be null");
        }

        String key = fuel.getName().toLowerCase(Locale.ROOT);
        if (store.containsKey(key)) {
            throw new IllegalStateException("Fuel with name already exists");
        }

        store.put(key, fuel);
        return fuel;
    }

    @Override
    public Optional<Fuel> findByName(String name) {
        if (name == null) throw new IllegalArgumentException("Name cannot be null");
        if (name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty");

        return Optional.ofNullable(store.get(name.toLowerCase(Locale.ROOT)));
    }

    @Override
    public List<Fuel> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(store.values()));
    }

    @Override
    public boolean existsByName(String name) {
        if (name == null) throw new IllegalArgumentException("Name cannot be null");
        if (name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty");

        return store.containsKey(name.toLowerCase(Locale.ROOT));
    }

    @Override
    public Fuel update(Fuel fuel) {
        if (fuel == null) throw new IllegalArgumentException("Fuel cannot be null");

        String key = fuel.getName().toLowerCase(Locale.ROOT);
        if (!store.containsKey(key)) {
            throw new IllegalStateException("Fuel does not exist");
        }

        store.put(key, fuel);
        return fuel;
    }

    @Override
    public void delete(String name) {
        if (name == null) throw new IllegalArgumentException("Name cannot be null");
        if (name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty");

        String key = name.toLowerCase(Locale.ROOT);
        if (!store.containsKey(key)) {
            throw new IllegalStateException("Fuel does not exist");
        }

        store.remove(key);
    }
}
