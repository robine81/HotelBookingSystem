package controllers;

import services.RoomService;

import java.util.HashMap;

public class RoomController {
    private RoomService service = new RoomService();

    public void menu() {
        InputManagementUtility.runMenuUntilQuit(new HashMap<>() {{
            put("Show All Rooms", () -> System.out.println("show all rooms"));
            put("Add New Room", () -> System.out.println("add room"));
            put("Show Available Rooms", () -> System.out.println("available room"));
            put("update room", () -> System.out.println("update room"));
        }});
    }
}
