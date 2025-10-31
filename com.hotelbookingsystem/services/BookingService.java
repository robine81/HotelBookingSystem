package services;

import dao.Impl.BookingDAOImpl;
import models.Booking;
import models.Customer;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class BookingService {

    BookingDAOImpl bookingDAO = new BookingDAOImpl();
    CustomerService customerService = new CustomerService();

    public void addBooking(int id, int roomId, LocalDate startDate, LocalDate endDate) throws SQLException {
        bookingDAO.addBooking(new Booking(id, roomId, startDate, endDate));
    }

    public List<Booking> getAllBookings() throws SQLException {
        List<Booking> bookings = bookingDAO.getAllBookings();
        bookings.forEach(b -> {
            try {
                String customerName = customerService.getCustomerById(b.getCustomerId()).getName();
                b.setCustomerName(customerName);
            } catch ( SQLException e ) {
                throw new RuntimeException(e);
            }
        });
        return bookings;
    }

    public List<Booking> getBookingsBetweenDates(LocalDate startDate, LocalDate endDate) throws SQLException {
        return bookingDAO.getBookingsBetweenDates(startDate, endDate);
    }

    public List<Booking> getBookingMaxDate(LocalDate maxDate) throws SQLException {
        return getAllBookings().stream().filter( b -> b.getEndDate().isBefore(maxDate)).toList();
    }

    public List<Booking> getBookingMinDate(LocalDate minDate) throws SQLException {
        return getAllBookings().stream().filter(b -> b.getStartDate().isAfter(minDate)).toList();
    }

    public List<Booking> getBookingsByRoomId(int roomId) throws SQLException {
        return bookingDAO.getBookingsByRoomId(roomId);
    }

    public List<Booking> getBookingsByCustomerId(int customerId) throws SQLException {
        return bookingDAO.getBookingsByCustomerId(customerId);
    }

    public List<Booking> getBookingsByCustomerEmail(String email) throws SQLException {
        Customer customer = customerService.getCustomerByEmail(email);
        return bookingDAO.getAllBookings().stream().filter(b -> b.getCustomerId() == customer.getId()).toList();
    }

    public int updateBooking(Booking booking) throws SQLException {
        return bookingDAO.updateBooking(booking);
    }

    public int cancelBooking(int id) throws SQLException {
        return bookingDAO.cancelBooking(id);
    }
}
