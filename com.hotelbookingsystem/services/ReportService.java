package services;

import dao.RoomDAO;
import dao.RoomDAOImpl;

import java.sql.SQLException;
import java.time.LocalDate;

public class ReportService {
    RoomDAO roomDAO = new RoomDAOImpl();

    private void showBookingsPerCustomer () throws SQLException {
        // SQL Query:
        // SELECT c.id, c.name, COUNT(DISTINCT b.id) as numberofbookings from customers c INNER join bookings b ON c.id = b.customer_id GROUP BY c.id
    }

    private void showAveragePriceOnBookings() {
        // SELECT AVG(r.price) from bookings b INNER JOIN rooms r ON b.room_id = r.id;
    }

    private void showAvilableRooms() {
        /*
        roomDAO.getAvailableRooms(
                LocalDate.from("2025-11-01"),
                LocalDate.from("2025-12-01"),
        ); */

    }

    private void customersWhoNeverBooked () {
        // SELECT c.id, c.name  from customers c LEFT JOIN bookings b ON c.id = b.customer_id WHERE b.customer_id IS NULL;

    }
}
