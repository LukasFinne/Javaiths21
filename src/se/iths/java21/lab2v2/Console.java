package se.iths.java21.lab2v2;

import java.util.List;
public class Console {

    public static void printAllProducts(List<Product> products){
        for (Product pro : products){
            System.out.printf("Namn: %s, %dKr \n Kategori: %s \n Kod: %d, Varumärke: %s \n I lager: %d \n", pro.getName(),pro.getPrice(),pro.getCategory(),pro.getEanCode(),pro.getTradeMark(),pro.getStock());
        }
    }

    public static void printBasicProductInfo(List<Product> products){
        products.forEach(product -> System.out.printf("Namn: %s, Pris: %dkr, I lager: %d \n", product.getName(), product.getPrice(), product.getStock()));

    }

    public static void printNameAndPrice(List<NameAndPrice> products){

        products.forEach(productsInfo -> System.out.printf("Namn: %s, Pris: %dkr",productsInfo.productName(), productsInfo.price() ));

    }

}
