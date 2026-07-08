package pizzavender;

import pizzavender.constants.PizzaSize;
import pizzavender.constants.PizzaType;

public interface Pizza {

     int getCost();
     PizzaSize getSize();
     PizzaType getType();
     String getPizzaName();
     void display();


}
