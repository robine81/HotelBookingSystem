package dao.Impl;

import dao.BookingDAO;
import db.DBConnection;
import models.Booking;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOImpl implements BookingDAO {

    @Override
    public int addBooking (Booking booking) throws SQLException {
        int rowsAdded = 0;
        String sql = "INSERT INTO bookings (customer_id, room_id, start_date, end_date) VALUES (?, ?, ?, ?)";
        try( Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setInt(1, booking.getCustomerId());
            stmt.setInt(2, booking.getRoomId());
            stmt.setObject(3, booking.getStartDate());
            stmt.setObject(4, booking.getEndDate());
            rowsAdded = stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    booking.setId(generatedKeys.getInt(1));
                }
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        return rowsAdded;
    }

    @Override
    public List<Booking> getAllBookings () throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings";
        try( Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                bookings.add(new Booking(
                        rs.getInt("id"),
                        rs.getInt("customer_id"),
                        rs.getInt("room_id"),
                        rs.getObject("start_date", LocalDate.class),
                        rs.getObject("end_date", LocalDate.class)));
            }
        }
        return bookings;
    }

    @Override
    public List<Booking> getBookingsByRoomId (int roomId) throws SQLException {
        List<Booking> bookingsByRoomId = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE room_id = ?";
        try( Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, roomId);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                bookingsByRoomId.add(new Booking(
                        rs.getInt("id"),
                        rs.getInt("customer_id"),
                        rs.getInt("room_id"),
                        rs.getObject("start_date", LocalDate.class),
                        rs.getObject("end_date", LocalDate.class)));
            }
        }
        return bookingsByRoomId;
    }

    @Override
    public List<Booking> getBookingsByCustomerId (int customerId) throws SQLException {
        List<Booking> bookingsByCustomerID = new ArrayList<>();
        String sql = "SELECT * FROM bookings where customer_id = ?";
        try( Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                bookingsByCustomerID.add(new Booking(
                        rs.getInt("id"),
                        rs.getInt("customer_id"),
                        rs.getInt("room_id"),
                        rs.getObject("start_date", LocalDate.class),
                        rs.getObject("end_date", LocalDate.class)));
            }
        }
        return bookingsByCustomerID;
    }

    @Override
    public int updateBooking (Booking booking) throws SQLException {
        int rowsUpdated = 0;
        String sql = "UPDATE bookings SET customer_id = ?, room_id = ?, start_date = ?, end_date = ? WHERE id = ?";
        try( Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, booking.getCustomerId());
            stmt.setInt(2, booking.getRoomId());
            stmt.setObject(3, booking.getStartDate());
            stmt.setObject(4, booking.getEndDate());
            stmt.setInt(5, booking.getId());
            rowsUpdated = stmt.executeUpdate();
        }
        return rowsUpdated;
    }

    @Override
    public int cancelBooking (Booking booking) throws SQLException {
        int rowsDeleted = 0;
        String sql = "DELETE FROM bookings WHERE id = ?";
        try( Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, booking.getId());
            rowsDeleted = stmt.executeUpdate();
        }
        return rowsDeleted;
    }
}
