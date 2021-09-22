package se.iths.java21.lab2;

public class DryGoods extends Category{
    private String productName;
    private int price;
    private int eanCode;
    private String tradeMark;

    public DryGoods(String productName, int price, int eanCode, String tradeMark) {
        super(productName);
        this.price = price;
        this.eanCode = eanCode;
        this.tradeMark = tradeMark;
    }
}
