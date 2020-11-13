package utilities.decorator;

import domain.Product;
import utilities.factories.BeverageFactory;

public class BeverageDecorator implements BeverageFactory {

    protected BeverageFactory decoratedBeverage;

    public BeverageDecorator(BeverageFactory decoratedBeverage) {
        this.decoratedBeverage = decoratedBeverage;
    }

    public Product prepareBeverage(String name) {
        return decoratedBeverage.prepareBeverage(name);
    }

}
