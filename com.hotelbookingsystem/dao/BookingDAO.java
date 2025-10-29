package dao;

import models.Booking;

import java.util.List;

public interface BookingDAO {

    List<Booking> getALlBookings();
    List<Booking> getAllBookingsByRoomId(int roomId);
    List<Booking> getALlBookingByCustomerId(int customerId);
    int updateBooking(Booking booking);
    int deleteBooking(Booking booking);
}
