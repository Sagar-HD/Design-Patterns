package pizzavender.allPizzas;

import pizzavender.AbstractPizza;
import pizzavender.constants.PizzaSize;
import pizzavender.constants.PizzaType;

public class VegLoaded extends AbstractPizza {
    public VegLoaded( PizzaSize size) {
        super("veg loaded",PizzaType.VEG, size);
    }

    @Override
    public int getCost() {
        PizzaSize size=this.getSize();
        if(size==PizzaSize.L){
            return 200;
        }else if(size==PizzaSize.M){
            return 180;
        }
        else{
            return 150;
        }

    }
}
