package se.iths.java21.exercises.oop.advanced;

public class One extends Numbers{

    String color ="black";


    public static void main(String[] args) {
        One one = new One();
        Numbers one2 = new Numbers();
        Numbers one3 = new One();
        Numbers metod2 = new One();



        System.out.println(one.test());
        System.out.println(one2.test());
        System.out.println(one3.test());

        metod2.test2();


        one.printColor();

    }

    void printColor(){
        System.out.println(color);
        System.out.println(super.color);
    }

    public String test(){
        return "one";
    }

}


class Numbers{
    String color="white";
    public String test(){
        return "numbers";
    }
    public void test2(){
        System.out.println("test2");
    }


}