package se.iths.java21.Exercises.oop.advanced.four;

public class Animal {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal dog4 = new Mammal();
        Animal bird = new Bird();
        Mammal dog2 = new Dog();
        Dog dog3 = new Dog();

        dog.test();
        bird.test();

        dog2.test();
        dog3.test();
        dog4.test();
    }
    public void test(){
        System.out.println("This is an animal");
    }
}
