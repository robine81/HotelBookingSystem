package Restaurant;

import BookingSystem.IBookable;

public class BreakfastRestaurantTable extends RestaurantTable implements IBookable {
    public BreakfastRestaurantTable(int capacity) {
        super(capacity);
    }
    public IBookable.Type getType() {
        return IBookable.Type.BreakfastRestaurantTable;
    }
    public String getPrintableName() {
        return "Restaurant table (Breakfast)";
    }
}
