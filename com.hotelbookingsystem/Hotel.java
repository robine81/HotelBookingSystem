import BookingSystem.*;
import GuestMgmt.GuestManager;
import GuestMgmt.IGuest;
import GuestMgmt.IGuestManager;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Hotel {
//    IGuestManager guestManager = new GuestManager();
//    IBookingManager bookingManager = new Scheduler();

    public void runMenu() {
//        IGuest cur = this.guestManager.getGuests().get(0);
        InputManagementUtility.runMenuUntilQuit(new HashMap<>() {{
//            put("Book", () -> makeABooking(cur));
            put("Guests", () -> customerMenu());
            put("Rooms", () -> roomsMenu());
            put("Bookings", () -> bookingMenu());
        }});
    }

    private void roomsMenu() {
        InputManagementUtility.runMenuUntilQuit(new HashMap<>() {{
            put("Show All Rooms", () -> System.out.println("show all rooms"));
            put("Add New Room", () -> System.out.println("add room"));
            put("Show Available Rooms", () -> System.out.println("available room"));
            put("update room", () -> System.out.println("update room"));
        }});
    }

    public void customerMenu() {
        InputManagementUtility.runMenuUntilQuit(new HashMap<>() {{
            put("Show All Customers", () -> System.out.println("show all customers"));
            put("Add Customer", () -> System.out.println("add customer"));
            put("Find Customer by Email", () -> System.out.println("find customer"));
            put("Remove Customer", () -> System.out.println("Remove customer"));
        }});
    }

    public void bookingMenu() {
        InputManagementUtility.runMenuUntilQuit(new HashMap<>(){{
            put("Book a room", () -> System.out.println("book room"));
            put("Show all bookings", () -> System.out.println("all bookings"));
            put("Find Customer Bookings by Email", () -> System.out.println("show bookings for customer"));
            put("Cancel booking", () -> System.out.println("cancel booking"));
        }});
    }
//    public void makeABooking (IBooker booker) {
//        LocalDate fromDate;
//        LocalDate toDate;
//        while (true) {
//            boolean acceptedInput = false;
//            String from = InputManagementUtility.nextLine("Choose a start date (leave empty for today)");
//            if (from.equals("")) {
//                fromDate = LocalDate.now();
//                acceptedInput = true;
//            }
//            else {
//                fromDate = LocalDate.parse(from);
//                if (fromDate.isAfter(LocalDate.now())) {
//                    acceptedInput = true;
//                }
//                else {
//                    System.out.println("Please choose a date after "+ LocalDate.now());
//                }
//            }
//            if(acceptedInput) {
//                break;
//            }
//        }
//        String to = InputManagementUtility.nextLine("Choose an end date (leave empty for tomorrow)");
//        if (to.equals("")) {
//            LocalDate today = LocalDate.now();
//            toDate = today.plusDays(1);
//        }
//        else {
//            toDate = LocalDate.parse(to);
//        }
//
//        System.out.println("Available choices for booking: ");
//
//        List<IBookable> bookables = this.bookingManager.getBookableItemsForPeriod(fromDate, toDate);
//
//        Stream<IBookable> stream = bookables.stream();
//
//        Function<IBookable, String> keyFormatter = (i) -> String.format(
//                "%s (%f EUR) (Capacity: %d)",
//                i.getPrintableName(),
//                i.getPrice(),
//                i.getCapacity()
//        );
//
//        Collector<IBookable, ?, Callable<List<IBookable>>> collector =
//                Collectors.collectingAndThen(
//                        Collectors.toList(),
//                        (List<IBookable> list) -> (Callable<List<IBookable>>) () -> list
//                );
//
//        Map<String, Callable<List<IBookable>>> groupMap = stream.collect(
//                Collectors.groupingBy(
//                        keyFormatter,
//                        HashMap::new,
//                        collector
//                )
//        );
//
//        List<IBookable> choices = InputManagementUtility.runMenuType(groupMap);
//
//        IBookable firstAvailable = choices.get(0);
//        try {
//            this.bookingManager.addBooking(firstAvailable, booker, fromDate, toDate);
//            System.out.printf("Congratulations! You have made a successful booking of %s%n", firstAvailable.getPrintableName());
//        } catch (Exception e) {
//            System.out.println("Something went wrong");
//        }
//    }
}
