package se.iths.java21.streams;

import java.util.Objects;

public final class Car {
    private final long id;
    private final String model;
    private final String brand;
    private final int year;
    private final int price;

    public Car(long id, String model, String brand, int year, int price) {

        Guard.Against.nullOrEmpty(model);
        Guard.Against.nullOrEmpty(brand);
        Guard.Against.zeroOrLess(price);
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public long id() {
        return id;
    }

    public String model() {
        return model;
    }

    public String brand() {
        return brand;
    }

    public int year() {
        return year;
    }

    public int price() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Car) obj;
        return this.id == that.id &&
                Objects.equals(this.model, that.model) &&
                Objects.equals(this.brand, that.brand) &&
                this.year == that.year &&
                this.price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, brand, year, price);
    }

    @Override
    public String toString() {
        return "Car[" +
                "id=" + id + ", " +
                "model=" + model + ", " +
                "brand=" + brand + ", " +
                "year=" + year + ", " +
                "price=" + price + ']';
    }
    //Om man vill uppdatera något så får man fixa det med hjälp av kopiering så, ta bort pris gör ett nytt pris sen kopiera over resten
}
