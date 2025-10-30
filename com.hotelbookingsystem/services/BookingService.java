package services;

import dao.Impl.BookingDAOImpl;
import models.Booking;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class BookingService {

    BookingDAOImpl bookingDAO = new BookingDAOImpl();

    public int addBooking(Booking booking) throws SQLException {
        return bookingDAO.addBooking(booking);
    }

    public List<Booking> getAllBookings() throws SQLException { return bookingDAO.getAllBookings(); }

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

    public int updateBooking(Booking booking) throws SQLException {
        return bookingDAO.updateBooking(booking);
    }

    public int cancelBooking(int id) throws SQLException {
        return bookingDAO.cancelBooking(id);
    }
}
