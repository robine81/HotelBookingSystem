package dao;

import models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    int addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Optional<Customer> findCustomerByEmail(String email);

    int updateCustomer(Customer customer);

    int deleteCustomer(Customer customer);
}
