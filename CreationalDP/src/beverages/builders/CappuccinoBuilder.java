package beverages.builders;

import beverages.Cappuccino;

public class CappuccinoBuilder implements BeverageBuilder {

    private Cappuccino cappuccino;

    public CappuccinoBuilder() {
        this.create();
    }

    @Override
    public void create() {
        this.cappuccino = new Cappuccino();
    }

    @Override
    public void setName(String name) {
        this.cappuccino.setName(name);
    }

    @Override
    public void setType(String type) {
        this.cappuccino.setType(type);
    }

    @Override
    public void setPrice(float price) {
        this.cappuccino.setPrice(price);
    }

    public Cappuccino getBeverage() {
        Cappuccino beverage = this.cappuccino;
        this.create();
        return beverage;
    }
}