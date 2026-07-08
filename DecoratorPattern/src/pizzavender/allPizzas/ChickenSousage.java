package pizzavender.allPizzas;

import pizzavender.AbstractPizza;
import pizzavender.constants.PizzaSize;
import pizzavender.constants.PizzaType;

public class ChickenSousage extends AbstractPizza {
    public ChickenSousage(PizzaSize size) {
        super("chicken sausage", PizzaType.NONVEG, size);
    }

    @Override
    public int getCost() {
        PizzaSize size=this.getSize();
        if(size==PizzaSize.L){
            return 180;
        }else if(size==PizzaSize.M){
            return 150;
        }
        else{
            return 130;
        }
    }
}
