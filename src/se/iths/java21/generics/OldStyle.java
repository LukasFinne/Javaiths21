package se.iths.java21.generics;

public class OldStyle {
    private Object data;

    public void store(Object o){
        data = o;
    }

    public Object retrieve(){
        return data;
    }

    public static void main(String[] args) {
        OldStyle oldStyle = new OldStyle();
        //Integer s  = 1;
        String s = "Hello";
        oldStyle.store(s);
        String r = (String) oldStyle.retrieve();
        System.out.println(r);
    }
}
