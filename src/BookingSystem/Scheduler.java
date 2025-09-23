package BookingSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Scheduler {
    List<Booking> bookings = new ArrayList<>();

    public Scheduler() {}

    private boolean bookingIsCollidingWithPeriod(Booking booking, LocalDate start, LocalDate end) {
        if (booking.getEnd().isBefore(start)) {
            return false;
        }
        if (booking.getStart().isAfter(end)) {
            return false;
        }
        return true;
    }

    List<IBookable> unbookableItemsForPeriodByType(IBookable.Type type, LocalDate start, LocalDate end) {
        List<Booking> unbookable = new ArrayList<>();
        for (Booking b : bookings) {
            if (b.getBookableItem().getType().equals(type)) {
                if (bookingIsCollidingWithPeriod(b, start, end)) {
                    unbookable.add(b);
                }
            }
        }
        List<IBookable> uniqueUnbookable =
                unbookable.stream()
                        .map(i -> i.getBookableItem())
                        .distinct()
                        .collect(Collectors.toList());
        return uniqueUnbookable;
    }
    public List<IBookable> getAvailableBookingsForPeriodByType(List<IBookable> listOfBookableItems, IBookable.Type type, LocalDate start, LocalDate end) {
        List<IBookable> unbookable = this.unbookableItemsForPeriodByType(type, start, end);
        List<IBookable> bookable = listOfBookableItems.stream()
                .filter(i -> !unbookable.contains(i))
                .toList();
        return bookable;
    }
}
