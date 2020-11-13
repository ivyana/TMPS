# Lab2 - Author: Ivanciuc Iana (FAF - 181)

## Structural Design Patterns

In software engineering, a Design Pattern describes an established solution to 
the most commonly encountered problems in software design. 
It represents the best practices evolved over a long period through trial and error by experienced software developers.

Structural Design Patterns explain how to assemble objects and classes 
into larger structures while keeping these structures flexible and efficient.

Structural Design Pattern Representatives are the following:

- Adapter – Allows objects with incompatible interfaces to collaborate.
- Bridge – Lets you split a large class or a set of closely related classes into two separate hierarchies—abstraction 
and implementation—which can be developed independently of each other.
- Composite – Lets you compose objects into tree structures and then work with these structures 
as if they were individual objects.
- Decorator – Lets you attach new behaviors to objects by placing these objects inside
special wrapper objects that contain the behaviors.
- Facade - Provides a simplified interface to a library, a framework, or any other complex set of classes.
- Flyweight - Lets you fit more objects into the available amount of RAM 
by sharing common parts of state between multiple objects instead of keeping all of the data in each object.
- Proxy - Lets you provide a substitute or placeholder for another object. A proxy controls access to the original 
object, allowing you to perform something either before or after the request gets through to the original object.

> In this laboratory work I used: Decorator, Facade and Adapter. 

## General
For this lab I continued the simulation of a beverage shop, but besides *tea* and *coffee* entities I added *coffee 
condiments* in order to implement **Decorator** and **Facade** patterns. Also, I created a new product - *muffin* in order
to reflect **Adapter** pattern. 


## Used Patterns
- [x] **Decorator**: For this design pattern I created an abstract decorator class named
*BeverageDecorator* implementing the *BeverageFactory* interface. Also, I have *CondimentDecorator* 
which is a concrete class extending *BeverageDecorator*. In such a way, I can add condiments to different
types of coffee and change their prices dynamically. 
```java
public class BeverageDecorator implements BeverageFactory {

    protected BeverageFactory decoratedBeverage;

    public BeverageDecorator(BeverageFactory decoratedBeverage) {
        this.decoratedBeverage = decoratedBeverage;
    }

    public Product prepareBeverage(String name) {
        return decoratedBeverage.prepareBeverage(name);
    }

}
...
public class CondimentDecorator extends BeverageDecorator {

    private final String customCondiment;

    public CondimentDecorator(BeverageFactory decoratedBeverage, String customCondiment) {
        super(decoratedBeverage);
        this.customCondiment= customCondiment;
    }

    @Override
    public Product prepareBeverage(String name) {
        Product product = super.prepareBeverage(name);
        product.setCondiment(this.customCondiment);
        return product;
    }

}
```

- [x] **Facade**: Here, I created a **Facade** class named *BeverageCustomizer* which is a simple and top-level 
interface for the client. It allows to access the **Decorators** with the help of *prepareCustomBeverage* method, 
without knowing any of the system logic and inner-workings.
```java
public class BeverageCustomizer {

    private final BeverageFactory decoratedBeverage;

    public BeverageCustomizer(BeverageFactory decoratedBeverage) {

        this.decoratedBeverage = decoratedBeverage;
    }

    public Product prepareCustomBeverage(String name, String customCondiment, float price) {
        BeverageDecorator customizer = new CondimentDecorator(decoratedBeverage, customCondiment);
        Product customProduct = customizer.prepareBeverage(name);
        customProduct.setPrice(price);
        return customProduct;
    }
}
...
System.out.println(caramelCustomizer.prepareCustomBeverage("cappuccino", "Caramel", 37));
```

- [x] **Adapter**: For this pattern, I added a new interface *Snack*(named adaptee) which is an incompatible one 
that needs adapting. The target is *Product* interface that clients communicate with. In order to have a link between target
and adaptee I created an adapter - *SnackAdapter*. 
```java
Snack muffin = new Muffin();
Product adaptedMuffin = new SnackAdapter(muffin);
System.out.println(adaptedMuffin.toString());
```


## Output
Here, you can see the output for simple coffee and for coffee+caramel(decorated). In the second one, there are some 
changes like condiment parameter and price which were made dynamically. Also, the information about snacks is received
using an adapter(*SnackAdapter*). Instead of *Snack* interface(adaptee), I used *Product* interface(target). 
```
Choose what you want to command:
* tea
* coffee
* coffee+'condiment'(milk/sugar/caramel)
* snack


See menu for: (or enter (q) to exit)
coffee
*Cappuccino*
An espresso-based coffee drink that is traditionally prepared with steamed milk foam.
Price: 30.0, Category: Coffee, Condiment: No.

*Espresso*
A concentrated form of coffee served in small, strong shots.
Price: 20.0, Category: Coffee, Condiment: No.

*Latte*
A coffee drink made with espresso and steamed milk.
Price: 40.0, Category: Coffee, Condiment: No.


See menu for: (or enter (q) to exit)
coffee+caramel
*Cappuccino*
An espresso-based coffee drink that is traditionally prepared with steamed milk foam.
Price: 37.0, Category: Coffee, Condiment: Caramel.

*Espresso*
A concentrated form of coffee served in small, strong shots.
Price: 27.0, Category: Coffee, Condiment: Caramel.

*Latte*
A coffee drink made with espresso and steamed milk.
Price: 47.0, Category: Coffee, Condiment: Caramel.


See menu for: (or enter (q) to exit)
snack
*Muffin* 
Price: 15.0.

```

## Conclusion
>To sum up, Structural Design Patterns are concerned with how classes and objects can be composed, to form larger structures. 
They enable you to create systems without rewriting or customizing the code because these patterns provide the system 
with enhanced reusability and robust functionality. Structural patterns affect applications in a variety of ways, 
for example, the Adapter pattern enables two incompatible systems to communicate, whereas the Facade pattern enables 
you to present a simplified interface to a user without removing all the options available in the system. Also, 
the Decorator pattern can be used to add responsibilities to objects dynamically. That is why I chose namely these.
