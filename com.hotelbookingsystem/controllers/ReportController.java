package controllers;

import models.Customer;
import services.ReportService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ReportController {
    ReportService reportService = new ReportService();
    public Map<Customer, Integer> numberOfBookingsPerCustomer () throws SQLException {
        return reportService.numberOfBookingsPerCustomer();
    }

    public List<Customer> customersWithoutBookings () throws  SQLException {
        return reportService.getListOfCustomersWhoNeverBooked();
    }

    public String numberOfBookingsPerCustomerToString () throws SQLException {
        StringBuilder sb = new StringBuilder();
        Map<Customer, Integer> numberOfBookingsPerCustomer = numberOfBookingsPerCustomer();
        for (Map.Entry<Customer, Integer> entry : numberOfBookingsPerCustomer.entrySet()) {
            sb.append("Customer name:");
            sb.append(" ");
            sb.append(entry.getKey().getName());
            sb.append(" | ");
            sb.append("Number of bookings:");
            sb.append(" ");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    public Double calculateAveragePriceForBookings() throws SQLException {
        return reportService.calculateAveragePriceForBookings();
    }

    public String getCustomersWhoNeverBooked() throws SQLException {
        StringBuilder sb = new StringBuilder();
        List<Customer> customersWithoutBookings =  customersWithoutBookings();
        customersWithoutBookings.forEach(customer -> {
            sb.append("Customer name:");
            sb.append(" ");
            sb.append(customer.getName());
            sb.append("\n");
        });
        return sb.toString();
    }
}
