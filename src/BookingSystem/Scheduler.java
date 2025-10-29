package BookingSystem;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Scheduler implements IBookingManager {
    Set<IBookable> bookableEntities = new HashSet<>();
    public void addBookableEntity(IBookable bookable) {
        bookableEntities.add(bookable);
    }
    List<IBooking> bookings = new ArrayList<>();
    public Scheduler() {}

    private boolean bookingIsCollidingWithPeriod(IBooking booking, LocalDate start, LocalDate end) {
        if (booking.getEnd().isBefore(start) || booking.getEnd().isEqual(start)) {
            return false;
        }
        if (booking.getStart().isAfter(end) || booking.getStart().isEqual(end)) {
            return false;
        }
        return true;
    }
    public IBooking addBooking (IBookable bookable, IBooker booker, LocalDate start, LocalDate end) throws Exception {
        if (this.collidesWithExistingBooking(bookable, start, end)) {
            throw new Exception("This booking collides with other booking.");
        }
        IBooking booking = new Booking(start, end, booker, bookable);
        this.bookings.add(booking);
        return booking;
    }
    private boolean collidesWithExistingBooking(IBookable bookable, LocalDate start, LocalDate end) {
        for (IBooking b : this.bookings) {
            if (b.getBookableItem() == bookable) {
                if (bookingIsCollidingWithPeriod(b, start, end)) {
                    return true;
                }
            }
        }
        return false;
    }
    public List<IBookable> getBookableItemsForPeriod(LocalDate start, LocalDate end) {
        List<IBookable> bookable = new ArrayList<>();
        for (IBookable entity : this.bookableEntities) {
            if (!collidesWithExistingBooking(entity, start, end)) {
                bookable.add(entity);
            }
        }
        return bookable;
    }
}
