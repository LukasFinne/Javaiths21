package se.iths.java21.lab2v2;

import java.util.*;
import java.util.stream.Stream;


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

    public void findProductById(long productsId) {
        productsList.stream()
                .filter(ProductsInfo -> ProductsInfo.eanCode() == productsId)
                .map(productsInfo -> new NameAndPrice(productsInfo.name(), productsInfo.price()))
                .findFirst().ifPresent(System.out::println);
    }

    public List<ProductsInfo> findProductByCategory(String category) {
        return productsList.stream()
                .filter(ProductsInfo -> ProductsInfo.categories().equals(Categories.valueOf(category)))
                .toList();

    }

    public void addProducts(ProductsInfo productsInfo) {
        productsList.add(productsInfo);
    }

    private void productsFromFile() {
        if (!alreadyExecuted) {
            addProducts(new ProductsInfo("nötfärs", 35, Categories.MEAT, 1001, "Ica", 2));
            addProducts(new ProductsInfo("blandfärs", 30, Categories.MEAT, 1002, "Ica", 0));
            addProducts(new ProductsInfo("kyckling", 25, Categories.MEAT, 1003, "Ica", 4));
            addProducts(new ProductsInfo("vitlök", 20, Categories.VEGETABLES, 2001, "Coop", 1));
            addProducts(new ProductsInfo("senap", 40, Categories.DRYGOODS, 3001, "Willys", 6));
            addProducts(new ProductsInfo("peppar", 50, Categories.DRYGOODS, 3002, "Willys", 10));
            alreadyExecuted = true;
        }
    }

    private void printMenuOption() {
        System.out.println("Here can you search for a specific item/items you want to see by search for id, name, category or trademark!");
        System.out.println("Write what method you want to search with then write what you want to search for ");

    }

    private void searchMethod(Scanner sc) {
        switch (sc.next().toLowerCase()) {
            case "id" -> {
                System.out.println("Write the Id you want to find!");
                findProductById(getId(sc));

                System.out.println("Write the name of the item you want to add! or write 0 if you want to go back ");
                String nameOfProduct = sc.next().toLowerCase();
                stockCheck(nameOfProduct);

            }
            case "category" -> {
                System.out.println("Write the category you want to see");

                String category = sc.next().toUpperCase();
                findProductByCategory(category).forEach(System.out::println);

                System.out.println("Write the name of the item you want to add! or write 0 if you want to go back ");
                String nameOfProduct = sc.next().toLowerCase();
                stockCheck(nameOfProduct);
            }
            case "name" -> {
                System.out.println("Write the name you want to find!");
            }
            case "trademark" -> {
                System.out.println("Write the trademark you want to find!");
            }
            default -> {
                System.out.println("Please try again");
                execute();
            }
        }
    }

    private long getId(Scanner sc) {
        long id = sc.nextLong();
        return id;
    }

    private void stockCheck(String nameOfProduct) {
        if(inStockOrNot(nameOfProduct))
            System.out.println("Not in stock");
       else{
            decreaseStock(nameOfProduct);
            c.addToCart(productsNameAndPrice(nameOfProduct));
        }
    }

    private Stream<ProductsInfo> filterNameStream(String nameOfProduct) {
        return productsList.stream()
                .filter(ProductsInfo -> ProductsInfo.name().equals(nameOfProduct));
    }

    private void decreaseStock(String nameOfProduct) {
        filterNameStream(nameOfProduct)
                .forEach(p -> p.setStock(p.stock() - 1));

    }

    private boolean inStockOrNot(String nameOfProduct){
        return filterNameStream(nameOfProduct)
                .anyMatch(productsInfo -> productsInfo.stock() == 0);
    }

    private List<NameAndPrice> productsNameAndPrice(String nameOfProduct) {
        return filterNameStream(nameOfProduct)
                .map(productsInfo -> new NameAndPrice(productsInfo.name(), productsInfo.price()))
                .toList();
    }


    @Override
    public void execute() {
        printMenuOption();
        searchMethod(sc);
    }
}
