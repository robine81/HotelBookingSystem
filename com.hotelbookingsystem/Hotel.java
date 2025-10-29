import com.BookableServices.SpaTreatment;
import BookingSystem.*;
import GuestMgmt.Guest;
import GuestMgmt.GuestManager;
import GuestMgmt.IGuest;
import GuestMgmt.IGuestManager;
import Restaurant.BreakfastRestaurantTable;
import Rooms.DoubleRoom;
import Rooms.SingleRoom;
import Rooms.Suite;
import dao.CustomerDAO;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hotel {
    IGuestManager guestManager = new GuestManager();
    IBookingManager bookingManager = new Scheduler();

    {
        this.populateGuests();
        this.populateHotelWithBookables();
    }

    private void populateGuests () {
//        guestManager.addGuest(new Guest("Arne", "Gullberg", "123", "arne.gullberg@arneslivs.se", "070222700"));
//        guestManager.addGuest(new Guest("Gun-Britt", "Andersson", "124", "gunbritt@apple.com", "0703375130"));
    }

    private void populateHotelWithBookables () {
//        this.bookingManager.addBookableEntity(new BreakfastRestaurantTable(2));
//        this.bookingManager.addBookableEntity(new BreakfastRestaurantTable(2));
//        this.bookingManager.addBookableEntity(new BreakfastRestaurantTable(10));
//
//        this.bookingManager.addBookableEntity(new SingleRoom(200));
//        this.bookingManager.addBookableEntity(new SingleRoom(200));
//        this.bookingManager.addBookableEntity(new SingleRoom(300));
//        this.bookingManager.addBookableEntity(new DoubleRoom(400));
//        this.bookingManager.addBookableEntity(new DoubleRoom(400));
//        this.bookingManager.addBookableEntity(new Suite(20000, 10));
//
//        this.bookingManager.addBookableEntity(new Suite(30000, 10));
//        SpaTreatment temp = new SpaTreatment(200);
//        this.bookingManager.addBookableEntity(temp);
    }

    public void runMenu() {
        IGuest cur = this.guestManager.getGuests().get(0);
        InputManagementUtility.runMenuUntilQuit(new HashMap<String, Runnable>(){{
            put("Book", () -> makeABooking(cur));
            put("Guests", () -> guestMenu());
        }});
    }

    public void guestMenu() {
        CustomerDAO.getAllCustomers
    }
    public void makeABooking (IBooker booker) {
        LocalDate fromDate;
        LocalDate toDate;
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

        System.out.println("Available choices for booking: ");

        List<IBookable> bookables = this.bookingManager.getBookableItemsForPeriod(fromDate, toDate);

        Stream<IBookable> stream = bookables.stream();

        Function<IBookable, String> keyFormatter = (i) -> String.format(
                "%s (%f EUR) (Capacity: %d)",
                i.getPrintableName(),
                i.getPrice(),
                i.getCapacity()
        );

        Collector<IBookable, ?, Callable<List<IBookable>>> collector =
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        (List<IBookable> list) -> (Callable<List<IBookable>>) () -> list
                );

        Map<String, Callable<List<IBookable>>> groupMap = stream.collect(
                Collectors.groupingBy(
                        keyFormatter,
                        HashMap::new,
                        collector
                )
        );

        List<IBookable> choices = InputManagementUtility.runMenuType(groupMap);

        IBookable firstAvailable = choices.get(0);
        try {
            this.bookingManager.addBooking(firstAvailable, booker, fromDate, toDate);
            System.out.printf("Congratulations! You have made a successful booking of %s%n", firstAvailable.getPrintableName());
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}
