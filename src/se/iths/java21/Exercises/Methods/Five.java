package se.iths.java21.Exercises.Methods;

public class Five {

    public static void main(String[] args) {
        System.out.println(paragraph("Hej"));
    }
    public static String paragraph(String x){
        String p1 = "<p>";
        String p2 = "</p>";

        return p1.concat(x).concat(p2);

    }

}
