package se.iths.java21.objects.inteface.commands.lambdas;

@FunctionalInterface //För att det finns bara en metod, Sånna så här enkla finns is java.util.funciton
public interface ReturnType {
    boolean compare(int a, int b);
}
