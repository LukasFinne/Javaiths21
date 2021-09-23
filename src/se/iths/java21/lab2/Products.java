package se.iths.java21.lab2;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Products implements Command, ProductInfo {

    protected String productName;
    protected int price;
    protected int eanCode;
    protected String tradeMark;
    protected int stock;

    List<Products> products = new ArrayList<>();
    List<Meat> meatList = new ArrayList<>();
    List<Products> vegetables = new ArrayList<>();
    List<Products> dryGoods = new ArrayList<>();

    public static void main(String[] args) {
        Products products1 = new Products();
        Products meat = new Meat();
    }

    public Products(String productName, int price, int stock, String tradeMark, int eanCode) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.tradeMark = tradeMark;
        this.eanCode = eanCode;
    }

    public Products() {

    }

    public void setProducts() {

    }

    public void getProducts() {
        for (Products c : products) {
            System.out.println(c.productName);
        }
    }


    public int getPrice(int i) {
        return 0;
    }
    public String getName(int i){
        return "Test";
    }

    public void printCategories() {
        Scanner sc = new Scanner(System.in);

        System.out.println("These are our categories! Please search for what you want to look at!");
        System.out.println("Meat");
        System.out.println("Vegetables");
        System.out.println("DryGoods");
        System.out.println("1. Search");
        System.out.println("0. Back");
        String test = sc.next();
        if(test.equals("1"))
            System.out.println("Searching");

    }

    public int addStock(int i) {
        return i;

    }

    public int removeStock(int i) {
        return 0;
    }

    @Override
    public void execute() {
        printCategories();
    }
}
