package BookingSystem;

public interface IBookable {
    public enum Type {
        SingleRoom,
        DoubleRoom,
        Suite,
        BreakfastRestaurantTable,
        EveningRestaurantTable,
        BallRoom,
        SpaTreatment
    }
    public Type getType();
    public boolean hasPrice();
    public double getPrice();
    public int getCapacity();
    public String getPrintableName();
}
