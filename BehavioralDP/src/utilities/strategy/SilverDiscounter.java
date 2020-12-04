package utilities.strategy;

public class SilverDiscounter implements Discounter {
    @Override
    public float applyDiscount(float price) {
    return (float) (price * 0.8);
    }
}
