package se.iths.java21.fluent;

public class BuildingBuilder implements RoomsBuilder, PriceBuilder{
    private int rooms;
    private boolean chimney;
    private float price;

    private BuildingBuilder(){

    }

    public static RoomsBuilder getBuilder(){
        return new BuildingBuilder();
    }

    public PriceBuilder setRooms(int rooms) {
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

    interface RoomsBuilder{
        PriceBuilder setRooms(int rooms);
        BuildingBuilder normalBuilding();
}

interface PriceBuilder{
    BuildingBuilder setPrice(float price);
}