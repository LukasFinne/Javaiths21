package se.iths.java21.observable;

public interface Observable {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();
}
