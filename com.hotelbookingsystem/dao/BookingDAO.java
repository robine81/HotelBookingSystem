package dao;

import models.Booking;
import models.Customer;
import models.Room;

import java.util.List;

public interface BookingDAO {

    int addBooking(Booking booking);

    List<Booking> getAllBookings();

    List<Booking> getBookingsByRoomId(int roomId);

    List<Booking> getBookingsByCustomerId(int customerId);

    int updateBooking(Booking booking);

    int cancelBooking(Booking booking);
}
