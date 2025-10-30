import controllers.BookingController;
import controllers.CustomerController;
import controllers.InputManagementUtility;
import controllers.RoomController;

import java.util.*;

public class Hotel {

    BookingController bookingController = new BookingController();
    RoomController roomController = new RoomController();
    CustomerController customerController = new CustomerController();

    public void runMenu() {
        InputManagementUtility.runMenuUntilQuit(new HashMap<>() {{
            put("Guests", () -> customerController.menu());
            put("Rooms", () -> roomController.menu());
            put("Bookings", () -> bookingController.menu());
        }});
    }
}
