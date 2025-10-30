package services;

import dao.Impl.BookingDAOImpl;
import models.Booking;

import java.sql.SQLException;
import java.util.List;

public class BookingService {

    BookingDAOImpl bookingDAO = new BookingDAOImpl();

    public int addBooking(Booking booking) throws SQLException {
        return bookingDAO.addBooking(booking);
    }

    public List<Booking> getAllBookings() throws SQLException { return bookingDAO.getAllBookings(); }

    public List<Booking> getBookingsByRoomId(int roomId) throws SQLException {
        return bookingDAO.getBookingsByRoomId(roomId);
    }

    public List<Booking> getBookingsByCustomerId(int customerId) throws SQLException {
        return bookingDAO.getBookingsByCustomerId(customerId);
    }

    public int updateBooking(Booking booking) throws SQLException {
        return bookingDAO.updateBooking(booking);
    }

    public int cancelBooking(Booking booking) throws SQLException {
        return bookingDAO.cancelBooking(booking);
    }
}
