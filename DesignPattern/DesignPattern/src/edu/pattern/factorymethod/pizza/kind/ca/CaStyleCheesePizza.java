package edu.pattern.factorymethod.pizza.kind.ca;

import edu.pattern.factorymethod.pizza.kind.Pizza;

public class CaStyleCheesePizza extends Pizza {

    public CaStyleCheesePizza() {
        name = "캘리포니아 치즈피자";
        dough = "얇은 도우";
        toppings.add("불고기 토핑");
    }
}
