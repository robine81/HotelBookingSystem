package Rooms;

import BookingSystem.IBookable;

public class SingleRoom extends Room {
    public SingleRoom(double price) {
        super(price, 1);
    }
    @Override
    public IBookable.Type getType() {
        return IBookable.Type.SingleRoom;
    }

    @Override
    public String getPrintableName() {
        return "Single Room";
    }


}
