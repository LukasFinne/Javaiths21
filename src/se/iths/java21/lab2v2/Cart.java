package se.iths.java21.lab2v2;

import java.util.ArrayList;
import java.util.List;

public class Cart implements Command{

    private static List<ProductsInfo> cart;
    private final static List<List<ProductsInfo>> cart2 = new ArrayList<>();


    public List<List<ProductsInfo>>showCart(){
        return cart2;
    }


    public void addToCart(List<ProductsInfo> list){
        cart = new ArrayList<>(list);
        cart2.add(cart);
        realItemCheck();
    }

    private void realItemCheck() {
        if(cart.isEmpty()){
            System.out.println("This is item does not exist, please try again");
        } else
            System.out.println("Added to cart");
    }

    @Override
    public void execute() {
        showCart().forEach(System.out::println);
    }
}
