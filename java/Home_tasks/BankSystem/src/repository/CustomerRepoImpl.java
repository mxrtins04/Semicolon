package repository;

import model.Customer;
import repository.CustomerRepo;
import java.util.*;

public class CustomerRepoImpl implements CustomerRepo {
    private Map<Long, Customer> customers = new HashMap<>();
    private Map<String, Customer> customersByBvn = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(currentId++);
        }
        customers.put(customer.getId(), customer);
        customersByBvn.put(customer.getBvn(), customer);
        return customer;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(customers.get(id));
    }

    @Override
    public Optional<Customer> findByBvn(String bvn) {
        return Optional.ofNullable(customersByBvn.get(bvn));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void update(Customer customer) {
        customers.put(customer.getId(), customer);
        customersByBvn.put(customer.getBvn(), customer);
    }
}