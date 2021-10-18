package se.iths.java21.fluent;

public class BuildingBuilder {
    private int rooms;
    private boolean chimney;
    private float price;

    public BuildingBuilder setRooms(int rooms) {
        this.rooms = rooms;
        return this;
    }

    public BuildingBuilder setChimney(boolean chimney) {
        this.chimney = chimney;
        return this;
    }

    public BuildingBuilder setPrice(float price) {
        this.price = price;
        return this;
    }
    public BuildingBuilder normalBuilding(){
        rooms = 3;
        chimney = false;
        price = 3_500_000;
        return this;
    }


    public Building createBuilding() {
        return new Building(rooms, chimney, price);
    }
}