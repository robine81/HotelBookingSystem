package services;

import dao.RoomDAOImpl;
import models.Room;

import java.sql.SQLException;
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

}
