package se.iths.java21.lab2v2;

import javax.naming.Name;
import java.util.Objects;

 public class NameAndPrice {
    private final String productName;
    private int price;


    public NameAndPrice(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString() {
        return productName + ", " + price + "Kr";
    }

    public String productName() {
        return productName;
    }

    public int price() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (NameAndPrice) obj;
        return Objects.equals(this.productName, that.productName) &&
                this.price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price);
    }

}
