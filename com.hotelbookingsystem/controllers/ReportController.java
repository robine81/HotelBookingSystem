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
    Double calculateAveragePriceForBookings() throws SQLException {
        return reportService.calculateAveragePriceForBookings();
    }

    public List<Customer> getListOfCustomersWhoNeverBooked() throws SQLException {
        return reportService.getListOfCustomersWhoNeverBooked();
    }
}
