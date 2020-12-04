package utilities.facade;

import domain.Product;
import utilities.decorator.BeverageDecorator;
import utilities.decorator.CondimentDecorator;
import utilities.factories.BeverageFactory;

public class BeverageCustomizer {

    private final BeverageFactory decoratedBeverage;

    public BeverageCustomizer(BeverageFactory decoratedBeverage) {

        this.decoratedBeverage = decoratedBeverage;
    }

    public Product prepareCustomBeverage(String name, String customCondiment, float price) {
        BeverageDecorator customizer = new CondimentDecorator(decoratedBeverage, customCondiment);
        Product customProduct = customizer.prepareBeverage(name);
        customProduct.setPrice(price);
        return customProduct;
    }
}

