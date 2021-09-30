package se.iths.java21.lab2v2;

record NameAndPrice(String productName, int price) {
    @Override
    public String toString() {
        return productName + ", " + price + "Kr";
    }
}
