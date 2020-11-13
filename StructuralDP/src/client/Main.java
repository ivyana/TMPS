package client;

import domain.Muffin;
import domain.Product;
import domain.Snack;
import utilities.adapter.SnackAdapter;
import utilities.facade.BeverageCustomizer;
import utilities.factories.BeverageFactory;
import utilities.factories.CoffeeFactory;
import utilities.factories.TeaFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("\nChoose what you want to command:\n" +
                "* tea\n* coffee\n* coffee+'condiment'(milk/sugar/caramel)\n* snack\n");
        label:
        while (true) {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nSee menu for: (or enter (q) to exit)");
            String type = input.readLine();
            if (type.length() == 0)
                break;

            switch (type) {
                case "coffee":
                    BeverageFactory coffeeFactory = CoffeeFactory.getCoffeeFactory();
                    System.out.println(coffeeFactory.prepareBeverage("cappuccino").toString());
                    System.out.println(coffeeFactory.prepareBeverage("espresso").toString());
                    System.out.println(coffeeFactory.prepareBeverage("latte").toString());
                    break;
                case "tea":
                    BeverageFactory teaFactory = TeaFactory.getTeaFactory();
                    System.out.println(teaFactory.prepareBeverage("green tea").toString());
                    System.out.println(teaFactory.prepareBeverage("black tea").toString());
                    System.out.println(teaFactory.prepareBeverage("red tea").toString());
                    System.out.println(teaFactory.prepareBeverage("white tea").toString());
                    break;
                case "coffee+milk":
                    BeverageFactory mCoffeeFactory = CoffeeFactory.getCoffeeFactory();
                    BeverageCustomizer milkCustomizer = new BeverageCustomizer(mCoffeeFactory);
                    System.out.println(milkCustomizer.prepareCustomBeverage("cappuccino", "Milk", 35));
                    System.out.println(milkCustomizer.prepareCustomBeverage("espresso", "Milk", 25));
                    System.out.println(milkCustomizer.prepareCustomBeverage("latte", "Milk", 45));
                    break;
                case "coffee+sugar":
                    BeverageFactory sCoffeeFactory = CoffeeFactory.getCoffeeFactory();
                    BeverageCustomizer sugarCustomizer = new BeverageCustomizer(sCoffeeFactory);
                    System.out.println(sugarCustomizer.prepareCustomBeverage("cappuccino", "Sugar", 32));
                    System.out.println(sugarCustomizer.prepareCustomBeverage("espresso", "Sugar", 22));
                    System.out.println(sugarCustomizer.prepareCustomBeverage("latte", "Sugar", 42));
                    break;
                case "coffee+caramel":
                    BeverageFactory cCoffeeFactory = CoffeeFactory.getCoffeeFactory();
                    BeverageCustomizer caramelCustomizer = new BeverageCustomizer(cCoffeeFactory);
                    System.out.println(caramelCustomizer.prepareCustomBeverage("cappuccino", "Caramel", 37));
                    System.out.println(caramelCustomizer.prepareCustomBeverage("espresso", "Caramel", 27));
                    System.out.println(caramelCustomizer.prepareCustomBeverage("latte", "Caramel", 47));
                    break;
                case "snack":
                    Snack muffin = new Muffin();
                    Product adaptedMuffin = new SnackAdapter(muffin);
                    System.out.println(adaptedMuffin.toString());
                    break;
                case "q":
                    break label;
                default:
                    System.out.println("We don't have this product yet. Try another one:)");
                    break;
            }
        }
    }
}