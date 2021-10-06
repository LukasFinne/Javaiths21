package se.iths.java21.lab2v2;

import java.util.Objects;

public final class ProductsInfo {
    private  String name;
    private  int price;
    private  Category category;
    private  int eanCode;
    private  String tradeMark;
    private int stock;

    public ProductsInfo(String name, int price, Category category, int eanCode, String tradeMark, int Stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.eanCode = eanCode;
        this.tradeMark = tradeMark;
        this.stock = Stock;
    }

    public ProductsInfo(){

    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public int getEanCode() {
        return eanCode;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public int getStock() {
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

