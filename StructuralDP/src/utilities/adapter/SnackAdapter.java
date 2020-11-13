package utilities.adapter;

import domain.Product;
import domain.Snack;

public class SnackAdapter implements Product {
    private final Snack muffin;

    public SnackAdapter(Snack snack){
        this.muffin = snack;
    }

    @Override
    public String toString() {
        return muffin.toString();
    }

    @Override
    public void setName(String name) {}

    @Override
    public void setType(String type) {}

    @Override
    public void setDescription(String description) {}

    @Override
    public void setPrice(float price) {}

    @Override
    public void setCondiment(String condiment) {}
}
