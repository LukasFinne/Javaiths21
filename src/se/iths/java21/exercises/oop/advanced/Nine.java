package se.iths.java21.exercises.oop.advanced;

public abstract class Nine {

    abstract void eat();

}


class Dog extends Nine{

    public static void main(String[] args) {
        Dog dog = new Dog();

        dog.eat();
    }

    @Override
    void eat() {
        System.out.println("Eating");
    }
}