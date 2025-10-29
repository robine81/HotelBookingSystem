package BookableServices;

import BookingSystem.IBookable;

public class SpaTreatment implements IBookable {
    private double price;

    public SpaTreatment(double price) {
        this.price = price;
    }
    public BookingSystem.IBookable.Type getType() {
        return IBookable.Type.SpaTreatment;
    }

    @Override
    public String getPrintableName() {
        return "Spa Treatment";
    }

    public boolean hasPrice() {
        return true;
    }

    public double getPrice() {
        return price;
    }

    public int getCapacity() {
        return 1;
    }

}
