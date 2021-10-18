package se.iths.java21.fluent;

public class Building {
    private int rooms;
    private boolean chimney;
    private float price;

    public Building(int rooms, boolean chimney, float price) {
        this.rooms = rooms;
        this.chimney = chimney;
        this.price = price;
    }

    public int getRooms() {
        return rooms;
    }

    public Building setRooms(int rooms) {
        this.rooms = rooms;
        return this;
    }

    public boolean isChimney() {
        return chimney;
    }

    public Building setChimney(boolean chimney) {
        this.chimney = chimney;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Building setPrice(float price) {
        this.price = price;
        return this;
    }
}
