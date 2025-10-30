package dao;

import models.Room;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RoomDAO {

    int addRoom(Room room) throws SQLException;

    Optional<Room> getRoomById(int id) throws SQLException;

    List<Room> getAllRooms() throws SQLException;

    List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate) throws SQLException;

    int updateRoom(Room room) throws SQLException;

    int deleteRoom(Room room) throws SQLException;
}
