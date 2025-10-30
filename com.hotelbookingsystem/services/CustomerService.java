package services;

import dao.CustomerDAOImpl;
import models.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {
    CustomerDAOImpl dao = new CustomerDAOImpl();

    public int addCustomer(String name, String email, String city) throws SQLException {
        Customer customer = new Customer(name, email, city);
        return dao.addCustomer(customer);
    }

    public List<Customer> getAllCustomers() throws SQLException { return dao.getAllCustomers(); }

    public Customer findCustomerByEmail(String email) throws SQLException{ return dao.findCustomerByEmail(email); }

    public int updateCustomer(Customer customer) throws SQLException { return dao.updateCustomer(customer); }

    public int deleteCustomer(int id) throws SQLException { return dao.deleteCustomer(id); };
}