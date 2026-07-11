package pizzavendorwithfactorymethod.pizzaStoreFanchises.bangloreFranchise;

import pizzavender.Pizza;
import pizzavender.addOnItems.Cheese;
import pizzavender.addOnItems.Corn;
import pizzavender.addOnItems.Ketchup;
import pizzavender.allPizzas.VegLoaded;
import pizzavender.constants.PizzaSize;
import pizzavendorwithfactorymethod.AbstractPizzaStore;

public class BanglorePizzaStore extends AbstractPizzaStore {
    @Override
    public Pizza createPizza( int sizeType, int addOnType) {

      Pizza pizza=null;
        if (sizeType == 1) {
            pizza = new BangloreVegLoadedPizza(PizzaSize.S);
        } else if (sizeType == 2) {
            pizza = new BangloreVegLoadedPizza(PizzaSize.M);
        } else {
            pizza = new BangloreVegLoadedPizza(PizzaSize.L);
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
