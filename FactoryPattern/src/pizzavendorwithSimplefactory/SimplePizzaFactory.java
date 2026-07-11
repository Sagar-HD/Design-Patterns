package pizzavendorwithSimplefactory;

import pizzavender.Pizza;
import pizzavender.addOnItems.Cheese;
import pizzavender.addOnItems.Corn;
import pizzavender.addOnItems.Ketchup;
import pizzavender.allPizzas.VegLoaded;
import pizzavender.allPizzas.VideshiHotSauce;
import pizzavender.constants.PizzaSize;

public class SimplePizzaFactory {
    public static Pizza preparePizza(int pizzaType, int sizeType, int addOnType) {
        if (pizzaType == 1) {
            Pizza pizza = null;
            if (sizeType == 1) {
                pizza = new VegLoaded(PizzaSize.S);
            } else if (sizeType == 2) {
                pizza = new VegLoaded(PizzaSize.M);
            } else {
                pizza = new VegLoaded(PizzaSize.L);
            }

            if (addOnType == 1) {
                pizza = new Cheese(pizza);
            } else if (addOnType == 2) {
                pizza = new Corn(pizza);
            } else if (addOnType == 3) {
                pizza = new Ketchup(pizza);
            }

            return pizza;
        } else if (pizzaType == 2) {
            Pizza pizza = null;
            if (sizeType == 1) {
                pizza = new VideshiHotSauce(PizzaSize.S);
            } else if (sizeType == 2) {
                pizza = new VideshiHotSauce(PizzaSize.M);
            } else {
                pizza = new VideshiHotSauce(PizzaSize.L);
            }

            if (addOnType == 1) {
                pizza = new Cheese(pizza);
            } else if (addOnType == 2) {
                pizza = new Corn(pizza);
            } else if (addOnType == 3) {
                pizza = new Ketchup(pizza);
            }
            return pizza;
        }
return null;
    }
}