package se.iths.java21.observable;

public class StringObservableDemo {
    public static void main(String[] args) {
        StringObservable stringObservable = new StringObservable();

        Observer observer = () -> System.out.println("Value has changed: " + stringObservable.getValue());

        stringObservable.register(observer);

        stringObservable.setValue("Hej");
        stringObservable.setValue("Då!");
        stringObservable.setValue("Då!");

        stringObservable.unregister(observer);

        stringObservable.setValue("Trevlig kväll!");
    }
}
