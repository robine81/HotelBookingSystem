package services;

import dao.CustomerDAOImpl;
import models.Customer;

import java.util.List;

public class CustomerService {
    CustomerDAOImpl dao = new CustomerDAOImpl();

    public List<Customer> getAllCustomers(){ return dao.getAllCustomers(); }

    public int addCustomer(Customer customer){ return dao.addCustomer(customer);}

    public Customer findCustomerByEmail(String email){ return dao.findCustomerByEmail(email); }
}
