package se.iths.java21.lab2v2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class Products implements Command {
    Scanner sc = new Scanner(System.in);
    private List<ProductsInfo> productsList;
    private static Pattern pattern = Pattern.compile(",");
    String homeFolder = System.getProperty("user.home");
    Path path = Path.of(homeFolder, "ProductsInfo.json");
    ObjectMapper objectMapper = new ObjectMapper();
    Cart c = new Cart();

    public Products() {
        productsList = new ArrayList<>();
        String json = saveToFile();
        productsList = fromJson(json);

    }

    public String saveToFile() {
        addProducts();
        String json = toJson(productsList);
        try {
            Files.writeString(path, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    private String toJson(List<ProductsInfo> product){
        ObjectMapper mapper = new ObjectMapper();

        String json = "";
        try {
            json = mapper.writeValueAsString(product);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }
    private List<ProductsInfo> fromJson(String jsonData){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonData, new TypeReference<>(){});//TypeRefernce är för att type erasure
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return List.of();
    }


    public List<ProductsInfo> getAllProducts() {
        return Collections.unmodifiableList(productsList);
    }

    public Optional<ProductsInfo> findProductById(long productsId) {
       return productsList.stream()
                .filter(ProductsInfo -> ProductsInfo.getEanCode() == productsId)
                .findFirst();
    }

    public List<ProductsInfo> findProductByCategory(String category) {
        return productsList.stream()
                .filter(ProductsInfo -> ProductsInfo.getCategory().equals(Category.valueOf(category)))
                .toList();

    }
    public void addProducts(ProductsInfo productsInfo) {
        productsList.add(productsInfo);
    }

    private void addProducts() {
            addProducts(new ProductsInfo("nötfärs", 35,Category.MEAT, 1001, "Ica", 1));
            addProducts(new ProductsInfo("nötfärs", 35,Category.MEAT, 1001, "Ica", 1));
            addProducts(new ProductsInfo("blandfärs", 30,Category.MEAT, 1002, "Ica", 1));
            addProducts(new ProductsInfo("kyckling", 25,Category.MEAT, 1003, "Ica", 1));
            addProducts(new ProductsInfo("vitlök", 20,Category.VEGETABLES, 2001, "Coop", 1));
            addProducts(new ProductsInfo("senap", 40,Category.DRYGOODS, 3001, "Willys", 1));
            addProducts(new ProductsInfo("peppar", 50,Category.DRYGOODS, 3002, "Willys", 1));
    }

    /*
    private void productsFromFile() {
        try(Stream<String> lines  = Files.lines(csvPath)){
            productsList = lines.skip(1)
                    .map(Products::createProducts)
                    .collect(Collectors.toList());
        }catch(IOException e){
            e.printStackTrace();
        }

    }
     */

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
                .filter(ProductsInfo -> ProductsInfo.getName().equals(nameOfProduct));
    }

    private void decreaseStock(String nameOfProduct) {
        filterNameStream(nameOfProduct)
                .forEach(p -> p.setStock(p.getStock() - 1));

    }

    private boolean inStockOrNot(String nameOfProduct){
        return filterNameStream(nameOfProduct)
                .anyMatch(productsInfo -> productsInfo.getStock() == 0);
    }

    private List<NameAndPrice> mapToNameAndPrice(String nameOfProduct) {
        return filterNameStream(nameOfProduct)
                .map(productsInfo -> new NameAndPrice(productsInfo.getName(), productsInfo.getPrice()))
                .toList();
    }


    @Override
    public void execute() {
        printMenuOption();
        searchMethod(sc);
    }
}
