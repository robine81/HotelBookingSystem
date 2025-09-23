package Rooms;

import BookingSystem.IBookable;

public class Suite extends Room implements IBookable {
    public Suite(double price, int capacity) {
        super(price, capacity);
    }
    @Override
    public Type getType() {
        return IBookable.Type.Suite;
    }

    @Override
    public String getPrintableName() {
        return "Rooms.Suite";
    }
}
