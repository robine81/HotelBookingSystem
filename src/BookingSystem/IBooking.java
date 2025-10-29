package BookingSystem;

import java.time.LocalDate;

public interface IBooking {
    public LocalDate getStart();
    public LocalDate getEnd();
    public IBooker getBooker();
    public IBookable getBookableItem();
}
