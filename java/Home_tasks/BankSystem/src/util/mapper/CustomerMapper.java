package util.mapper;

import model.Customer;
import dto.request.CreateCustomerRequest;

public class CustomerMapper {

    public static Customer toModel(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setBvn(request.getBvn());
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhoneNumber(request.getPhoneNumber());
        return customer;
    }
}