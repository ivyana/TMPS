package beverages;

public class Espresso implements Beverage{
    private String name;
    private String type;
    private float price;

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return "A concentrated form of coffee served in small, strong shots.";
    }

    @Override
    public String toString() {
        return "*" + name + "*" + "\n" + getDescription() + "\n" + "Price: " + price + ", " + "Category: " + type + "\n";
    }
}
