package edu.pattern.factorymethod.pizza.store;

import edu.pattern.factorymethod.pizza.kind.*;
import edu.pattern.factorymethod.pizza.kind.ny.NYStyleCheesePizza;
import edu.pattern.factorymethod.pizza.kind.ny.NYStyleClamPizza;
import edu.pattern.factorymethod.pizza.kind.ny.NYStylePepperoniPizz;
import edu.pattern.factorymethod.pizza.kind.ny.NYStyleVeggiePizza;

public class NYPizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (item.equals("veggie")) {
            return new NYStyleVeggiePizza();
        } else if (item.equals("clam")) {
            return new NYStyleClamPizza();
        } else if (item.equals("pepperoni")) {
            return new NYStylePepperoniPizz();
        } else return null;
    }
}
