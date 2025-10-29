package controllers;

import models.Customer;
import services.CustomerService;

public class CustomerController {
    CustomerService service = new CustomerService();

    public void getAllCustomers(){
        for(Customer c: service.getAllCustomers()){
            System.out.println(c.toString());
        }
    }

    public int addCustomer(Customer customer){ return service.addCustomer(customer); }

    public Customer findCustomerByEmail(String email){ return service.findCustomerByEmail(email); }
}
