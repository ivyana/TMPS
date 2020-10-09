package beverages.builders;

import beverages.BlackTea;

public class BlackTeaBuilder implements BeverageBuilder {

    private BlackTea blackTea;

    public BlackTeaBuilder() {
        this.create();
    }

    @Override
    public void create() {
        this.blackTea = new BlackTea();
    }

    @Override
    public void setName(String name) {
        this.blackTea.setName(name);
    }

    @Override
    public void setType(String type) {
        this.blackTea.setType(type);
    }

    @Override
    public void setPrice(float price) {
        this.blackTea.setPrice(price);
    }

    public BlackTea getBeverage() {
        BlackTea beverage = this.blackTea;
        this.create();
        return beverage;
    }
}
