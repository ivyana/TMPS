package beverages.builders;

import beverages.Espresso;

public class EspressoBuilder implements BeverageBuilder {

    private Espresso espresso;

    public EspressoBuilder() {
        this.create();
    }

    @Override
    public void create() {
        this.espresso = new Espresso();
    }

    @Override
    public void setName(String name) {
        this.espresso.setName(name);
    }

    @Override
    public void setType(String type) {
        this.espresso.setType(type);
    }

    @Override
    public void setPrice(float price) {
        this.espresso.setPrice(price);
    }

    public Espresso getBeverage() {
        Espresso beverage = this.espresso;
        this.create();
        return beverage;
    }
}