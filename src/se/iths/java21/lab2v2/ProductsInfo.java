package se.iths.java21.lab2v2;

import java.util.Objects;

public final class ProductsInfo {
    private final String name;
    private final int price;
    private final Category category;
    private final int eanCode;
    private final String tradeMark;
    private int stock;

    public ProductsInfo(String name, int price, Category category, int eanCode, String tradeMark, int Stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.eanCode = eanCode;
        this.tradeMark = tradeMark;
        this.stock = Stock;
    }

    public String name() {
        return name;
    }

    public int price() {
        return price;
    }

    public Category categories() {
        return category;
    }

    public int eanCode() {
        return eanCode;
    }

    public String tradeMark() {
        return tradeMark;
    }

    public int stock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ProductsInfo) obj;
        return Objects.equals(this.name, that.name) &&
                this.price == that.price &&
                Objects.equals(this.category, that.category) &&
                this.eanCode == that.eanCode &&
                Objects.equals(this.tradeMark, that.tradeMark) &&
                this.stock == that.stock;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, category, eanCode, tradeMark, stock);
    }

    @Override
    public String toString() {
        return "ProductsInfo[" +
                "name=" + name + ", " +
                "price=" + price + ", " +
                "categories=" + category + ", " +
                "eanCode=" + eanCode + ", " +
                "tradeMark=" + tradeMark + ", " +
                "Stock=" + stock + ']';
    }


}

