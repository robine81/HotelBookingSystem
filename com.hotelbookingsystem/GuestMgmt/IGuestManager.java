package GuestMgmt;

import BookingSystem.IBookable;

import java.time.LocalDate;
import java.util.List;

public interface IGuestManager {
    public boolean addGuest(IGuest guest);
    public boolean removeGuest(IGuest guest);
    public List<IGuest> getGuests();
}
