package beverages;

public class Latte implements Beverage{
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
        return "A coffee drink made with espresso and steamed milk.";
    }

    @Override
    public String toString() {
        return "*" + name + "*" + "\n" + getDescription() + "\n" + "Price: " + price + ", " + "Category: " + type + "\n";
    }
}
