package se.iths.java21.lab2v2;

import java.util.*;
import java.util.stream.Collectors;


public class Cart implements Command{
    private int amountInCart = 1;
    private static List<NameAndPrice> productListCopy;
    public static Map<String, Integer> productMap = new HashMap<>();

    public static List<List<NameAndPrice>> cart = new ArrayList<>();


    public void showCart(){
        System.out.println("Products in the cart:");
        productMap.forEach((key, value) -> System.out.println(key + ", " + value +"Kr" + "x" + amountInCart));
    }


    public void addToCart(List<NameAndPrice> list){
        productListCopy = new ArrayList<>(list);

        String keyToBeChecked = productName();

        if(productMap.containsKey(keyToBeChecked)){

            productMap.put(productName(), productMap.get(keyToBeChecked) + productPrice());
        }
        else
            productMap.put(productName(), productPrice());


        realItemCheck();
    }

    private int productPrice() {
        return productListCopy.get(0).price();
    }

    private String productName() {
        return productListCopy.get(0).productName();
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
        String productsCheck = productName();
        List<String> test = list.stream().map(NameAndPrice::productName).toList();
        return Collections.frequency(test, productsCheck);
    }

    @Override
    public void execute() {
        showCart();
    }
}
