package beverages;

public class BlackTea implements Beverage{
    private String name;
    private String type;
    private float price;

    public void setName(String name) { this.name = name; }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return "A type of tea that is made from oxidized Camellia sinensis leaves with a strong flavor.";
    }

    @Override
    public String toString() {
        return "*" + name + "*" + "\n" + getDescription() + "\n" + "Price: " + price + ", " + "Category: " + type + "\n";
    }
}
