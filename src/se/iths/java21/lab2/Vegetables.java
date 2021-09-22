package se.iths.java21.lab2;

import java.util.ArrayList;

public class Vegetables extends Category{

    private String productName;
    private int price;
    private int eanCode;
    private String tradeMark;

    public Vegetables(String productName, int price, int eanCode, String tradeMark) {
        super(productName);
        this.price = price;
        this.eanCode = eanCode;
        this.tradeMark = tradeMark;
    }
}
