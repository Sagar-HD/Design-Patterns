package pizzavendorwithfactorymethod.pizzaStoreFanchises.sakleshpurFranchise;

import pizzavender.Pizza;
import pizzavender.addOnItems.Cheese;
import pizzavender.addOnItems.Corn;
import pizzavender.addOnItems.Ketchup;
import pizzavender.constants.PizzaSize;
import pizzavendorwithfactorymethod.AbstractPizzaStore;

public class SakleshpurPizzaStore extends AbstractPizzaStore {
    @Override
    public Pizza createPizza(int sizeType, int addOnType) {
        Pizza pizza=null;
        if (sizeType == 1) {
            pizza = new SakleshpurVegLoadedPizza(PizzaSize.S);
        } else if (sizeType == 2) {
            pizza = new SakleshpurVegLoadedPizza(PizzaSize.M);
        } else {
            pizza = new SakleshpurVegLoadedPizza(PizzaSize.L);
        }

        if (addOnType == 1) {
            pizza = new Cheese(pizza);
        } else if (addOnType == 2) {
            pizza = new Corn(pizza);
        } else if (addOnType == 3) {
            pizza = new Ketchup(pizza);
        }
        return  pizza;
    }
    }

