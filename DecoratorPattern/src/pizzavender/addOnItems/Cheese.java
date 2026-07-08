package pizzavender.addOnItems;

import pizzavender.Pizza;
import pizzavender.PizzaDecorator;
import pizzavender.constants.PizzaSize;

public class Cheese extends PizzaDecorator {

    public Cheese(Pizza pizza) {
        super(pizza);
    }
    @Override
    public int getCost() {
        PizzaSize size=getSize();
        if(size==PizzaSize.L){
            return 15+this.pizza.getCost();

        } else if (size==PizzaSize.M) {
            return 10+this.pizza.getCost();

        }else{
            return 5+this.pizza.getCost();
        }

    }

    @Override
    public String getPizzaName() {
        return this.pizza.getPizzaName()+" + cheese";
    }


}
