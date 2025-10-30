package controllers;

import models.Booking;
import services.BookingService;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookingController {
    BookingService service = new BookingService();

    public void menu() {
        InputManagementUtility.runMenuUntilQuit(new HashMap<>(){{
            put("Book a room", () -> makeABooking());
            put("Show all bookings", () -> showAllBookings());
            put("Find Customer Bookings by ID", () -> showBookingsByCustomerId());
            put("Find Customer Bookings by email", () -> showBookingsByCustomerEmail());
            put("Cancel booking", () -> cancelBookingByBookingID());
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

        int roomId = InputManagementUtility.nextInt("Enter the ID of the room you wish to book");
        int customerId = InputManagementUtility.nextInt("Enter the ID of the person making the booking");

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
            service.addBooking(customerId, roomId, fromDate, toDate);
            System.out.printf("Your booking has been placed! Your Room ID is: %d and your stay is between %TF and %TF%n",
                    roomId,
                    fromDate,
                    toDate);
        } catch (SQLException e){
            System.out.println("Something has gone wrong, please try again later");
            e.printStackTrace();
        }
    }

    private void showBookingsByCustomerId() {
        List<Booking> bookingsById = new ArrayList<>();
        int customerId = InputManagementUtility.nextInt("Enter the ID of the customer you wish to display all bookings");
        try{
            bookingsById = service.getBookingsByCustomerId(customerId);
        } catch ( SQLException e ) {
            System.out.println("Something has gone wrong, please try again later");
            e.printStackTrace();
        }
        System.out.println("The following booking(s) were found:");
        bookingsById.forEach(System.out::println);
    }

    private void showBookingsByCustomerEmail() {
        List<Booking> bookingsByEmail = new ArrayList<>();
        String customerEmail = InputManagementUtility.nextLine("Enter the e-mail of the customer you wish to display all bookings");
        try{
            bookingsByEmail = service.getBookingsByCustomerEmail(customerEmail);
            System.out.printf("The following booking(s) were found:");
            bookingsByEmail.forEach(System.out::println);
        } catch ( SQLException e ) {
            System.out.println("Something has gone wrong, please try again later");
            throw new RuntimeException(e);
        }
    }

    public void cancelBookingByBookingID() {
        int bookingID = InputManagementUtility.nextInt("Enter the booking ID of the booking you wish to cancel");
        try{
            service.cancelBooking(bookingID);
            System.out.printf("Booking with ID: %d has been cancelled", bookingID);
        } catch ( SQLException e ) {
            System.out.println("Something has gone wrong, please try again later");
            throw new RuntimeException(e);
        }
    }
}
