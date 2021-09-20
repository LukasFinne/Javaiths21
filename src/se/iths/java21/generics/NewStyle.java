package se.iths.java21.generics;

public class NewStyle <T>{

    private T data;

    public void store(T o){
        data = o;
    }

    public T retrieve(){
        return data;
    }

    public static void main(String[] args) {
        NewStyle<String> newStyle = new NewStyle<>();
        NewStyle<Integer> newStyle2 = new NewStyle<>();
        Integer i  = 1;//i är en referens till klassen Integer, generics kan bara lagara komplexa datatyper alltså det går inte att använda primitiva typer

        i = i + 1;//Auto unboxing and boxing of result

        String s = "Hello";
        newStyle.store(s);
        newStyle2.store(i);
        String r = newStyle.retrieve();
        Integer ri = newStyle2.retrieve();
        System.out.println(r);
        System.out.println(ri);
    }
}
