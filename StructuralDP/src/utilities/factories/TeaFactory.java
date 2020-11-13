package utilities.factories;

import domain.Product;
import utilities.builder.Barista;
import utilities.builder.TeaBuilder;

public class TeaFactory implements BeverageFactory {
    private static TeaFactory teaFactory;
    private final Barista barista = new Barista();

    public static TeaFactory getTeaFactory() {
        if(teaFactory == null)
            teaFactory = new TeaFactory();
        return teaFactory;
    }

    private TeaFactory() {}

    @Override
    public Product prepareBeverage(String name) {

        if(name == null){
            return null;
        }
        if(name.equalsIgnoreCase("GREEN TEA")){
            TeaBuilder teaBuilder = new TeaBuilder();
            barista.prepareGreenTea(teaBuilder);
            return teaBuilder.getBeverage();

        } else if(name.equalsIgnoreCase("BLACK TEA")){
            TeaBuilder teaBuilder = new TeaBuilder();
            barista.prepareBlackTea(teaBuilder);
            return teaBuilder.getBeverage();

        } else if(name.equalsIgnoreCase("RED TEA")){
            TeaBuilder teaBuilder = new TeaBuilder();
            barista.prepareRedTea(teaBuilder);
            return teaBuilder.getBeverage();

        }else if(name.equalsIgnoreCase("WHITE TEA")){
            TeaBuilder teaBuilder = new TeaBuilder();
            barista.prepareWhiteTea(teaBuilder);
            return teaBuilder.getBeverage();
        }

        return null;
    }
}