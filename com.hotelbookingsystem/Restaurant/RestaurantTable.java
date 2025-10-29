package Restaurant;

abstract class RestaurantTable {
    private int numberOfSeats;
    public RestaurantTable(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    public int getCapacity() {
        return this.numberOfSeats;
    }
    public double getPrice() {
        return 0.0;
    }
    public boolean hasPrice() {
        return false;
    }
}
