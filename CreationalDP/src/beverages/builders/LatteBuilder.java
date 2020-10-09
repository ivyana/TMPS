package beverages.builders;

import beverages.Latte;

public class LatteBuilder implements BeverageBuilder {

    private Latte latte;

    public LatteBuilder() {
        this.create();
    }

    @Override
    public void create() {
        this.latte = new Latte();
    }

    @Override
    public void setName(String name) {
        this.latte.setName(name);
    }

    @Override
    public void setType(String type) {
        this.latte.setType(type);
    }

    @Override
    public void setPrice(float price) {
        this.latte.setPrice(price);
    }

    public Latte getBeverage() {
        Latte beverage = this.latte;
        this.create();
        return beverage;
    }
}