package se.iths.java21.Objects.liskov;

public class Demo {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 10);
        rectangle.setWidth(20);
        System.out.println(rectangle);

        Square square = new Square(1);
        square.setHeight(2);
        System.out.println(square);

        Rectangle rectangle1 = new Square(3); //Om detta ska vara korrekt ska square kunna funka med rectangle. Alltså man får inte ändra grund egenskaperna i superklassen.
        //Detta ända man ska göra är att bygga vidare men subklasserna inte att ersätta super klassens egenskaper

    }
}
