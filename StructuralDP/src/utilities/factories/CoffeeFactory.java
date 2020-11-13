package utilities.factories;

import domain.Product;
import utilities.builder.Barista;
import utilities.builder.CoffeeBuilder;

public class CoffeeFactory implements BeverageFactory {
    private static CoffeeFactory coffeeFactory;
    private final Barista barista = new Barista();

    public static CoffeeFactory getCoffeeFactory() {
        if(coffeeFactory == null)
            coffeeFactory = new CoffeeFactory();
        return coffeeFactory;
    }

    private CoffeeFactory() {}

    @Override
    public Product prepareBeverage(String name) {

        if(name == null){
            return null;
        }
        if(name.equalsIgnoreCase("CAPPUCCINO")){
            CoffeeBuilder coffeeBuilder = new CoffeeBuilder();
            barista.prepareCappuccino(coffeeBuilder);
            return coffeeBuilder.getBeverage();

        } else if(name.equalsIgnoreCase("ESPRESSO")){
            CoffeeBuilder coffeeBuilder = new CoffeeBuilder();
            barista.prepareEspresso(coffeeBuilder);
            return coffeeBuilder.getBeverage();

        } else if(name.equalsIgnoreCase("LATTE")){
            CoffeeBuilder coffeeBuilder = new CoffeeBuilder();
            barista.prepareLatte(coffeeBuilder);
            return coffeeBuilder.getBeverage();
        }

        return null;
    }
}