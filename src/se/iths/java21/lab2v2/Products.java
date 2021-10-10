package se.iths.java21.lab2v2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;


public class Products implements Command {
    Scanner sc = new Scanner(System.in);
    private static List<Product> productsList;
    String homeFolder = System.getProperty("user.home");
    Path path = Path.of(homeFolder, "ProductsList.json");
    Cart c = new Cart();
    Product pros = new Product();

    public Products() {
        productsList = new ArrayList<>();
        productsList = fromJson();
    }

    public void saveToFile() {

        String json = toJson(productsList);
        try {
            Files.delete(path);
            Files.createFile(path);
            Files.writeString(path, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Tack för ditt köp!");
        c.showCart();
        c.clearCart();

    }

    private String toJson(List<Product> product) {
        ObjectMapper mapper = new ObjectMapper();

        String json = "";
        try {
            json = mapper.writeValueAsString(product);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    private List<Product> fromJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(Paths.get(String.valueOf(path)).toFile(), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public void getAllProducts() {
        Console.printAllProducts(productsList);
    }

    public List<Product> findProductById(long productsId) {
        return productsList.stream()
                .filter(Product -> Product.getEanCode() == productsId).toList();
    }

    public List<Product> findProductByName(String name) {
        return productsList.stream()
                .filter(Product -> Product.getName().equals(name))
                .toList();
    }

    public List<Product> findProductByTradeMark(String tradeMark) {

        return productsList.stream()
                .filter(Product -> Product.getTradeMark().equals(tradeMark))
                .toList();
    }

    public List<Product> findProductByCategory(String category) {
        try {
            return productsList.stream()
                    .filter(Product -> Product.getCategory().equals(Category.valueOf(category)))
                    .toList();
        } catch (IllegalArgumentException e) {
            return List.of();
        }

    }

    private void searchMethod() {
        Scanner sc = new Scanner(System.in);
        switch (sc.next().toLowerCase()) {
            case "id" -> {
                System.out.println("Skriv id du vill se!");
                Console.printBasicProductInfo(findProductById(id(sc)));
            }
            case "kategori" -> {
                System.out.println("Skriv kategorien du vill se");
                Console.printBasicProductInfo(findProductByCategory(category(sc)));
            }
            case "namn" -> {
                System.out.println("Skriv namnet av produkten du vill se");
                Console.printBasicProductInfo(findProductByName(getString(sc)));
            }
            case "varumärke" -> {
                System.out.println("Skriv varumärket du vill se");
                Console.printBasicProductInfo(findProductByTradeMark(getString(sc)));
            }
            default -> {
                System.out.println("Försök igen!");
                execute();
            }
        }
        SearchedItem(sc);


    }

    private String getString(Scanner sc) {
        return sc.next();
    }

    private String category(Scanner sc) {
        return sc.next().toUpperCase();
    }

    private long id(Scanner sc) {
        return sc.nextLong();
    }

    private void SearchedItem(Scanner sc) {
        System.out.println("Skriv namnet av produkten du vill lägga till i kundvagnen!");
        String nameOfProduct = sc.next().toLowerCase();
        checkStock(nameOfProduct);


    }

    private void checkStock(String nameOfProduct) {
        if (inStockOrNot(nameOfProduct))
            System.out.println("Inte i lager");
        else {
            addToCart(nameOfProduct);
        }
    }

    private void addToCart(String nameOfProduct) {
        try {
            decreaseStock(nameOfProduct);
            Console.printNameAndPrice(mapToNameAndPrice(nameOfProduct));
            c.addToCart(mapToNameAndPrice(nameOfProduct));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Hittade inget, försök igen");
            execute();
        }

    }

    private Stream<Product> filterNameStream(String nameOfProduct) {
        return productsList.stream()
                .filter(Product -> Product.getName().equals(nameOfProduct));
    }

    private void decreaseStock(String nameOfProduct) {
        filterNameStream(nameOfProduct)
                .forEach(p -> p.setStock(p.getStock() - 1));
    }

    private boolean inStockOrNot(String nameOfProduct) {
        return filterNameStream(nameOfProduct)
                .anyMatch(product -> product.getStock() == 0);
    }

    private List<NameAndPrice> mapToNameAndPrice(String nameOfProduct) {
        return filterNameStream(nameOfProduct)
                .map(product -> new NameAndPrice(product.getName(), product.getPrice()))
                .toList();
    }


    private void printMenuOption() {
        System.out.println("Här kan du söka på produkteras id, namn, kategori eller varumärke");
        System.out.println("Skriv vad du vill söka på! t.ex. id");
    }

    @Override
    public void execute() {
        printMenuOption();
        searchMethod();
    }
}
