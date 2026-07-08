package pizzavender.addOnItems;

import pizzavender.Pizza;
import pizzavender.PizzaDecorator;
import pizzavender.constants.PizzaSize;

public class Corn extends PizzaDecorator {
    public Corn(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        PizzaSize size=getSize();
        if(size==PizzaSize.L){
            return 20+this.pizza.getCost();
        }else if(size==PizzaSize.M){
            return 15+this.pizza.getCost();
        }else{
            return 10+this.pizza.getCost();
        }

    }

    @Override
    public String getPizzaName() {
        return this.pizza.getPizzaName()+" + corn";
    }

}
