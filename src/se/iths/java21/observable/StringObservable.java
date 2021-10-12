package se.iths.java21.observable;

import java.util.ArrayList;
import java.util.List;

public class StringObservable implements Observable{

    private List<Observer> observerList = new ArrayList<>();

    private String value = "";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if(!this.value.equals(value)) {
            this.value = value;
            notifyObservers();
        }
    }



    @Override
    public void register(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (var observer : observerList) {
            observer.notification();
        }
    }
}
