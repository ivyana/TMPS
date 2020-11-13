package utilities.builder;

public class Barista {

    public BeverageBuilder prepareCappuccino(CoffeeBuilder builder) {
        builder.create();
        builder.setName("Cappuccino");
        builder.setType("Coffee");
        builder.setPrice(30);
        builder.setDescription("An espresso-based coffee drink that is traditionally prepared with steamed milk foam.");
        return builder;
    }

    public BeverageBuilder prepareEspresso(CoffeeBuilder builder) {
        builder.create();
        builder.setName("Espresso");
        builder.setType("Coffee");
        builder.setPrice(20);
        builder.setDescription("A concentrated form of coffee served in small, strong shots.");
        return builder;
    }

    public BeverageBuilder prepareLatte(CoffeeBuilder builder) {
        builder.create();
        builder.setName("Latte");
        builder.setType("Coffee");
        builder.setPrice(40);
        builder.setDescription("A coffee drink made with espresso and steamed milk.");
        return builder;
    }

    public BeverageBuilder prepareGreenTea(TeaBuilder builder) {
        builder.create();
        builder.setName("Green Tea");
        builder.setType("Tea");
        builder.setPrice(20);
        builder.setDescription("A type of tea that is made from unoxidized Camellia sinensis leaves.");
        return builder;
    }

    public BeverageBuilder prepareBlackTea(TeaBuilder builder) {
        builder.create();
        builder.setName("Black Tea");
        builder.setType("Tea");
        builder.setPrice(15);
        builder.setDescription("A type of tea that is made from oxidized Camellia sinensis leaves with a strong flavor.");
        return builder;
    }

    public BeverageBuilder prepareRedTea(TeaBuilder builder) {
        builder.create();
        builder.setName("Red Tea");
        builder.setType("Tea");
        builder.setPrice(25);
        builder.setDescription("A flavorful, caffeine-free alternative to black and green tea.");
        return builder;
    }

    public BeverageBuilder prepareWhiteTea(TeaBuilder builder) {
        builder.create();
        builder.setName("White Tea");
        builder.setType("Tea");
        builder.setPrice(30);
        builder.setDescription("The most delicate tea made from young or minimally processed leaves of the Camellia sinensis plant.");
        return builder;
    }

}