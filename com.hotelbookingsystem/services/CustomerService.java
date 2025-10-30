package services;

import dao.CustomerDAOImpl;
import models.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {
    CustomerDAOImpl dao = new CustomerDAOImpl();

    public List<Customer> getAllCustomers() throws SQLException { return dao.getAllCustomers(); }

    public int addCustomer(Customer customer) throws SQLException { return dao.addCustomer(customer);}

    public Customer findCustomerByEmail(String email) throws SQLException{ return dao.findCustomerByEmail(email); }
}
