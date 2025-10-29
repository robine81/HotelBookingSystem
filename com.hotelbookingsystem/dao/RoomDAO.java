package dao;

import models.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RoomDAO {

    int addRoom(Room room);

    Optional<Room> getRoomById(int id);

    List<Room> getAllRooms();

    List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate);

    int updateRoom(Room room);

    int deleteRoom(Room room);
}
