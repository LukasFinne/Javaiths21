package se.iths.java21.exercises.oop.advanced;

public interface Ten {
     void eat();
     void sleep();

}

class Pig implements Ten{


     public static void main(String[] args) {
          Pig pig = new Pig();

          pig.eat();
          pig.sleep();
     }

     @Override
     public void eat() {
          System.out.println("Pig is eating");
     }

     @Override
     public void sleep() {
          System.out.println("Pig is sleeping");
     }
}