package controllers;

import models.Booking;
import models.Room;
import services.RoomService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class RoomController {
    private final RoomService service = new RoomService();

    public void menu() {
        InputManagementUtility.runMenuUntilQuit(new HashMap<>() {{
            put("Show All Rooms", () -> showAllRooms());
            put("Add New Room", () -> addRoom());
            put("Show Available Rooms", () -> showAvailableRooms());
            put("update room", () -> updateRoom());
        }});
    }

    private void showAllRooms(){
        try {
            service.getAllRooms().forEach(this::prettyPrint);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void addRoom(){
        String enteredType = InputManagementUtility.nextLine("Enter room type (Single/Double/Suite):");
        double enteredPrice = InputManagementUtility.nextDouble("Enter price");
        try {
            service.addRoom(enteredType, enteredPrice);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void showAvailableRooms() {
        LocalDate startDate;
        LocalDate endDate;

        while (true) {
            boolean acceptedInput = false;
            String from = InputManagementUtility.nextLine("Choose a start date (leave empty for today)");
            if (from.equals("")) {
                startDate = LocalDate.now();
                acceptedInput = true;
            }
            else {
                startDate = LocalDate.parse(from);
                if (startDate.isAfter(LocalDate.now())) {
                    acceptedInput = true;
                }
                else {
                    System.out.println("Please choose a date after "+ LocalDate.now());
                }
            }
            if(acceptedInput) {
                break;
            }
        }
        String to = InputManagementUtility.nextLine("Choose an end date (leave empty for tomorrow)");
        if (to.equals("")) {
            LocalDate today = LocalDate.now();
            endDate = today.plusDays(1);
        }
        else {
            endDate = LocalDate.parse(to);
        }

        try{
            List<Room> roomList = service.getAvailableRooms(startDate, endDate);
            roomList.forEach(this::prettyPrint);
            if(roomList.isEmpty()) {
                System.out.println("No rooms found");
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void updateRoom() {
        System.out.println("not implemented");
    }

    private void prettyPrint(Room room) {
        System.out.printf("%d | %s (%.2f)%n", room.getId(), room.getType(), room.getPrice());
    }
}
