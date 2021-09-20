package se.iths.java21.exercises.oop.advanced;

public class Twelve {

}

class Animal implements NoiseMaker{

    public static void main(String[] args) {
        Animal cat = new Cat();

        cat.animal();
        cat.makeNoise();
    }

    @Override
    public void makeNoise() {
        System.out.println("Animal sounds");
    }

    public void animal(){
        System.out.println("I am an Animal");
    }


}

class Cat extends Animal {

    @Override
    public void makeNoise() {
        System.out.println("meow");
    }

    @Override
    public void animal() {
        System.out.println("I am a Cat");
    }
}

class  Bird extends Animal {
    @Override
    public void makeNoise() {
        System.out.println("pip");
    }
    @Override
    public void animal() {
        System.out.println("I am a Bird");
    }
}

class Robot implements NoiseMaker{
    public static void main(String[] args) {
        Robot robot = new Robot();

        robot.makeNoise();
    }

    @Override
    public void makeNoise() {
        System.out.println("peep beep");
    }
}


interface NoiseMaker {
    void makeNoise();

}
