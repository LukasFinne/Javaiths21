package se.iths.java21.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    Scanner sc = new Scanner(System.in);
    List<String> cart = new ArrayList<>();
    Products meatProducts = new Meat();
    int sum = 0;

    public static void main(String[] args) {
        Cart test = new Cart();

        test.menuSelectionMeat();
        test.showCart();
    }

    public void menuSelectionMeat() {
        System.out.println("Please select what you want to add to the cart!");
        meatProducts.setProducts();
        meatProducts.getProducts();


        switch (sc.next()) {
            case "1":
                System.out.println("You have now added cow to your Cart");
                cart.add(meatProducts.getName(0));
                addMeatToCart(0);
                break;

            default:
                System.out.println("Please try again");
                menuSelectionMeat();
                break;
        }


    }

    public int addMeatToCart(int i){
        return sum += meatProducts.getPrice(i);
    }


    public void showCart(){
        cart.forEach(System.out::println);
        System.out.println("Total amount:" + sum);
    }




}
