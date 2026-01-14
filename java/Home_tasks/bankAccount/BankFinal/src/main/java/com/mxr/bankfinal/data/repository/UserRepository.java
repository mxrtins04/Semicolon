package com.mxr.bankfinal.data.repository;
import com.mxr.bankfinal.data.model.User;
import java.util.List;

public interface UserRepository {
    void save(User user);
    User findByBvn(String bvn);
    User findByEmail(String email);
    List<User> findByName(String name);
    List<User> findAll();
    void delete(String bvn);
    boolean exists(String bvn);
    boolean existsByEmail(String email);
    int count();
}
