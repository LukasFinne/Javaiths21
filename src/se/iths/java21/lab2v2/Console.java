package se.iths.java21.lab2v2;

import java.util.List;
public class Console {

    public static void printAllProducts(List<ProductsInfo> products){//Kolla runt 25 min
        for (ProductsInfo pro : products){
            System.out.printf("Namn: %s, %dKr \n Kategori: %s \n Code: %d, Varumärke: %s \n I lager: %d \n", pro.getName(),pro.getPrice(),pro.getCategory(),pro.getEanCode(),pro.getTradeMark(),pro.getStock());
        }
    }

    public static void printBasicProductInfo(List<ProductsInfo> products){
        products.forEach(productsInfo -> System.out.printf("Namn: %s, Pris: %dkr, I lager: %d \n", productsInfo.getName(), productsInfo.getPrice(), productsInfo.getStock()));

    }

    public static void printNameAndPrice(List<NameAndPrice> products){

        products.forEach(productsInfo -> System.out.printf("Namn: %s, Pris: %dkr",productsInfo.productName(), productsInfo.price() ));

    }

}
