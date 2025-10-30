package controllers;

import models.Booking;
import services.BookingService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class BookingController {
    BookingService service = new BookingService();

    public void menu() {
        InputManagementUtility.runMenuUntilQuit(new HashMap<>(){{
            put("Book a room", () -> makeABooking());
            put("Show all bookings", () -> showAllBookings());
            put("Find Customer Bookings by Email", () -> System.out.println("show bookings for customer"));
            put("Cancel booking", () -> System.out.println("cancel booking"));
        }});
    }

    private void showAllBookings() {

        List bookings;
        try{
            bookings = service.getAllBookings();
            bookings.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void makeABooking () {
        LocalDate fromDate;
        LocalDate toDate;

        int roomId = InputManagementUtility.nextInt("Enter the id of the room you wish to book");
        int customerId = InputManagementUtility.nextInt("Enter the id of the person making the booking");

        while (true) {
            boolean acceptedInput = false;
            String from = InputManagementUtility.nextLine("Choose a start date (leave empty for today)");
            if (from.equals("")) {
                fromDate = LocalDate.now();
                acceptedInput = true;
            }
            else {
                fromDate = LocalDate.parse(from);
                if (fromDate.isAfter(LocalDate.now())) {
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
            toDate = today.plusDays(1);
        }
        else {
            toDate = LocalDate.parse(to);
        }

        try{
            service.addBooking(new Booking(customerId, roomId, fromDate, toDate));
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
