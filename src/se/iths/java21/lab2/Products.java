package se.iths.java21.lab2;

import java.util.ArrayList;
import java.util.List;

public class Products implements Command,ProductInfo{

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
       Products meat = new Meat();
       Products products1 = new Products();
       meat.setProducts();

       System.out.println(meat.price);
    }
    public Products(String productName,int price, int stock, String tradeMark, int eanCode) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.tradeMark = tradeMark;
        this.eanCode = eanCode;
    }

    public Products(){

    }

    public void setProducts(){

    }


    public void getProducts(){
        for (Products c : products) {
            System.out.println(c.productName);
        }

    }

    public void printCategories(){
        System.out.println("These are our categories! Please search for what you want to look at!");
        setProducts();
        getProducts();
    }

    public int addStock(int i){
        return i;

    }
    public int removeStock(int i){
        return 0;
    }

    @Override
    public void execute() {
        printCategories();
    }
}
