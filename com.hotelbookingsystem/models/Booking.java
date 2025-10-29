package models;

import java.time.LocalDate;

public class Booking {
    int id;
    int customerId;
    int roomId;
    LocalDate startDate;
    LocalDate endDate;

    public Booking (int id, int customerId, int roomId, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.customerId = customerId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public void setCustomerId (int customerId) {
        this.customerId = customerId;
    }

    public int getRoomId () {
        return roomId;
    }

    public void setRoomId (int roomId) {
        this.roomId = roomId;
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
