package beverages.builders;

import beverages.RedTea;

public class RedTeaBuilder implements BeverageBuilder {

    private RedTea redTea;

    public RedTeaBuilder() {
        this.create();
    }

    @Override
    public void create() {
        this.redTea= new RedTea();
    }

    @Override
    public void setName(String name) {
        this.redTea.setName(name);
    }

    @Override
    public void setType(String type) {
        this.redTea.setType(type);
    }

    @Override
    public void setPrice(float price) {
        this.redTea.setPrice(price);
    }

    public RedTea getBeverage() {
        RedTea beverage = this.redTea;
        this.create();
        return beverage;
    }
}
