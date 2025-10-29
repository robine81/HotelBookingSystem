package models;

import java.time.LocalDate;

public class Booking {
    int id;
    int customerId;
    int roomId;
    LocalDate startDate;
    LocalDate endDate;

    public Booking (int customerId, int roomId, LocalDate startDate, LocalDate endDate) {
        this.customerId = customerId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Booking (int id, int customerId, int roomId, LocalDate startDate, LocalDate endDate) {
        this(customerId, roomId, startDate, endDate);
        this.id = id;;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public int getCustomerId () {
        return customerId;
    }

    public int getRoomId () {
        return roomId;
    }

    public LocalDate getStartDate () {
        return startDate;
    }

    public void setStartDate (LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate () {
        return endDate;
    }

    public void setEndDate (LocalDate endDate) {
        this.endDate = endDate;
    }
}
