package GuestMgmt;

import java.util.*;

public class GuestManager implements IGuestManager {
    List<IGuest> guests = new ArrayList<>();

    public boolean addGuest(IGuest guest) {
        if (!guests.contains(guest)) {
            guests.add(guest);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean removeGuest(IGuest guest) {
        if (guests.contains(guest)) {
            guests.remove(guest);
            return true;
        }
        else {
            return false;
        }
    }
}
