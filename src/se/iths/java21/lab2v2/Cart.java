package se.iths.java21.lab2v2;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Cart implements Command{
    private final int amountInCart = 1;
    private static int sum = 0;
    private static List<NameAndPrice> productListCopy;
    public static Map<List<NameAndPrice>, Integer> productMap = new HashMap<>();


    public void showCart(){
        System.out.println("Products in the cart:");
        productMap.forEach((key, value) -> System.out.println(key + ", " + "x" + value));
        System.out.println("Summa:"+ sum + "Kr");
    }

    public void addToCart(List<NameAndPrice> list){
        productListCopy = new ArrayList<>(list);
        checkIfProductIsAlreadyInCart();
        sum += productPrice();
        realItemCheck();
    }

    private void checkIfProductIsAlreadyInCart() {
        if(productMap.containsKey(productListCopy)){
            productMap.put(productListCopy, productMap.get(productListCopy) + 1);
        }
        else
            productMap.put(productListCopy,amountInCart);
    }

    private int productPrice() {
        return productListCopy.get(0).price();
    }

    private void realItemCheck() {
        if(productListCopy.isEmpty()){
            System.out.println("This is item does not exist, please try again");
        } else
            System.out.println("Added to cart");
    }


    @Override
    public void execute() {
        showCart();
    }
}
