# Lab1 - Topic: Beverage Shop - Author: Ivanciuc Iana (FAF - 181)

## Creational Design Patterns

In software engineering, a Design Pattern describes an established solution to the most commonly encountered problems in software design. 
It represents the best practices evolved over a long period through trial and error by experienced software developers.

Creational Design Patterns are concerned with the way in which objects are created. They reduce complexities and instability by creating objects in a controlled manner.

There are five types of Creational Design Pattern:

- Singleton – Ensures that at most only one instance of an object exists throughout application
- Factory Method – Creates objects of several related classes without specifying the exact object to be created
- Abstract Factory – Creates families of related dependent objects
- Builder – Constructs complex objects using step-by-step approach
- Prototype - Makes copies of existing objects without making the code dependent on their classes.

> In this laboratory work I used 4 out of 5 types: Singleton, Abstract Factory, Factory Method and Builder. 

## General
For this lab I choosed to simulate a beverage shop because it can cover the implementation of various design patterns and it can be easily extended.
For now I have two types of beverages(tea and coffee) and each of them has a factory method implemented(**TeaFactory** and **CoffeeFactory**). These two factories 
implement interface **Abstract Factory** which has only one method: *prepareBeverage()*. The factories are important because I have a lot of sub-classes
(**beverages** package) which choose the type of objects to create. Also, for all drinks I implemented builders(**builders** package) in order to separate the 
construction of a complex object from its representation so that the same construction process can create different representations. 

## Used Patterns
- [x] **Abstract Factory**: Provided a way to encapsulate CoffeeFactory and TeaFactory which have a common theme without specifying their concrete classes.
```java
public interface AbstractFactory {

    Beverage prepareBeverage(String name);

}
```

- [x] **Factory method**: Created CoffeeFactory and TeaFactory to generate object of concrete classes based on given information.
```java
public class CoffeeFactory implements AbstractFactory {
...
    public Beverage prepareBeverage(String name) {

        if(name == null){
            return null;
        }
        if(name.equalsIgnoreCase("CAPPUCCINO")){
            CappuccinoBuilder cappuccinoBuilder = new CappuccinoBuilder();
            barista.prepareCappuccino(cappuccinoBuilder);
            return cappuccinoBuilder.getBeverage();

        } else if(name.equalsIgnoreCase("ESPRESSO")){
            EspressoBuilder espressoBuilder = new EspressoBuilder();
            barista.prepareEspresso(espressoBuilder);
            return espressoBuilder.getBeverage();

        } else if(name.equalsIgnoreCase("LATTE")){
            LatteBuilder latteBuilder = new LatteBuilder();
            barista.prepareLatte(latteBuilder);
            return latteBuilder.getBeverage();
        }

        return null;
    }
}
```

- [x] **Singleton**: In CoffeeFactory and TeaFactory I used private static instances and private constructors to make sure that 
they can have only one object (an instance of the class) at a time.
```java
    private static CoffeeFactory coffeeFactory;
...
    public static CoffeeFactory getCoffeeFactory() {
        if(coffeeFactory == null)
            coffeeFactory = new CoffeeFactory();
        return coffeeFactory;
    }

    private CoffeeFactory() {}
```

- [x] **Builder:** In *builders* package I have the interface BeverageBuilder(abstract builder) which is an interface implemented by all other builders(concrete builders)
(ex. LatteBuilder, RedTeaBuilder, etc). These builders help me to build complex objects using simple objects and using a step by step approach.
```java
public interface BeverageBuilder {
    void create();
    void setName(String name);
    void setType(String type);
    void setPrice(float price);
}
...
public class LatteBuilder implements BeverageBuilder {

    private Latte latte;

    public LatteBuilder() {
        this.create();
    }

    @Override
    public void create() {
        this.latte = new Latte();
    }

    @Override
    public void setName(String name) {
        this.latte.setName(name);
    }

    @Override
    public void setType(String type) {
        this.latte.setType(type);
    }

    @Override
    public void setPrice(float price) {
        this.latte.setPrice(price);
    }

    public Latte getBeverage() {
        Latte beverage = this.latte;
        this.create();
        return beverage;
    }
}
```

## Output
Here I have the Barista class which acts like Builder Director - it controls the way Builder's functions are executed and Main class which print all things to the screen,
so we can have such an output:
```
Enter the type of beverage(coffee or tea) or (q) to exit:
coffee
*Cappuccino*
An espresso-based coffee drink that is traditionally prepared with steamed milk foam.
Price: 30.0, Category: Coffee

*Espresso*
A concentrated form of coffee served in small, strong shots.
Price: 20.0, Category: Coffee

*Latte*
A coffee drink made with espresso and steamed milk.
Price: 40.0, Category: Coffee


Enter the type of beverage(coffee or tea) or (q) to exit:
tea
*Green Tea*
A type of tea that is made from unoxidized Camellia sinensis leaves.
Price: 20.0, Category: Tea

*Black Tea*
A type of tea that is made from oxidized Camellia sinensis leaves with a strong flavor.
Price: 15.0, Category: Tea

*Red Tea*
A flavorful, caffeine-free alternative to black and green tea.
Price: 25.0, Category: Tea

*White Tea*
The most delicate tea made from young or minimally processed leaves of the Camellia sinensis plant.
Price: 30.0, Category: Tea


Enter the type of beverage(coffee or tea) or (q) to exit:
q
Process finished with exit code 0
```

## Conclusion
>Creational design patterns abstract the instantiation process. They help make a system independent of how its objects are created, composed, and represented. 
A class creational pattern uses inheritance to vary the class that's instantiated, whereas an object creational pattern will delegate instantiation to another object.
Creational patterns become important as systems evolve to depend more on object composition than class inheritance. As that happens, emphasis shifts away from 
hard-coding a fixed set of behaviors toward defining a smaller set of fundamental behaviors that can be composed into any number of more complex ones. 
Thus creating objects with particular behaviors requires more than simply instantiating a class.
