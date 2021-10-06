package se.iths.java21.lab2v2;

import java.util.function.Supplier;

public class DiscountRule<T> {

    public Supplier<Boolean> condition;
    public Supplier<T> process;

    public DiscountRule(Supplier<Boolean> condition, Supplier<T> process) {
        this.condition = condition;
        this.process = process;
    }
}
