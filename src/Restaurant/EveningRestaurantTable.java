package Restaurant;

import BookingSystem.IBookable;

public class EveningRestaurantTable extends RestaurantTable implements IBookable {
    public EveningRestaurantTable(int capacity) {
        super(capacity);
    }
    public IBookable.Type getType() {
        return IBookable.Type.EveningRestaurantTable;
    }
    public String getPrintableName() {
        return "Restaurant table (Evening)";
    }
}
