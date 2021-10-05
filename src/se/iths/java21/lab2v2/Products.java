package se.iths.java21.lab2v2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Products implements Command {
    Scanner sc = new Scanner(System.in);
    private List<ProductsInfo> productsList;
    private static Pattern pattern = Pattern.compile(",");
    String homePath = System.getProperty("user.home");
    Path csvPath = Path.of(homePath, "ProductInfo.csv");

    Cart c = new Cart();

    public Products() {

        productsList = new ArrayList<>();
        productsFromFile();
    }

    public List<ProductsInfo> getAllProducts() {
        return Collections.unmodifiableList(productsList);
    }

    public Optional<ProductsInfo> findProductById(long productsId) {
       return productsList.stream()
                .filter(ProductsInfo -> ProductsInfo.eanCode() == productsId)
                .findFirst();
    }

    public List<ProductsInfo> findProductByCategory(String category) {
        return productsList.stream()
                .filter(ProductsInfo -> ProductsInfo.categories().equals(Category.valueOf(category)))
                .toList();

    }

    private void productsFromFile() {
        try(Stream<String> lines  = Files.lines(csvPath)){
            productsList = lines.skip(1)
                    .map(Products::createProducts)
                    .collect(Collectors.toList());
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    private static ProductsInfo createProducts(String line){
        String[] arr = pattern.split(line);
        return new ProductsInfo(arr[0],Integer.parseInt(arr[1]), Category.valueOf(arr[2]),Integer.parseInt(arr[3]), arr[4],Integer.parseInt(arr[5]) );

    }


    private void printMenuOption() {
        System.out.println("Here can you search for a specific item/items you want to see by search for id, name, category or trademark!");
        System.out.println("Write what method you want to search with then write what you want to search for ");

    }

    private void searchMethod(Scanner sc) {
        switch (sc.next().toLowerCase()) {
            case "id" -> {
                System.out.println("Write the Id you want to find!");
                findProductById(id(sc)).ifPresent(System.out::println);
                SearchedItem(sc);

            }
            case "category" -> {
                System.out.println("Write the category you want to see");
                findProductByCategory(category(sc)).forEach(System.out::println);
                SearchedItem(sc);
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

    private String category(Scanner sc) {
        return sc.next().toUpperCase();
    }
    private long id(Scanner sc) {
        return sc.nextLong();
    }


    private void SearchedItem(Scanner sc) {
        System.out.println("Write the name of the item you want to add! or write 0 if you want to go back ");
        String nameOfProduct = sc.next().toLowerCase();
        checkStockAndAddItemToCart(nameOfProduct);
    }

    private void checkStockAndAddItemToCart(String nameOfProduct) {
        if(inStockOrNot(nameOfProduct))
            System.out.println("Not in stock");
       else{
            decreaseStock(nameOfProduct);
            c.addToCart(mapToNameAndPrice(nameOfProduct));
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

    private List<NameAndPrice> mapToNameAndPrice(String nameOfProduct) {
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
