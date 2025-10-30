package services;

import dao.CustomerDAOImpl;
import models.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CustomerService {
    CustomerDAOImpl dao = new CustomerDAOImpl();

    public int addCustomer(String name, String email, String city) throws SQLException {
        Customer customer = new Customer(name, email, city);
        return dao.addCustomer(customer);
    }

    public List<Customer> getAllCustomers() throws SQLException {
        return dao.getAllCustomers();
    }

    public Customer getCustomerByEmail(String email) throws SQLException {
        return dao.getCustomerByEmail(email);
    }

    public Customer getCustomerById(int id) throws SQLException {
        Optional<Customer> optCustomer = dao.getCustomerById(id);
        if(optCustomer.isPresent()){
            return optCustomer.get();
        } else {
            throw new SQLException("no customer exists!");
        }
    }

    public int updateCustomer(Customer customer) throws SQLException {
        return dao.updateCustomer(customer);
    }

    public int deleteCustomer(int id) throws SQLException {
        return dao.deleteCustomer(id);
    }
}