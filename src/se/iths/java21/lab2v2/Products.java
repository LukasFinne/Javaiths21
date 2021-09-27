package se.iths.java21.lab2v2;

import java.util.Objects;

public class Products {
    private String name;
    private int price;
    private Categories categories;
    private int eanCode;
    private String tradeMark;

    public Products(String name, int price, Categories categories, int eanCode, String tradeMark) {
        this.name = name;
        this.price = price;
        this.categories = categories;
        this.eanCode = eanCode;
        this.tradeMark = tradeMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getEanCode() {
        return eanCode;
    }

    public void setEanCode(int eanCode) {
        this.eanCode = eanCode;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return price == products.price && eanCode == products.eanCode && Objects.equals(name, products.name) && categories == products.categories && Objects.equals(tradeMark, products.tradeMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, categories, eanCode, tradeMark);
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                ", eanCode=" + eanCode +
                ", tradeMark='" + tradeMark + '\'' +
                '}';
    }
}

