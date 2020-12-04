package utilities.strategy;

public class GoldDiscounter implements Discounter {
    @Override
    public float applyDiscount(float price) {
    return (float) (price * 0.5);
    }
}
