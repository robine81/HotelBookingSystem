package BookingSystem;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IBookingManager {
    public List<IBookable> getBookableItemsForPeriod(LocalDate start, LocalDate end);
    public void addBookableEntity(IBookable bookable);
    public IBooking addBooking (IBookable bookable, IBooker booker, LocalDate start, LocalDate end) throws Exception;
}
