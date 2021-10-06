package se.iths.java21.files;

import java.util.Objects;

public final class Cake {
    private final int id;
    private final String name;
    private final int price;

    public Cake(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Cake) obj;
        return this.id == that.id &&
                Objects.equals(this.name, that.name) &&
                this.price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "Cake[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "price=" + price + ']';
    }
}
