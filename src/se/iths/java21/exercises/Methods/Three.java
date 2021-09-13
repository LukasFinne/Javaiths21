package se.iths.java21.exercises.Methods;

public class Three {
    public static void main(String[] args) {
        person("Lukas", "Mölndal", (byte) 15);
    }
    public static void person(String name, String city, byte favNumber){
        System.out.println("Välkommen! " + name + " från " + city + " med favorittal " + favNumber);

    }
}
