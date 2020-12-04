package utilities.builder;

import domain.Tea;

public class TeaBuilder implements BeverageBuilder {
    private Tea tea;

    public TeaBuilder(){
        this.create();
    }

    @Override
    public void create() {
        this.tea = new Tea();
    }

    @Override
    public void setName(String name) {
        this.tea.setName(name);
    }

    @Override
    public void setType(String type) {
        this.tea.setType(type);
    }

    @Override
    public void setDescription(String description) {
        this.tea.setDescription(description);
    }

    @Override
    public void setPrice(float price) {
        this.tea.setPrice(price);
    }

    public float getPrice() {
        return this.tea.price;
    }

    public Tea getBeverage() {
        Tea beverage = this.tea;
        this.create();
        return beverage;
    }
}