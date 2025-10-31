package services;

import dao.ReportDAO;
import dao.ReportDAOImpl;
import dao.RoomDAO;
import dao.RoomDAOImpl;
import models.Customer;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ReportService {
    ReportDAO reportDAO = new ReportDAOImpl();

    public Map<Customer, Integer> numberOfBookingsPerCustomer () throws SQLException {
        return reportDAO.numberOfBookingsPerCustomer();
    }
    public Double calculateAveragePriceForBookings() throws SQLException {
        return reportDAO.calculateAveragePriceForBookings();
    }

    public List<Customer> getListOfCustomersWhoNeverBooked() throws SQLException {
        return reportDAO.getListOfCustomersWhoNeverBooked();
    }
}
