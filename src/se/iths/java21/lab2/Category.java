package se.iths.java21.lab2;

public class Category implements Command{


    public void printCategories(){
        System.out.println("These are our categories! Please search for what you want to look at!");
        System.out.println("Meat");
        System.out.println("Vegetables");
        System.out.println("DryGoods \n");
    }

    @Override
    public void execute() {
        printCategories();
    }
}
