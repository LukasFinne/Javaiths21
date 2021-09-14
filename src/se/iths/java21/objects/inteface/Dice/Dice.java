package se.iths.java21.objects.inteface.Dice;

public class Dice {
    public static void main(String[] args) {
        Die die1 = new SixSidedDie();
        die1.roll();
        System.out.println(die1.value());
        die1.roll();
        System.out.println(die1.value());


        Die die2 = createDie();
        rollYourDice(die2);

    }


    public static void rollYourDice(Die die){
        die.roll();
        System.out.println(die.value());
    }

    public static Die createDie(){//Skapar en tärning
        return new SixSidedDie();
    }

}

