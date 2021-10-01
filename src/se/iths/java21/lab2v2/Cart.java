package se.iths.java21.lab2v2;

import java.util.*;
import java.util.stream.Collectors;


public class Cart implements Command{

    private static List<NameAndPrice> productListCopy;
    public static Map<String, Integer> productMap = new HashMap<>();
    public static List<List<NameAndPrice>> cart = new ArrayList<>();


    public void showCart(){
        System.out.println("Products in the cart:");
        productMap.forEach((key, value) -> System.out.println(key + ", " + value +"Kr"));
    }


    public void addToCart(List<NameAndPrice> list){
        productListCopy = new ArrayList<>(list);

        String keyToBeChecked = productListCopy.get(0).productName();

        if(productMap.containsKey(keyToBeChecked))
            productMap.put(productListCopy.get(0).productName(), productMap.get(keyToBeChecked) + productListCopy.get(0).price());
        else
            productMap.put(productListCopy.get(0).productName(), productListCopy.get(0).price());


        realItemCheck();
    }

    private void realItemCheck() {
        if(productListCopy.isEmpty()){
            System.out.println("This is item does not exist, please try again");
        } else
            System.out.println("Added to cart");
    }

    private List<NameAndPrice> convertToList(List<List<NameAndPrice>> list){
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
