package se.iths.java21.lab2v2;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Cart implements Command {
    private int numberOfProducts = 0;
    private static double sum = 0;
    private static List<NameAndPrice> productListCopy;
    public static Map<List<NameAndPrice>, Integer> productMap = new HashMap<>();


    public void showCart() {
        System.out.println("Produkter i kundvagnen:");
        productMap.forEach((key, value) -> System.out.println("Namn: " + key.stream().map(NameAndPrice::productName).toList() + ", " + key.stream().map(NameAndPrice::price).toList() +"kr, x" + value ));
        System.out.println("Summa:" + applyDiscount() + "Kr");
    }
    public void clearCart(){
        productMap.clear();
        sum = 0;
    }


    public void addToCart(List<NameAndPrice> list) {
        productListCopy = new ArrayList<>(list);
        checkIfProductIsAlreadyInCart();
        sum += productPrice();
        realItemCheck();
    }

    private void checkIfProductIsAlreadyInCart() {
        int amountInCart = 1;
        if (productMap.containsKey(productListCopy)) {
            productMap.put(productListCopy, productMap.get(productListCopy) + 1);
        } else
            productMap.put(productListCopy, amountInCart);

        numberOfProducts += 1;
    }

    private double applyDiscount() {
        Map<DiscountType, DiscountRule<Double>> rules = createRules(sum, numberOfProducts);
        return Stream.of(DiscountType.values())
                .filter(discountType -> rules.get(discountType).condition.get())
                .map(discountType -> rules.get(discountType).process.get())
                .findFirst()
                .orElse(0.0);
    }

    Map<DiscountType, DiscountRule<Double>> createRules(double sum, int numberOfProducts) {
        Map<DiscountType, DiscountRule<Double>> rules = new HashMap<>();
        rules.put(DiscountType.TEN_PERCENT, createRuleForTenPercent(sum, numberOfProducts));
        rules.put(DiscountType.FIVE_PERCENT, createRuleForFivePercent(sum, numberOfProducts));
        rules.put(DiscountType.ONE_PERCENT, createRuleForOnePercent(sum, numberOfProducts));

        return rules;
    }

    DiscountRule<Double> createRuleForTenPercent(double sum, int numberOfProducts) {
        return createRule(
                () -> (numberOfProducts > 5),
                () -> sum - sum * (10.0 / 100)
        );

    }

    DiscountRule<Double> createRuleForFivePercent(double sum, int numberOfProducts) {
        return createRule(
                () -> (numberOfProducts > 2 && numberOfProducts < 5),
                () -> sum - sum * (5.0 / 100)
        );
    }

    DiscountRule<Double> createRuleForOnePercent(double sum, int numberOfProducts) {
        return createRule(
                () -> (numberOfProducts <= 2),
                () -> sum - sum * (1.0 / 100)
        );
    }

    DiscountRule<Double> createRule(Supplier<Boolean> condition, Supplier<Double> process) {
        return new DiscountRule<Double>(condition, process);

    }


    private int productPrice() {
        return productListCopy.get(0).price();
    }

    private void realItemCheck() {
        if (productListCopy.isEmpty()) {
            System.out.println("\nDenna produkten finns inte, försök igen ");
        } else
            System.out.println("\n Produkten har lags till i kundvagnen");
    }


    @Override
    public void execute() {
        showCart();
    }
}
