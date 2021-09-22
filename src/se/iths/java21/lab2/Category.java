package se.iths.java21.lab2;

import java.util.ArrayList;
import java.util.List;

public class Category implements Command, ProductInfo{

    private String productName;
    List<Category> products = new ArrayList<>();

    public static void main(String[] args) {
        Category c = new Category("Product");
        Category meat = new Meat();
        meat.setProducts();
        meat.getProducts();
    }
    public Category(String productName) {
        this.productName = productName;
    }


    public Category(){

    }
    public void setProducts(){

    }


    public void getProducts(){
        for (Category c : products) {
            System.out.println(c.productName);
        }
    }


    public void printCategories(){
        System.out.println("These are our categories! Please search for what you want to look at!");
        System.out.println("Meat");
        System.out.println("Vegetables");
        System.out.println("DryGoods \n");
    }

    @Override
    public void execute() {
        printCategories();
    }
}
