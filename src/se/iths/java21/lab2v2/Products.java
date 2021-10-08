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
    private static List<ProductsInfo> productsList;
    String homeFolder = System.getProperty("user.home");
    Path path = Path.of(homeFolder, "ProductsInfo.json");
    Cart c = new Cart();
    ProductsInfo pros = new ProductsInfo();

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

    private String toJson(List<ProductsInfo> product) {
        ObjectMapper mapper = new ObjectMapper();

        String json = "";
        try {
            json = mapper.writeValueAsString(product);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    private List<ProductsInfo> fromJson() {
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

    public List<ProductsInfo> findProductById(long productsId) {
        return productsList.stream()
                .filter(ProductsInfo -> ProductsInfo.getEanCode() == productsId).toList();
    }

    public List<ProductsInfo> findProductByName(String name) {
        return productsList.stream()
                .filter(ProductsInfo -> ProductsInfo.getName().equals(name))
                .toList();
    }

    public List<ProductsInfo> findProductByTradeMark(String tradeMark) {

        return productsList.stream()
                .filter(ProductsInfo -> ProductsInfo.getTradeMark().equals(tradeMark))
                .toList();
    }

    public List<ProductsInfo> findProductByCategory(String category) {
        try {
            return productsList.stream()
                    .filter(ProductsInfo -> ProductsInfo.getCategory().equals(Category.valueOf(category)))
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
            case "category" -> {
                System.out.println("Skriv kategorien du vill se");
                Console.printBasicProductInfo(findProductByCategory(category(sc)));
            }
            case "name" -> {
                System.out.println("Skriv namnet av produkten du vill se");
                Console.printBasicProductInfo(findProductByName(getString(sc)));
            }
            case "trademark" -> {
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

    private Stream<ProductsInfo> filterNameStream(String nameOfProduct) {
        return productsList.stream()
                .filter(ProductsInfo -> ProductsInfo.getName().equals(nameOfProduct));
    }

    private void decreaseStock(String nameOfProduct) {
        filterNameStream(nameOfProduct)
                .forEach(p -> p.setStock(p.getStock() - 1));
    }

    private boolean inStockOrNot(String nameOfProduct) {
        return filterNameStream(nameOfProduct)
                .anyMatch(productsInfo -> productsInfo.getStock() == 0);
    }

    private List<NameAndPrice> mapToNameAndPrice(String nameOfProduct) {
        return filterNameStream(nameOfProduct)
                .map(productsInfo -> new NameAndPrice(productsInfo.getName(), productsInfo.getPrice()))
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
