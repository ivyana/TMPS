package utilities.decorator;

import domain.Product;
import utilities.factories.BeverageFactory;

public class CondimentDecorator extends BeverageDecorator {

    private final String customCondiment;

    public CondimentDecorator(BeverageFactory decoratedBeverage, String customCondiment) {
        super(decoratedBeverage);
        this.customCondiment= customCondiment;
    }

    @Override
    public Product prepareBeverage(String name) {
        Product product = super.prepareBeverage(name);
        product.setCondiment(this.customCondiment);
        return product;
    }

}

