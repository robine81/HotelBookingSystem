package controllers;

import models.Customer;
import services.CustomerService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class CustomerController {

    private final CustomerService service = new CustomerService();

    public void menu() {
        InputManagementUtility.runMenuUntilQuit(new HashMap<>() {{
            put("Show All Customers", () -> showAllCustomers());
            put("Add Customer", () -> addCustomer());
            put("Find Customer by Email",() -> findCustomer());
            put("Remove Customer", () -> removeCustomer());
        }});
    }

    private void findCustomer() {
        String enteredEmail = InputManagementUtility.nextLine("Enter email:");

        try {
            Customer foundCustomer = service.getCustomerByEmail(enteredEmail);
            System.out.println(foundCustomer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void removeCustomer() {
        System.out.println("Not Implemented yet");
    }

    private void addCustomer() {
        String name = InputManagementUtility.nextLine("Enter name:");
        String email = InputManagementUtility.nextLine("Enter email:");
        String city = InputManagementUtility.nextLine("Enter city:");
        try {
            System.out.println(service.addCustomer(name,email,city));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void showAllCustomers() {
        System.out.println("Here are all customers");
        List<Customer> list = List.of();
        try {
            list = service.getAllCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        list.forEach(this::prettyPrint);
    }

    private void prettyPrint(Customer customer) {
        System.out.printf("%d|%s, %s (%s)%n",
                customer.getId(),
                customer.getName(),
                customer.getCity(),
                customer.getEmail()
        );
    }
}
