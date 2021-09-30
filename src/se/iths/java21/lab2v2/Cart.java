package se.iths.java21.lab2v2;

import java.util.*;
import java.util.stream.Collectors;


public class Cart implements Command{

    private static List<NameAndPrice> productListCopy;
    public static List<List<NameAndPrice>> cart = new ArrayList<>();


    public void showCart(){
        System.out.println("Products in the cart:");
        cart.forEach(System.out::println);
        System.out.println(checkFrequency(testList(cart)));
    }


    public void addToCart(List<NameAndPrice> list){
        productListCopy = new ArrayList<>(list);
        cart.add(productListCopy);

        if(checkFrequency(testList(cart)) > 1){
            cart.stream()
                    .flatMap(List::stream)
                    .toList().get(0).increasePrice();
        }

        realItemCheck();
    }

    private void realItemCheck() {
        if(productListCopy.isEmpty()){
            System.out.println("This is item does not exist, please try again");
        } else
            System.out.println("Added to cart");
    }

    private List<NameAndPrice> testList(List<List<NameAndPrice>> list){
        return cart.stream()
                .flatMap(List::stream)
                .toList();
    }

    private int checkFrequency(List<NameAndPrice> list){
        String productsCheck = productListCopy.get(0).productName();
        List<String> test = list.stream().map(NameAndPrice::productName).toList();
        return Collections.frequency(test, productsCheck);
    }

    @Override
    public void execute() {
        showCart();
    }
}
