
package beverages.builders;

import beverages.GreenTea;

public class GreenTeaBuilder implements BeverageBuilder {

    private GreenTea greenTea;

    public GreenTeaBuilder() {
        this.create();
    }

    @Override
    public void create() {
        this.greenTea = new GreenTea();
    }

    @Override
    public void setName(String name) {
        this.greenTea.setName(name);
    }

    @Override
    public void setType(String type) {
        this.greenTea.setType(type);
    }

    @Override
    public void setPrice(float price) {
        this.greenTea.setPrice(price);
    }

    public GreenTea getBeverage() {
        GreenTea beverage = this.greenTea;
        this.create();
        return beverage;
    }
}