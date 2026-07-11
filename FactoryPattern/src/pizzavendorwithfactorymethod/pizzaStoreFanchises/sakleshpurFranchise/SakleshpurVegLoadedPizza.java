package pizzavendorwithfactorymethod.pizzaStoreFanchises.sakleshpurFranchise;

import pizzavender.allPizzas.VegLoaded;
import pizzavender.constants.PizzaSize;

public class SakleshpurVegLoadedPizza extends VegLoaded {
    public SakleshpurVegLoadedPizza(PizzaSize size) {
        super(size);
    }

    @Override
    public String getPizzaName() {
        return super.getPizzaName()+" -sakleshpur style";
    }
}
