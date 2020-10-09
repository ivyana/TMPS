package beverages.builders;

import beverages.WhiteTea;

public class WhiteTeaBuilder implements BeverageBuilder {

    private WhiteTea whiteTea;

    public WhiteTeaBuilder() {
        this.create();
    }

    @Override
    public void create() {
        this.whiteTea = new WhiteTea();
    }

    @Override
    public void setName(String name) {
        this.whiteTea.setName(name);
    }

    @Override
    public void setType(String type) {
        this.whiteTea.setType(type);
    }

    @Override
    public void setPrice(float price) {
        this.whiteTea.setPrice(price);
    }

    public WhiteTea getBeverage() {
        WhiteTea beverage = this.whiteTea;
        this.create();
        return beverage;
    }
}
