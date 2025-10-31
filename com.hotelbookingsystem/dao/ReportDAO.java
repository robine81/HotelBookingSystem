package dao;

import models.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ReportDAO {
    Map<Customer, Integer> numberOfBookingsPerCustomer() throws SQLException;
    Double calculateAveragePriceForBookings() throws SQLException;
    List<Customer> getListOfCustomersWhoNeverBooked() throws SQLException;
}
