package com.mxr.bankfinal.data.repository.impl;
import com.mxr.bankfinal.data.model.User;
import com.mxr.bankfinal.data.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public User findByBvn(String bvn) {
        return users.stream()
                .filter(user -> user.getBvn().equals(bvn))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
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
