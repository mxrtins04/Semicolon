package data.repositories;

import data.models.User;

public interface UserRepository {
    long count();
    User save(User user);
    User findById(int id);
    boolean existsById(int id);
    void deleteById(int id);
    void deleteAll();
}