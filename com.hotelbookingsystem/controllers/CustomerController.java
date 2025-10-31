package controllers;

import models.Customer;
import services.CustomerService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class CustomerController {

    private final CustomerService service = new CustomerService();

    public void menu() {
        InputManagementUtility.runMenuUntilQuit(new HashMap<>() {{
            put("Show All Customers", () -> showAllCustomers());
            put("Add Customer", () -> addCustomer());
            put("Update Customer", () -> updateCustomer());
            put("Find Customer by Email",() -> findCustomer());
            put("Remove Customer", () -> removeCustomer());
        }});
    }

    private void updateCustomer() {
        // TODO: finish this
        System.out.println("THIS ONLY UPDATES THE CITY FOR NOW");
        int customerId = InputManagementUtility.nextInt("Enter the ID of the user");
        String newCity = InputManagementUtility.nextLine("Enter the new city");
        try {
            Customer customer = service.getCustomerById(customerId);
            customer.setCity(newCity);
            service.updateCustomer(customer);
            prettyPrint(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void findCustomer() {
        String enteredEmail = InputManagementUtility.nextLine("Enter email:");

        try {
            Customer foundCustomer = service.getCustomerByEmail(enteredEmail);
            prettyPrint(foundCustomer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void removeCustomer() {
        int id = InputManagementUtility.nextInt("Enter the ID of the customer you wish to remove");
        try {
            prettyPrint(service.getCustomerById(id));
            String response = InputManagementUtility.nextLine("Delete this user? y/n");
            if(Objects.equals(response, "y")) {
                service.deleteCustomer(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
        System.out.printf("%d |%s, %s (%s)%n",
                customer.getId(),
                customer.getName(),
                customer.getCity(),
                customer.getEmail()
        );
    }
}
