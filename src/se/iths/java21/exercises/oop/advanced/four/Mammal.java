package se.iths.java21.exercises.oop.advanced.four;

public class Mammal extends Animal{

    public static void main(String[] args) {
        Mammal mammal = new Mammal();

        mammal.test();
    }
    public void test(){
        System.out.println("This is an mammal");
    }

}
