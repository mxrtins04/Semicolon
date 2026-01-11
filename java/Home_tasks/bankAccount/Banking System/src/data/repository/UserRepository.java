package data.repository;

import data.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findByBvn(String bvn);
    Optional<User> findByEmail(String email);
    List<User> findByName(String name);
    List<User> findAll();
    void delete(String bvn);
    boolean exists(String bvn);
    boolean existsByEmail(String email);
    int count();
}
