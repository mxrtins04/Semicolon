package service;

import model.Customer;
import repository.CustomerRepo;
import dto.request.CreateCustomerRequest;
import util.mapper.CustomerMapper;
import util.validation.CustomerValidator;
import java.util.List;

public class CustomerService {
    private CustomerRepo customerRepository;

    public CustomerService(CustomerRepo customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer registerCustomer(CreateCustomerRequest request) {
        Customer customer = CustomerMapper.toModel(request);
        List<String> errors = CustomerValidator.validate(customer);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Validation failed: " + String.join(", ", errors));
        }

        if (customerRepository.findByBvn(customer.getBvn()).isPresent()) {
            throw new IllegalArgumentException("Customer with BVN " + customer.getBvn() + " already exists");
        }

        return customerRepository.save(customer);
    }

    public Customer getCustomerByBvn(String bvn) {
        return customerRepository.findByBvn(bvn)
                .orElseThrow(() -> new RuntimeException("Customer not found with BVN: " + bvn));
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
