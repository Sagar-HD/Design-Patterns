package pizzavender;

import pizzavender.constants.PizzaSize;
import pizzavender.constants.PizzaType;

public abstract class AbstractPizza implements Pizza{
    protected String pizzaName;
   protected PizzaType type;
   protected PizzaSize size;

    public AbstractPizza(String pizzaName, PizzaType type,PizzaSize size) {
        this.pizzaName = pizzaName;
        this.type = type;
        this.size=size;
    }

    public  void display(){
        System.out.println("pizza name :"+this.pizzaName);
        System.out.println("pizza type :"+this.type+" size :"+this.size);
        System.out.println("pizza size :"+this.size);
        System.out.println("cost :"+this.getCost());

    };

    public String getPizzaName() {
        return pizzaName;
    }


    @Override
    public PizzaSize getSize() {
        return size;
    }


    @Override
    public PizzaType getType() {
        return type;
    }



}
