package se.iths.java21.lab2;

import java.util.ArrayList;
import java.util.List;

public class Meat extends Category {
    private String productName;
    private int price;
    private int eanCode;
    private String tradeMark = "Ica";
    private int stock;
    List<Meat> meatProducts = new ArrayList<>();

    public Meat(String productName, int price, int eanCode, String tradeMark) {
        super(productName);
        this.productName = productName;
        this.price = price;
        this.eanCode = eanCode;
        this.tradeMark = tradeMark;
    }


    public Meat(){

    }

    public void setProducts(){
        meatProducts.add(new Meat("Cow", 100,100, tradeMark));
        meatProducts.add(new Meat("Chicken", 200,101, tradeMark));
    }

    public void getProducts(){
        for (Meat m : meatProducts) {
            System.out.println(m.productName + " " + m.price + "kr " + m.eanCode + " " + m.tradeMark);
        }
    }



}
