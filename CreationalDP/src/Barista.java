import beverages.builders.*;

public class Barista {

    public void prepareCappuccino(CappuccinoBuilder builder) {
        builder.create();
        builder.setName("Cappuccino");
        builder.setType("Coffee");
        builder.setPrice(30);
    }

    public void prepareEspresso(EspressoBuilder builder) {
        builder.create();
        builder.setName("Espresso");
        builder.setType("Coffee");
        builder.setPrice(20);
    }

    public void prepareLatte(LatteBuilder builder) {
        builder.create();
        builder.setName("Latte");
        builder.setType("Coffee");
        builder.setPrice(40);
    }

    public void prepareGreenTea(GreenTeaBuilder builder) {
        builder.create();
        builder.setName("Green Tea");
        builder.setType("Tea");
        builder.setPrice(20);
    }

    public void prepareBlackTea(BlackTeaBuilder builder) {
        builder.create();
        builder.setName("Black Tea");
        builder.setType("Tea");
        builder.setPrice(15);
    }

    public void prepareRedTea(RedTeaBuilder builder) {
        builder.create();
        builder.setName("Red Tea");
        builder.setType("Tea");
        builder.setPrice(25);
    }

    public void prepareWhiteTea(WhiteTeaBuilder builder) {
        builder.create();
        builder.setName("White Tea");
        builder.setType("Tea");
        builder.setPrice(30);
    }

}