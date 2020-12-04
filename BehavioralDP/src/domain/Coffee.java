package domain;

public class Coffee implements Product {
    private String name;
    private String type;
    private String description;
    private String condiment = "No";
    private float price;


    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCondiment(String condiment) {
        this.condiment = condiment;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "*" + name + "*" + "\n" + description + "\n" + "Price: " + price + ", " +
                "Category: " + type + ", " + "Condiment: " + condiment + "." + "\n";
    }
}
