package se.iths.java21.lab2;


public class Meat extends Products {
    private int eanCode;
    private String tradeMark = "Ica";
    private int stock;
    private boolean alreadyExecuted;

    private Meat(String productName, int price, int stock, String tradeMark, int eanCode) {
        super(productName, price);
        this.stock = stock;
        this.tradeMark = tradeMark;
        this.eanCode = eanCode;
    }

    public Meat() {

    }

    public void setProducts() {
        if (!alreadyExecuted) {
            meatList.add(new Meat("Cow", 100, stock, tradeMark, 100));
            meatList.add(new Meat("Chicken", 50, stock, tradeMark, 101));
            addStock(0);
            addStock(1);
            alreadyExecuted = true;
        }
    }

    public void getProducts() {
        int counter = 1;
        for (Meat m : meatList) {
            System.out.print(counter + ".");
            System.out.printf("%s, Pris:%dkr I lager:%d \n Gjort av: %s \n eanCode: %d,  \n", m.productName, m.price,
                    m.stock, m.tradeMark, m.eanCode);
            counter++;
        }
    }

    public String getName(int i) {
        return meatList.get(i).productName;
    }

    public int getPrice(int i) {
        return meatList.get(i).price;
    }

    public int addStock(int i) {
        return meatList.get(i).stock += 1;
    }

    public int stock(int i) {
        return meatList.get(i).stock;
    }

    public int removeStock(int i) {
        return meatList.get(i).stock -= 1;
    }


}
