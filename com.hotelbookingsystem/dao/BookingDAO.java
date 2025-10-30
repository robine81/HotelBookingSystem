package dao;

import models.Booking;
import models.Customer;
import models.Room;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface BookingDAO {

    int addBooking(Booking booking) throws SQLException;

    List<Booking> getAllBookings() throws SQLException;

    List<Booking> getBookingsBetweenDates(LocalDate startDate, LocalDate endDate) throws SQLException;

    List<Booking> getBookingsByRoomId(int roomId) throws SQLException;

    List<Booking> getBookingsByCustomerId(int customerId) throws SQLException;

    int updateBooking(Booking booking) throws SQLException;

    int cancelBooking(Booking booking) throws SQLException;
}
