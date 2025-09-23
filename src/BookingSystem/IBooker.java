package BookingSystem;

public interface IBooker {
    public enum Type {
        Guest,
        Company
    }
    public Type getType();
}
