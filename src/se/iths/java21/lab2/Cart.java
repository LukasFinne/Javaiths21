package se.iths.java21.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart extends Products{
    Scanner sc = new Scanner(System.in);
    List<Meat> cart = new ArrayList<>();
    Meat meat = new Meat();

    public static void main(String[] args) {
        Cart test = new Cart();

        test.Get();
    }

    public void Get(){

    }


}
