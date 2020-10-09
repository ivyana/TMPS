package beverages;

public class WhiteTea implements Beverage{
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
        return "The most delicate tea made from young or minimally processed leaves of the Camellia sinensis plant.";
    }

    @Override
    public String toString() {
        return "*" + name + "*" + "\n" + getDescription() + "\n" + "Price: " + price + ", " + "Category: " + type + "\n";
    }
}
