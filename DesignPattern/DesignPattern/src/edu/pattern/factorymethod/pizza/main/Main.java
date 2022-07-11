package edu.pattern.factorymethod.pizza.main;

import edu.pattern.factorymethod.pizza.kind.Pizza;
import edu.pattern.factorymethod.pizza.kind.ch.ChStyleCheesePizza;
import edu.pattern.factorymethod.pizza.store.CaliforniaPizzaStore;
import edu.pattern.factorymethod.pizza.store.ChicagoPizzaStore;
import edu.pattern.factorymethod.pizza.store.NYPizzaStore;
import edu.pattern.factorymethod.pizza.store.PizzaStore;

public class Main {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        PizzaStore caStore = new CaliforniaPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("에단이 주문한 " + pizza.getName());
        System.out.println();

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("조엘이 주문한 " + pizza.getName());
        System.out.println();
        pizza = caStore.orderPizza("cheese");
        System.out.println("캘리포니아 : " + pizza.getName());
    }
}
