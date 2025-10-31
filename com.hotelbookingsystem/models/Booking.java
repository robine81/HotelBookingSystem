package models;

import java.time.LocalDate;

public class Booking {
    private int id;
    private final int customerId;
    private final int roomId;
    private transient String customerName;
    private LocalDate startDate;
    private LocalDate endDate;

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

    public void initializeId(int id) {
        if(this.id == -1) {
            this.id = id;
        }
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Customer Name: %s%n", customerName));
        sb.append(String.format("Booking ID: %s%n", id));
        sb.append(String.format("Room ID: %s%n", roomId));
        sb.append(String.format("Start date: %s%n", startDate));
        sb.append(String.format("End date: %s%n", endDate));
        return sb.toString();
    }
}

