package se.iths.java21.objects.inteface.Dice;

public class Dice {
    public static void main(String[] args) {
        Die die1 = new SixSidedDie();
        die1.roll();
        System.out.println(die1.value());
        die1.roll();
        System.out.println(die1.value());
    }
}
