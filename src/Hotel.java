import BookingSystem.*;
import GuestMgmt.Guest;
import GuestMgmt.GuestManager;
import GuestMgmt.IGuest;
import GuestMgmt.IGuestManager;
import Rooms.SingleRoom;

import java.util.*;

public class Hotel {
    Scheduler scheduler = new Scheduler();
    List<IBookable> bookableEntities = new ArrayList<>();
    IGuestManager guestManager;
    IBookingManager bookingManager;

    private void populateHotelWithBookables () {
        guestManager.addGuest(new Guest("Tomas", "K", "123", "email", "070222700"));
        /*
        guests.add();

        bookableEntities.add(new SingleRoom(300));
        bookableEntities.add(new SingleRoom(500));

        // bookableEntities.add(new Rooms.SingleRoom(200.0, ))
        IBooker booker = guests.get(0);
        Optional<IGuest> foundGuest = guests.stream()
                .filter(guest -> guest.equals(booker))
                .findFirst();
        System.out.println("Found GuestMgmt.Guest: " + foundGuest.orElse(null));
         */
    }

    public Hotel() {
        populateHotelWithBookables();
    }

    public boolean runCLI() {
        InputManagementUtility.runMenuUntilQuit(new LinkedHashMap<String, Runnable>(){{
            put("test", () -> System.out.println("test"));
            put("test2", () -> System.out.println("test2"));
        }});
        return true;
    }
}
