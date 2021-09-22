package se.iths.java21.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Sorting {
    public static void main(String[] args) {
        List<House> houses = new ArrayList<>();
        houses.add(new House(5,50));
        houses.add(new House(3,30));
        houses.add(new House(2,20));
        houses.add(new House(1,10));

        houses.forEach(System.out::println);
        System.out.println("====Sorted====");
        //houses.sort(((o1, o2) -> o1.getRooms() - o2.getRooms()));
        houses.sort((Comparator.comparingInt(House::getRooms)));
        houses.forEach(System.out::println);

    }
}

class House{
    private int rooms;
    private int price;

    public House(int rooms, int price) {
        this.rooms = rooms;
        this.price = price;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return rooms == house.rooms && price == house.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rooms, price);
    }

    @Override
    public String toString() {
        return "House{" +
                "rooms=" + rooms +
                ", price=" + price +
                '}';
    }
}
