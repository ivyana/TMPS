package beverages.builders;

public interface BeverageBuilder {
    void create();
    void setName(String name);
    void setType(String type);
    void setPrice(float price);
}