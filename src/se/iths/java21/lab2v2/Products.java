package se.iths.java21.lab2v2;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class Products implements Command {
    Scanner sc = new Scanner(System.in);
    private List<ProductsInfo> productsList;
    boolean alreadyExecuted = false;

    Cart c = new Cart();

    public Products() {

        productsList = new ArrayList<>();
        productsFromFile();
    }

    public List<ProductsInfo> getAllProducts() {
        return Collections.unmodifiableList(productsList);
    }

    public Optional<ProductsInfo> findProductById(long productsId){
        return productsList.stream()
                .filter(ProductsInfo -> ProductsInfo.eanCode() == productsId)
                .findAny();
    }

    public void addProducts(ProductsInfo productsInfo) {
        productsList.add(productsInfo);
    }

    private void productsFromFile() {
        if (!alreadyExecuted) {
            addProducts(new ProductsInfo("Nötfärs", 35, Categories.MEAT, 1001, "Ica"));
            addProducts(new ProductsInfo("Nötfärs", 35, Categories.MEAT, 1001, "Ica"));
            addProducts(new ProductsInfo("Blandfärs", 30, Categories.MEAT, 1002, "Ica"));
            addProducts(new ProductsInfo("Kyckling", 25, Categories.MEAT, 1003, "Ica"));
            addProducts(new ProductsInfo("Vitlök", 20, Categories.VEGETABLES, 2001, "Coop"));
            addProducts(new ProductsInfo("Senap", 40, Categories.DRYGOODS, 3001, "Willys"));
            addProducts(new ProductsInfo("Peppar", 50, Categories.DRYGOODS, 3002, "Willys"));
            alreadyExecuted = true;
        }
    }

    private void printMenuOption() {
        System.out.println("Here can you search for a specific item/its you want to see by search for id, name, category or trademark!");
        System.out.println("Write what method you want to search with then write what you want to search for ");

    }

    private void searchMethod(Scanner sc){
        switch(sc.next().toLowerCase()){
            case "id" -> {
                System.out.println("Write the Id you want to find!");
                long id = getId(sc);
                addIdToCartCheck(sc, id);
            }
            case "name" ->{
                System.out.println("Write the name you want to find!");
            }
            case "trademark" -> {
                System.out.println("Write the trademark you want to find!");
            }
        }
    }

    private long getId(Scanner sc) {
        long id = sc.nextLong();
        System.out.println(findProductById(id));
        return id;
    }

    private void addIdToCartCheck(Scanner sc, long id){
        System.out.println("Do you want to add this item to your cart? Yes or No");
        String word = sc.next().toLowerCase();
        if(word.equals("yes")){
            System.out.println("Added to cart");
            c.addToCart(findProductById(id).stream().toList());
        }else
            execute();

    }


    @Override
    public void execute() {
        printMenuOption();
        searchMethod(sc);
    }
}
