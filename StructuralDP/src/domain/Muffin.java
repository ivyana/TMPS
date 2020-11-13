package domain;

public class Muffin implements Snack {
    private String name = "Muffin";
    private float price = 15;


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "*" + name + "*" + " \n" + "Price: " + price + "." + "\n";
    }
}
