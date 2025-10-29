package models;

public class Room {
    private int id;
    private String type;
    private double price;

    public Room(String type, double price) {
        id = -1;
        this.type = type;
        this.price = price;
    }

    public Room(int id, String type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void initializeId(int id) {
        if(this.id == -1) {
            this.id = id;
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
