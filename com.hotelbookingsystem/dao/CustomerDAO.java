package dao;

import models.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    int addCustomer(Customer customer) throws SQLException;

    List<Customer> getAllCustomers() throws SQLException;

    Customer getCustomerByEmail(String email) throws SQLException;

    Optional <Customer> getCustomerById(int id) throws SQLException;

    int updateCustomer(Customer customer) throws SQLException;

    int deleteCustomer(int id) throws SQLException;
}
