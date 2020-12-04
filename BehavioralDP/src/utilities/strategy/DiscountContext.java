package utilities.strategy;

public class DiscountContext {
    private final Discounter discounter;

    public DiscountContext(Discounter discounter){
        this.discounter = discounter;
    }

    public float executeStrategy(float price){
        return discounter.applyDiscount(price);
    }
}