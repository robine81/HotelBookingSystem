package Rooms;

import BookingSystem.IBookable;

public class DoubleRoom extends Room implements IBookable {
    public DoubleRoom(double price) {
        super(price, 2);
    }

    @Override
    public IBookable.Type getType() {
        return IBookable.Type.DoubleRoom;
    }

    @Override
    public String getPrintableName() {
        return "Double Rooms.Room";
    }
}
