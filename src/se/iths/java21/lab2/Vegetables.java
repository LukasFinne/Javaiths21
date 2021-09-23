package se.iths.java21.lab2;

public class Vegetables extends Products {

    private String productName;
    private int price;
    private int eanCode;
    private String tradeMark;
    private int stock;


    public Vegetables(String productName,int price, int stock, String tradeMark, int eanCode) {

        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.tradeMark = tradeMark;
        this.eanCode = eanCode;
    }

}
