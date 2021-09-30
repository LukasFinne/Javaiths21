package se.iths.java21.lab2v2;

import java.util.*;


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
            addProducts(new ProductsInfo("nötfärs", 35, Categories.MEAT, 1001, "Ica"));
            addProducts(new ProductsInfo("nötfärs", 35, Categories.MEAT, 1001, "Ica"));
            addProducts(new ProductsInfo("blandfärs", 30, Categories.MEAT, 1002, "Ica"));
            addProducts(new ProductsInfo("kyckling", 25, Categories.MEAT, 1003, "Ica"));
            addProducts(new ProductsInfo("vitlök", 20, Categories.VEGETABLES, 2001, "Coop"));
            addProducts(new ProductsInfo("senap", 40, Categories.DRYGOODS, 3001, "Willys"));
            addProducts(new ProductsInfo("peppar", 50, Categories.DRYGOODS, 3002, "Willys"));
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
                String productName = sc.next().toLowerCase();
                addProductToCartCheck(productName);

            }
            case "category" -> {
                System.out.println("Write the category you want to see");

                String category = sc.next().toUpperCase();
                findProductByCategory(category).forEach(System.out::println);

                System.out.println("Write the name of the item you want to add! or write 0 if you want to go back ");
                String productName = sc.next().toLowerCase();
                addProductToCartCheck(productName);
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

    private void addProductToCartCheck(String word) {
        System.out.println("Write the name of the item you want to add!");

        c.addToCart(getProductName(word));
    }

    private List<NameAndPrice> getProductName(String word) {
        return productsList.stream()
                .filter(ProductsInfo -> ProductsInfo.name().equals(word))
                .map(productsInfo -> new NameAndPrice(productsInfo.name(), productsInfo.price()))
                .toList();

    }


    @Override
    public void execute() {
        printMenuOption();
        searchMethod(sc);
    }
}
