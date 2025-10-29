package dao;

import models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerByEmail(String email);
    int addCustomer(Customer customer);
    int deleteCustomer(Customer customer);
    int updateCustomer(Customer customer);
}
