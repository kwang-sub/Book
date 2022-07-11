package edu.pattern.factorymethod.pizza.kind.ny;

import edu.pattern.factorymethod.pizza.kind.Pizza;

public class NYStyleCheesePizza extends Pizza {

    public NYStyleCheesePizza() {
        name = "뉴욕 스타일 소스와 치즈피자";
        dough = "씬 크러스트 도우";
        sauce = "마리나라 소스";

        toppings.add("잘게 썬 레지아노 치즈");
    }
}
