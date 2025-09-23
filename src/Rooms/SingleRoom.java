package Rooms;

import BookingSystem.IBookable;

public class SingleRoom extends Room implements IBookable {
    public SingleRoom(double price) {
        super(price, 1);
    }
    @Override
    public IBookable.Type getType() {
        return IBookable.Type.SingleRoom;
    }

    @Override
    public String getPrintableName() {
        return "Single Rooms.Room";
    }


}
