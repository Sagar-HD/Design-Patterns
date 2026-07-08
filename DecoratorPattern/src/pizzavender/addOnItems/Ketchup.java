package pizzavender.addOnItems;

import pizzavender.Pizza;
import pizzavender.PizzaDecorator;

public class Ketchup extends PizzaDecorator {

    public Ketchup(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return 2+this.pizza.getCost();
    }

    @Override
    public String getPizzaName() {
        return this.pizza.getPizzaName();
    }

}
