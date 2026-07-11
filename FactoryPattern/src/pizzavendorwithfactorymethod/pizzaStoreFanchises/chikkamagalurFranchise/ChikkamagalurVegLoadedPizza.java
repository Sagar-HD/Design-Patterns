package pizzavendorwithfactorymethod.pizzaStoreFanchises.chikkamagalurFranchise;

import pizzavender.allPizzas.VegLoaded;
import pizzavender.constants.PizzaSize;

public class ChikkamagalurVegLoadedPizza extends VegLoaded {
    public ChikkamagalurVegLoadedPizza(PizzaSize size) {
        super(size);
    }
    @Override
    public String getPizzaName() {
        return super.getPizzaName()+"- chikkamagalur style";
    }
}
