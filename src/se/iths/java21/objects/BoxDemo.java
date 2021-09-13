package se.iths.java21.objects;

public class BoxDemo {

    public static void main(String[] args) {
        Box box = new Box();// Detta lagras på heap i minnet
        System.out.println(box.getWidth());
        Box box1 = new Box(1, 20, 30);
        box1.setWidth(-5);
        System.out.println(box1.getWidth());

        //Detta är en kopia av box 1, jobbigt sätt att kopiera ett objekt
        Box box2 = new Box(box1.getWidth(),box1.getLength(), box.getHeight());

        //Bättre sätt a kopiera ett objekt
        Box box3 = new Box(box1);

    }
}
