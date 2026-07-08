package pizzavender.allPizzas;

import pizzavender.AbstractPizza;
import pizzavender.constants.PizzaSize;
import pizzavender.constants.PizzaType;

public class VideshiHotSauce extends AbstractPizza {

    public VideshiHotSauce(PizzaSize size) {
        super("videshi hot sauce", PizzaType.VEG,size);
    }

    @Override
    public int getCost() {
        PizzaSize size=this.getSize();
        if(size==PizzaSize.L){
            return 220;
        }else if(size==PizzaSize.M){
            return 200;
        }
        else{
            return 180;
        }
    }


}
