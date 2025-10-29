package Rooms;

import BookingSystem.IBookable;

public abstract class Room implements IBookable {
    private double price;
    private int capacity;

    public enum RoomType {
        SingleRoom,
        DoubleRoom,
        Suite
    }

    public Room(double price, int capacity) {
        this.price = price;
        this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasPrice() {
        return price > 0;
    }
}

