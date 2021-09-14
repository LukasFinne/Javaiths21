package se.iths.java21.objects.inteface.commands.lambdas;

public class Example {
    public static void main(String[] args) {
        OneParam oneParam = (value)-> System.out.println(value);//Det funkaren för att interface är FunctionalInterface
        OneParam oneParam2 = System.out::println; //metod referens, detta funkar för att System.out funkar likadant som something() metoden

        oneParam.something("test");
        oneParam2.something("tes2");

        ReturnType returnType = (x,y) -> x == y; //{return x==y;} om man skriver måsvingar så måste man ha med return och ; i uttrycket
        System.out.println(returnType.compare(10,10));
        System.out.println(returnType.compare(2,1));
    }
}
