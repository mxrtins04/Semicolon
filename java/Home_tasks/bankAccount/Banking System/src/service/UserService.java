package service;

import data.model.User;
import java.util.List;
import java.util.Optional;

public class UserService {
    private final data.repository.UserRepository userRepository;

    public UserService(data.repository.UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String email) {
        if (emailExists(email)) {
            throw new IllegalArgumentException("Email already exists: " + email);
        }
        
        User user = new User(name, email);
        userRepository.save(user);
        return user;
    }

    public Optional<User> findByBvn(String bvn) {
        return userRepository.findByBvn(bvn);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(String bvn) {
        userRepository.delete(bvn);
    }

    public boolean userExists(String bvn) {
        return userRepository.exists(bvn);
    }

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
