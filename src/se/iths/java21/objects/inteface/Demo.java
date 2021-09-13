package se.iths.java21.objects.inteface;

import java.io.Serializable;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        MyList myList = new MyList();
        Serializable serializable = new MyList();
    }
}

class MyList implements Serializable, List<String> {
     //Med override måste allt stämma överens

}
