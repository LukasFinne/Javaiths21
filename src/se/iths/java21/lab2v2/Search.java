package se.iths.java21.lab2v2;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Search implements Command{
    Scanner sc = new Scanner(System.in);
    List<Products> products = getProducts();

    public static void main(String[] args) {
    }

    private static void searchForCategories(List<Products> products2, String name) {
     //   products2.stream().filter(products -> products.getCategories().equals(Categories.valueOf(name))).forEach(System.out::println);
    }

    private static List<Products> getProducts() {
        List<Products> products = List.of(
                new Products("Nötfärs", 49, Categories.MEAT, 1001, "Ica"),
                new Products("Blandfärs", 39, Categories.MEAT, 1002, "Ica"),
                new Products("Kyckling", 25, Categories.MEAT, 1003, "Ica"),
                new Products("Vitlök", 20,  Categories.VEGETABLES, 2001, "Ica"),
                new Products("Senap", 32, Categories.DRYGOODS, 3001, "Ica")
        );
        return products;
    }


    @Override
    public void execute() {
      //  searchForCategories(products, sc.next().toUpperCase()).
    }
}
