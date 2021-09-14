package se.iths.java21.objects.inteface.Dice;

public interface Die {//Vi måste implentera metoderna också i klasserna för dessa är abstract metoder
    void roll();
    int value();
    int numberOfSides();
}

/*public interface Die<T> {//Detta använder ett generic datatyp så vi kan hantera alla datatyper. T står för "type" är därför man använder den
    void roll();
    T value();
    T numberOfSides();
}*/

