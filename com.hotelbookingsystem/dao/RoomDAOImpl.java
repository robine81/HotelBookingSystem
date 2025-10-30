package dao;

import db.DBConnection;
import models.Room;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomDAOImpl implements RoomDAO{
    @Override
    public int addRoom(Room room) throws SQLException {
        int rowsAdded;
        String sql = """
                INSERT INTO rooms(type, price)
                VALUES(?, ?)
                """;
        Connection conn = DBConnection.getConnection();
        try(
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, room.getType());
            statement.setDouble(2, room.getPrice());
            rowsAdded = statement.executeUpdate();
            try(ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    room.initializeId(generatedKeys.getInt(1));
                }
            }
        }
        return rowsAdded;
    }

    @Override
    public Optional<Room> getRoomById(int id) throws SQLException {
        String sql = """
                SELECT * FROM rooms WHERE id = ?
                """;
        Connection conn = DBConnection.getConnection();
        try(
            PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1, id);
            try(ResultSet rs = statement.executeQuery()){
                if (rs.next()) {
                    return Optional.of(new Room(
                            rs.getInt("id"),
                            rs.getString("type"),
                            rs.getDouble("price")));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Room> getAllRooms() throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String sql = """
                SELECT * FROM rooms
                """;
        Connection conn = DBConnection.getConnection();
        try(
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql)){
            while (rs.next()) {
                rooms.add(new Room(rs.getInt("id"), rs.getString("type"), rs.getDouble("price")));
            }
        }
        return rooms;
    }

    @Override
    public List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate) throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String sql = """
                SELECT * FROM rooms
                WHERE id NOT IN (SELECT room_id FROM bookings
                    WHERE ? BETWEEN start_date AND end_date
                    OR ? BETWEEN start_date AND end_date
                )
                """;
        Connection conn = DBConnection.getConnection();
        try(
            PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setObject(1, startDate);
            statement.setObject(2, endDate);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    rooms.add(new Room(rs.getInt("id"), rs.getString("type"), rs.getDouble("price")));
                }
            }
        }
        return rooms;
    }

    @Override
    public int updateRoom(Room room) throws SQLException {
        int rowsUpdated;
        String sql = """
                UPDATE rooms
                SET type = ?,
                 price = ?
                WHERE id = ?
                """;
        Connection conn = DBConnection.getConnection();
        try(
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, room.getType());
            statement.setDouble(2, room.getPrice());
            statement.setInt(3, room.getId());
            rowsUpdated = statement.executeUpdate();
        }
        return rowsUpdated;
    }

    @Override
    public int deleteRoom(int id) throws SQLException {
        int rowsDeleted;
        String sql = """
                DELETE FROM rooms WHERE id = ?
                """;
        Connection conn = DBConnection.getConnection();
        try(
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            rowsDeleted = statement.executeUpdate();
        }
        return rowsDeleted;
    }
}
