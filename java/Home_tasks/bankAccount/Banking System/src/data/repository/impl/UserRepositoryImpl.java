package data.repository.impl;

import data.model.User;
import data.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public Optional<User> findByBvn(String bvn) {
        return users.stream()
                .filter(user -> user.getBvn().equals(bvn))
                .findFirst();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public List<User> findByName(String name) {
        return users.stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void delete(String bvn) {
        users.removeIf(user -> user.getBvn().equals(bvn));
    }

    @Override
    public boolean exists(String bvn) {
        return users.stream()
                .anyMatch(user -> user.getBvn().equals(bvn));
    }

    @Override
    public boolean existsByEmail(String email) {
        return users.stream()
                .anyMatch(user -> user.getEmail().equals(email));
    }

    @Override
    public int count() {
        return users.size();
    }
}
