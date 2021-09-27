package se.iths.java21.lab2v2;

import java.util.List;
import java.util.Scanner;

public class Search implements Command{

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        List<Products> products = getProducts();

        System.out.println(products);
    }

    private static List<Products> getProducts() {
        List<Products> products = List.of(
                new Products("Nötfärs", 49, Categories.MEAT, 1001, "Ica"),
                new Products("Vitlök", 20,  Categories.VEGETABLES, 2001, "Ica"),
                new Products("Senap", 32, Categories.DRYGOODS, 3001, "Ica")
        );
        return products;
    }

    private String searchCategoriesBar(Scanner sc, List<Products> products){

       return products.stream().filter(products1 -> Categories.MEAT).forEach(System.out::println);
    }

    @Override
    public void execute() {

    }
}
