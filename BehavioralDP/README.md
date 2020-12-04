# Lab3 - Author: Ivanciuc Iana (FAF - 181)

## Behavioral Design Patterns

In software engineering, a Design Pattern describes an established solution to 
the most commonly encountered problems in software design. 
It represents the best practices evolved over a long period through trial and error by experienced software developers.

Behavioral design patterns are concerned with algorithms and the assignment of responsibilities between objects.

Some of Behavioral Design Pattern Representatives are the following:
- Chain of Responsibility - Lets you pass requests along a chain of handlers. Upon receiving a request, each handler 
decides either to process the request or to pass it to the next handler in the chain.
- Command - Turns a request into a stand-alone object that contains all information about the request. This 
transformation lets you parameterize methods with different requests, delay or queue a request's execution, 
and support undoable operations.
- Iterator - Lets you traverse elements of a collection without exposing its underlying representation 
(list, stack, tree, etc.).
- Mediator - Lets you reduce chaotic dependencies between objects. The pattern restricts direct communications 
between the objects and forces them to collaborate only via a mediator object.
- Memento - Lets you save and restore the previous state of an object without revealing the details of its 
implementation.
- Observer - Lets you define a subscription mechanism to notify multiple objects about any events that happen to 
the object they're observing.
- State - Lets an object alter its behavior when its internal state changes. It appears as if the object changed 
its class.
- Strategy -Lets you define a family of algorithms, put each of them into a separate class, and make their objects 
interchangeable.
- Template - Defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps 
of the algorithm without changing its structure.
- Visitor - Lets you separate algorithms from the objects on which they operate.

> In this laboratory work I used **Strategy**. 

## General
For this lab, I finished the simulation of a beverage shop (more exactly - of its menu). I changed the Main program 
in such a way that a client could use every representative of implemented DPs. For example, if a client chooses
to order a coffee, he will be asked if he wants some condiments (*Decorator*) or if he chooses a tea, he will be
asked if he has a discount card and its type (*Strategy*).


## Used Pattern

- [x] **Strategy**: In order to implement this design pattern, I created a Strategy interface (*Discounter*) defining an action and 
concrete strategy classes implementing the Strategy interface (*SilverDiscounter* and *GoldDiscounter*). 
*DiscountContext* is a class which uses a Strategy.
In the Main, I used *DiscountContext* and strategy objects to demonstrate change in *DiscountContext* behaviour 
based on strategy it deploys or uses.
```java
public interface Discounter {
    float applyDiscount(float price);
}

...

public class SilverDiscounter implements Discounter {
    @Override
    public float applyDiscount(float price) {
    return (float) (price * 0.8);
    }
}

...

public class GoldDiscounter implements Discounter {
    @Override
    public float applyDiscount(float price) {
    return (float) (price * 0.5);
    }
}

...

public class DiscountContext {
    private final Discounter discounter;

    public DiscountContext(Discounter discounter){
        this.discounter = discounter;
    }

    public float executeStrategy(float price){
        return discounter.applyDiscount(price);
    }
}
```


## Output
Here, you can see the output for simple tea and for tea if the client has a TeaDiscount Card. In the second one, 
is dynamically added a new price which corresponds with the applied strategy(in this example: SilverDiscounter). 
```
Choose what you want to command:
* tea
* coffee
* snack


See menu for: (or enter (q) to exit)
tea
Do you have a TeaDiscount Card? (yes/no)
no
*Green Tea*
A type of tea that is made from unoxidized Camellia sinensis leaves.
Price: 20.0, Category: Tea, Condiment: No.

*Black Tea*
A type of tea that is made from oxidized Camellia sinensis leaves with a strong flavor.
Price: 15.0, Category: Tea, Condiment: No.

*Red Tea*
A flavorful, caffeine-free alternative to black and green tea.
Price: 25.0, Category: Tea, Condiment: No.

*White Tea*
The most delicate tea made from young or minimally processed leaves of the Camellia sinensis plant.
Price: 30.0, Category: Tea, Condiment: No.


See menu for: (or enter (q) to exit)
tea
Do you have a TeaDiscount Card? (yes/no)
yes
Which type of TeaDiscount Card do you have? (silver/gold)
silver
*Green Tea*
A type of tea that is made from unoxidized Camellia sinensis leaves.
Price: 20.0, Category: Tea, Condiment: No.

Silver discount price: 16.0

*Black Tea*
A type of tea that is made from oxidized Camellia sinensis leaves with a strong flavor.
Price: 15.0, Category: Tea, Condiment: No.

Silver discount price: 12.0

*Red Tea*
A flavorful, caffeine-free alternative to black and green tea.
Price: 25.0, Category: Tea, Condiment: No.

Silver discount price: 20.0

*White Tea*
The most delicate tea made from young or minimally processed leaves of the Camellia sinensis plant.
Price: 30.0, Category: Tea, Condiment: No.

Silver discount price: 24.0
```

## Conclusion
>To sum up, Behavioral design patterns are concerned with the interaction and responsibility of objects. In these 
design patterns,the interaction between the objects should be in such a way that they can easily talk to each other 
and still should be loosely coupled. That means the implementation and the client should be loosely coupled in order 
to avoid hard coding and dependencies.
