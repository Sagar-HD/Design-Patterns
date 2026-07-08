package pizzavender;

import pizzavender.constants.PizzaSize;
import pizzavender.constants.PizzaType;

public abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;


    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }


    @Override
    public PizzaSize getSize() {
        return pizza.getSize();
    }

    @Override
    public PizzaType getType() {
        return pizza.getType();
    }
    @Override
    public void display() {
        System.out.println("pizza name :"+getPizzaName());
        System.out.println("pizza type :"+getType());
        System.out.println("pizza size :"+getSize());
        System.out.println("cost :"+getCost());

    }

}
