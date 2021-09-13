package se.iths.java21.objects.inteface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
       Pet myPet = Cat.of("Flinga");;//En tumregel är att datatypen är en InterFace t.ex. Pet(datatyp) myPet = new Cat();
        List<String> list = List.of("A", "B", "C"); //För att arraylist och linkedlist båda implemerar list interface så kan man bara byta ut "ArrayList<>();" med "LinkedList<>();"

        for (String x : list) {
            System.out.println(x);
        }

        LandBound landBound = Cat.of("Flinga");
        MouseChase mouseChase = Cat.of("Flinga2");

        System.out.println(landBound.runningSpeed());
        System.out.println(mouseChase.runningSpeed());

        Cat myCat = Cat.of("Flinga");
        Pet myPet2 = myCat;

        Dog dog = new Dog();
        Mammal myMammal = dog;


        System.out.println(myCat.talk());
        System.out.println(myMammal.talk());
        System.out.println(dog.talk());

    }
}

abstract class Mammal{

    private int weight;

    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    abstract String talk();

}


final class Cat extends Mammal implements Pet, LandBound, MouseChase{

    private Cat(String name){

    }

    public static Cat of(String name){//På detta sätt kan vi använda private constructor, Detta kan också hjälpa med läsbarhet
        return new Cat(name);
    }

    @Override
    public boolean isCute() {
        return true;
    }

    @Override //Med override måste allt stämma överens
    public float runningSpeed() {
        return 48.0f;
    }


    @Override
    String talk() {
        return "meow";
    }
}

class Dog extends Mammal{

    @Override
    String talk() {
        return "Woof";
    }
}


@FunctionalInterface
interface Pet{
    boolean isCute();
}

interface FeedablePet extends Pet { //interface kan använda arv också men undvik helst
    void feed();
}

interface MouseChase{
    float runningSpeed();
}
interface LandBound{//Inteface kan används bara som en markör också för att vissa att detta är en viss sak, t.ex. att en katt är LandBound
    float runningSpeed();
}




