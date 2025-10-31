import controllers.*;

import java.sql.SQLException;
import java.util.*;

public class Hotel {

    BookingController bookingController = new BookingController();
    RoomController roomController = new RoomController();
    CustomerController customerController = new CustomerController();
    ReportController reportController = new ReportController();

    public void runMenu() {
        InputManagementUtility.runMenuUntilQuit(new LinkedHashMap<>() {{
            put("Guests", () -> customerController.menu());
            put("Rooms", () -> roomController.menu());
            put("Bookings", () -> bookingController.menu());
            put("Reports", () -> runReport());
        }});
    }

    void runReport() {
        InputManagementUtility.runMenuUntilQuit(new LinkedHashMap<>() {{
            put("Number of bookings by customer", () -> {
                try {
                    System.out.println(reportController.numberOfBookingsPerCustomerToString());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            put ("Average price for bookings", () -> {
                try {
                    System.out.printf("Average price for bookings: %.2f%n", reportController.calculateAveragePriceForBookings());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }});
    }
}
