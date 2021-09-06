package se.iths.java21.String;

import java.util.Objects;
import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        String x = "10";
        String y = "10";

        String z = x + y;//Skapar objekt, Försök inte använda detta i en loop för att det är inte bra för minnet att skapa flera nya String objekt

        //x + y might generate call to concat by compiler
        z = x.concat(y);
        //or this
        StringBuilder builder = new StringBuilder();
        builder.append(x);
        builder.append(y);
        z = builder.toString();

        //Vilken beror på olika anledningar, java ver eller compiler m.m

        String w = x + "10";


        String a = sc.next();
        if(Objects.equals(a, "10")){//Om använder detta so kommer programmet att inte krascha om användaren matar in något konstigt
            System.out.println("You wrote 10");
        }

        a = a.intern(); //Det kommer göra så att dator gå till minnet där strings sparas. Om samma värde finns så kommer datora refera de värdet. annars kommer den bara skapa en ny plats
        //för a värdet. Om man inte skrev detta skulle "a == x" inte vara lika. *Detta fungerar bara på String1. Man behöver inte göra detta om man använder .equals för den jämför innehållet

        if(a.equals(x)){
            System.out.println("A equals X");
        }

    }
}
