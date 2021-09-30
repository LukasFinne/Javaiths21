package se.iths.java21.lab2v2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Cart implements Command{

    private static List<NameAndPrice> productListCopy;
    public static List<List<NameAndPrice>> cart = new ArrayList<>();


    public void showCart(){
        System.out.println("Products in the cart:");
        cart.stream().flatMap(Collection::stream).forEach(System.out::println);

    }


    public void addToCart(List<NameAndPrice> list){
        productListCopy = new ArrayList<>(list);
        cart.add(productListCopy);
        realItemCheck();
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
