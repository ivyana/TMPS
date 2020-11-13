package utilities.builder;

import domain.Coffee;

public class CoffeeBuilder implements BeverageBuilder {
    private Coffee coffee;

    public CoffeeBuilder(){
        this.create();
    }

    @Override
    public void create() {
        this.coffee = new Coffee();
    }

    @Override
    public void setName(String name) {
        this.coffee.setName(name);
    }

    @Override
    public void setType(String type) {
        this.coffee.setType(type);
    }

    @Override
    public void setDescription(String description) {
        this.coffee.setDescription(description);
    }

    @Override
    public void setPrice(float price) {
        this.coffee.setPrice(price);
    }

    public Coffee getBeverage() {
        Coffee beverage = this.coffee;
        this.create();
        return beverage;
    }
}