import beverages.Beverage;
import beverages.builders.*;

public class TeaFactory implements AbstractFactory {
    private static TeaFactory teaFactory;
    private final Barista barista = new Barista();

    public static TeaFactory getTeaFactory() {
        if(teaFactory == null)
            teaFactory = new TeaFactory();
        return teaFactory;
    }

    private TeaFactory() {}

    @Override
    public Beverage prepareBeverage(String name) {

        if(name == null){
            return null;
        }
        if(name.equalsIgnoreCase("GREEN TEA")){
            GreenTeaBuilder greenTeaBuilder = new GreenTeaBuilder();
            barista.prepareGreenTea(greenTeaBuilder);
            return greenTeaBuilder.getBeverage();

        } else if(name.equalsIgnoreCase("BLACK TEA")){
            BlackTeaBuilder blackTeaBuilder = new BlackTeaBuilder();
            barista.prepareBlackTea(blackTeaBuilder);
            return blackTeaBuilder.getBeverage();

        } else if(name.equalsIgnoreCase("RED TEA")){
            RedTeaBuilder redTeaBuilder = new RedTeaBuilder();
            barista.prepareRedTea(redTeaBuilder);
            return redTeaBuilder.getBeverage();

        }else if(name.equalsIgnoreCase("WHITE TEA")){
            WhiteTeaBuilder whiteTeaBuilder = new WhiteTeaBuilder();
            barista.prepareWhiteTea(whiteTeaBuilder);
            return whiteTeaBuilder.getBeverage();
        }

        return null;
    }
}