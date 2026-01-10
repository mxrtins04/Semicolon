package repository;

import model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerRepo {
    Customer save(Customer customer);
    Optional<Customer> findById(Long id);
    Optional<Customer> findByBvn(String bvn);
    List<Customer> findAll();
    void update(Customer customer);
}