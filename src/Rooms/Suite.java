package Rooms;

import BookingSystem.IBookable;

public class Suite extends Room  {
    public Suite(double price, int capacity) {
        super(price, capacity);
    }
    @Override
    public Type getType() {
        return IBookable.Type.Suite;
    }

    @Override
    public String getPrintableName() {
        return "Suite";
    }
}
