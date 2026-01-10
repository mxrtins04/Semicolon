package util.validation;

import model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerValidator {

    public static List<String> validate(Customer customer) {
        List<String> errors = new ArrayList<>();

        if (!Validator.isValidBVN(customer.getBvn())) {
            errors.add("BVN must be exactly 11 digits");
        }

        if (!Validator.isNotEmpty(customer.getFirstName())) {
            errors.add("First name cannot be empty");
        }

        if (!Validator.isNotEmpty(customer.getLastName())) {
            errors.add("Last name cannot be empty");
        }

        if (!Validator.isValidEmail(customer.getEmail())) {
            errors.add("Invalid email format");
        }

        if (!Validator.isValidNigerianPhone(customer.getPhoneNumber())) {
            errors.add("Invalid Nigerian phone number");
        }

        if (!Validator.isAdult(customer.getDateOfBirth())) {
            errors.add("Customer must be at least 18 years old");
        }

        return errors;
    }

    public static boolean isValid(Customer customer) {
        return validate(customer).isEmpty();
    }
}