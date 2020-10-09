import beverages.Beverage;
import beverages.builders.CappuccinoBuilder;
import beverages.builders.EspressoBuilder;
import beverages.builders.LatteBuilder;

public class CoffeeFactory implements AbstractFactory {
    private static CoffeeFactory coffeeFactory;
    private final Barista barista = new Barista();

    public static CoffeeFactory getCoffeeFactory() {
        if(coffeeFactory == null)
            coffeeFactory = new CoffeeFactory();
        return coffeeFactory;
    }

    private CoffeeFactory() {}

    @Override
    public Beverage prepareBeverage(String name) {

        if(name == null){
            return null;
        }
        if(name.equalsIgnoreCase("CAPPUCCINO")){
            CappuccinoBuilder cappuccinoBuilder = new CappuccinoBuilder();
            barista.prepareCappuccino(cappuccinoBuilder);
            return cappuccinoBuilder.getBeverage();

        } else if(name.equalsIgnoreCase("ESPRESSO")){
            EspressoBuilder espressoBuilder = new EspressoBuilder();
            barista.prepareEspresso(espressoBuilder);
            return espressoBuilder.getBeverage();

        } else if(name.equalsIgnoreCase("LATTE")){
            LatteBuilder latteBuilder = new LatteBuilder();
            barista.prepareLatte(latteBuilder);
            return latteBuilder.getBeverage();
        }

        return null;
    }
}