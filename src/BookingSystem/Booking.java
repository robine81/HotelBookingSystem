package BookingSystem;

import java.time.LocalDate;
public class Booking {
    private LocalDate start;
    private LocalDate end;
    private IBooker booker;
    private IBookable bookableItem;

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public IBooker getBooker() {
        return booker;
    }

    public IBookable getBookableItem() {
        return bookableItem;
    }

    public Booking(LocalDate start, LocalDate end, IBooker booker, IBookable bookableItem) {
        this.start = start;
        this.end = end;
        this.booker = booker;
        this.bookableItem = bookableItem;
    }
}
