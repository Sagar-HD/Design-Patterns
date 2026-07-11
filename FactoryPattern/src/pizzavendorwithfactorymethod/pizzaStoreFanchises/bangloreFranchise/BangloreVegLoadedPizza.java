package pizzavendorwithfactorymethod.pizzaStoreFanchises.bangloreFranchise;

import pizzavender.allPizzas.VegLoaded;
import pizzavender.constants.PizzaSize;

public class BangloreVegLoadedPizza extends VegLoaded {
    public BangloreVegLoadedPizza(PizzaSize size) {
        super(size);
    }

    @Override
    public String getPizzaName() {
        return super.getPizzaName()+"- banglore style";
    }
}
