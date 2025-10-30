package services;

import dao.RoomDAOImpl;
import models.Room;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class RoomService {
    RoomDAOImpl dao = new RoomDAOImpl();

    public int addRoom(String type, double price) throws SQLException {
        return dao.addRoom(new Room(type, price));
    }

    public Room getRoomByID(int id) throws SQLException{
        Optional<Room> optRoom = dao.getRoomById(id);
        if(optRoom.isPresent()){
            return optRoom.get();
        } else {
            throw new SQLException("no room exists!");
        }
    }

    public List<Room> getAllRooms() throws SQLException{
        return dao.getAllRooms();
    }

    public List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate) throws SQLException{
        return dao.getAvailableRooms(startDate, endDate);
    }

    public void updateRoom(int id, String type, double price) throws SQLException{
        Room fetchedRoom = getRoomByID(id);
        fetchedRoom.setType(type);
        fetchedRoom.setPrice(price);
        dao.updateRoom(fetchedRoom);
    }

    public void deleteRoom(int id) throws SQLException {
        dao.deleteRoom(id);
    }

}
