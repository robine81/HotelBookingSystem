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
    public int addRoom(Room room) {
        int rowsAdded = 0;
        String sql = """
                INSERT INTO rooms(type, price)
                VALUES(?, ?)
                """;
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, room.getType());
            statement.setDouble(2, room.getPrice());
            rowsAdded = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAdded;
    }

    @Override
    public Optional<Room> getRoomById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = """
                SELECT * FROM rooms
                """;
        try(Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql)){
            while (rs.next()) {
                rooms.add(new Room(rs.getInt("id"), rs.getString("type"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate) {
        List<Room> rooms = new ArrayList<>();
        String sql = """
                SELECT * FROM rooms
                WHERE id NOT IN (SELECT room_id FROM bookings
                    WHERE ? BETWEEN start_date AND end_date
                    OR ? BETWEEN start_date AND end_date
                )
                """;
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setObject(1, startDate);
            statement.setObject(2, endDate);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    rooms.add(new Room(rs.getInt("id"), rs.getString("type"), rs.getDouble("price")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public int updateRoom(Room room) {
        return 0;
    }

    @Override
    public int deleteRoom(Room room) {
        return 0;
    }
}
