package client;

import domain.Muffin;
import domain.Product;
import domain.Snack;
import utilities.adapter.SnackAdapter;
import utilities.facade.BeverageCustomizer;
import utilities.factories.BeverageFactory;
import utilities.factories.CoffeeFactory;
import utilities.factories.TeaFactory;
import utilities.strategy.DiscountContext;
import utilities.strategy.GoldDiscounter;
import utilities.strategy.SilverDiscounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("\nChoose what you want to command:\n* tea\n* coffee\n* snack\n");
        label:
        while (true) {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nSee menu for: (or enter (q) to exit)");

            String prod_type = input.readLine();
            if (prod_type.length() == 0)
                break;

            switch (prod_type) {
                case "coffee":
                    System.out.println("Do you want to add a condiment? (yes/no)");
                    String condiment = input.readLine();
                    if (condiment.length() == 0)
                        break;
                    switch (condiment) {
                        case "no" -> {
                            BeverageFactory coffeeFactory = CoffeeFactory.getCoffeeFactory();
                            System.out.println(coffeeFactory.prepareBeverage("cappuccino").toString());
                            System.out.println(coffeeFactory.prepareBeverage("espresso").toString());
                            System.out.println(coffeeFactory.prepareBeverage("latte").toString());
                        }
                        case "yes" -> {
                            System.out.println("Which type of condiment do you want? (milk/sugar/caramel)");
                            String cond_type = input.readLine();
                            if (cond_type.length() == 0)
                                break;
                            switch (cond_type) {
                                case "milk" -> {
                                    BeverageFactory mCoffeeFactory = CoffeeFactory.getCoffeeFactory();
                                    BeverageCustomizer milkCustomizer = new BeverageCustomizer(mCoffeeFactory);
                                    System.out.println(milkCustomizer.prepareCustomBeverage("cappuccino", "Milk", 35));
                                    System.out.println(milkCustomizer.prepareCustomBeverage("espresso", "Milk", 25));
                                    System.out.println(milkCustomizer.prepareCustomBeverage("latte", "Milk", 45));
                                }
                                case "sugar" -> {
                                    BeverageFactory sCoffeeFactory = CoffeeFactory.getCoffeeFactory();
                                    BeverageCustomizer sugarCustomizer = new BeverageCustomizer(sCoffeeFactory);
                                    System.out.println(sugarCustomizer.prepareCustomBeverage("cappuccino", "Sugar", 32));
                                    System.out.println(sugarCustomizer.prepareCustomBeverage("espresso", "Sugar", 22));
                                    System.out.println(sugarCustomizer.prepareCustomBeverage("latte", "Sugar", 42));
                                }
                                case "caramel" -> {
                                    BeverageFactory cCoffeeFactory = CoffeeFactory.getCoffeeFactory();
                                    BeverageCustomizer caramelCustomizer = new BeverageCustomizer(cCoffeeFactory);
                                    System.out.println(caramelCustomizer.prepareCustomBeverage("cappuccino", "Caramel", 37));
                                    System.out.println(caramelCustomizer.prepareCustomBeverage("espresso", "Caramel", 27));
                                    System.out.println(caramelCustomizer.prepareCustomBeverage("latte", "Caramel", 47));
                                }
                            }
                        }
                    }
                    break;

                case "tea":
                    System.out.println("Do you have a TeaDiscount Card? (yes/no)");
                    String discount = input.readLine();
                    if (discount.length() == 0)
                        break;
                    switch (discount) {
                        case "no" -> {
                            BeverageFactory teaFactory = TeaFactory.getTeaFactory();
                            System.out.println(teaFactory.prepareBeverage("green tea").toString());
                            System.out.println(teaFactory.prepareBeverage("black tea").toString());
                            System.out.println(teaFactory.prepareBeverage("red tea").toString());
                            System.out.println(teaFactory.prepareBeverage("white tea").toString());
                        }
                        case "yes" -> {
                            System.out.println("Which type of TeaDiscount Card do you have? (silver/gold)");
                            String disc_type = input.readLine();
                            if (disc_type.length() == 0)
                                break;
                            switch (disc_type) {
                                case "silver" -> {
                                    DiscountContext silverDiscount = new DiscountContext(new SilverDiscounter());
                                    BeverageFactory silverTeaFactory = TeaFactory.getTeaFactory();
                                    Product greenTeaS = silverTeaFactory.prepareBeverage("green tea");
                                    System.out.println(greenTeaS.toString());
                                    System.out.println("Silver discount price: " + silverDiscount.executeStrategy(greenTeaS.getPrice()) + "\n");
                                    Product blackTeaS = silverTeaFactory.prepareBeverage("black tea");
                                    System.out.println(blackTeaS.toString());
                                    System.out.println("Silver discount price: " + silverDiscount.executeStrategy(blackTeaS.getPrice()) + "\n");
                                    Product redTeaS = silverTeaFactory.prepareBeverage("red tea");
                                    System.out.println(redTeaS.toString());
                                    System.out.println("Silver discount price: " + silverDiscount.executeStrategy(redTeaS.getPrice()) + "\n");
                                    Product whiteTeaS = silverTeaFactory.prepareBeverage("white tea");
                                    System.out.println(whiteTeaS.toString());
                                    System.out.println("Silver discount price: " + silverDiscount.executeStrategy(whiteTeaS.getPrice()) + "\n");
                                }

                                case "gold" -> {
                                    DiscountContext goldDiscount = new DiscountContext(new GoldDiscounter());
                                    BeverageFactory goldTeaFactory = TeaFactory.getTeaFactory();
                                    Product greenTeaG = goldTeaFactory.prepareBeverage("green tea");
                                    System.out.println(greenTeaG.toString());
                                    System.out.println("Gold discount price: " + goldDiscount.executeStrategy(greenTeaG.getPrice()) + "\n");
                                    Product blackTeaG = goldTeaFactory.prepareBeverage("black tea");
                                    System.out.println(blackTeaG.toString());
                                    System.out.println("Gold discount price: " + goldDiscount.executeStrategy(blackTeaG.getPrice()) + "\n");
                                    Product redTeaG = goldTeaFactory.prepareBeverage("red tea");
                                    System.out.println(redTeaG.toString());
                                    System.out.println("Gold discount price: " + goldDiscount.executeStrategy(redTeaG.getPrice()) + "\n");
                                    Product whiteTeaG = goldTeaFactory.prepareBeverage("white tea");
                                    System.out.println(whiteTeaG.toString());
                                    System.out.println("Gold discount price: " + goldDiscount.executeStrategy(whiteTeaG.getPrice()) + "\n");
                                }
                            }
                        }
                    }
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