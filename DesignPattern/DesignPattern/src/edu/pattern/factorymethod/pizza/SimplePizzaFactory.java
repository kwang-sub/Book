package edu.pattern.factorymethod.pizza;

import edu.pattern.factorymethod.pizza.kind.*;
import edu.pattern.factorymethod.pizza.kind.base.CheesePizza;
import edu.pattern.factorymethod.pizza.kind.base.ClamPizza;
import edu.pattern.factorymethod.pizza.kind.base.PepperoniPizza;
import edu.pattern.factorymethod.pizza.kind.base.veggiePizza;

public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")){
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new veggiePizza();
        }

        return pizza;
    }
}
