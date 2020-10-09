import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        label:
        while (true) {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nEnter the type of beverage(coffee or tea) or (q) to exit:");
            String type = input.readLine();
            if (type.length() == 0)
                break;

            switch (type) {
                case "coffee":
                    AbstractFactory coffeeFactory = CoffeeFactory.getCoffeeFactory();
                    System.out.println(coffeeFactory.prepareBeverage("cappuccino").toString());
                    System.out.println(coffeeFactory.prepareBeverage("espresso").toString());
                    System.out.println(coffeeFactory.prepareBeverage("latte").toString());
                    break;
                case "tea":
                    AbstractFactory teaFactory = TeaFactory.getTeaFactory();
                    System.out.println(teaFactory.prepareBeverage("green tea").toString());
                    System.out.println(teaFactory.prepareBeverage("black tea").toString());
                    System.out.println(teaFactory.prepareBeverage("red tea").toString());
                    System.out.println(teaFactory.prepareBeverage("white tea").toString());
                    break;
                case "q":
                    break label;
                default:
                    System.out.println("We don't have such type of beverage.");
                    break;
            }
        }
    }
}