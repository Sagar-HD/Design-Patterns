package pizzavendorwithfactorymethod;

import pizzavendorwithfactorymethod.pizzaStoreFanchises.bangloreFranchise.BanglorePizzaStore;
import pizzavendorwithfactorymethod.pizzaStoreFanchises.chikkamagalurFranchise.ChikkamagalurPizzaStore;
import pizzavendorwithfactorymethod.pizzaStoreFanchises.sakleshpurFranchise.SakleshpurPizzaStore;

public class App {
    public static void main(String[] args) {

        //i have just added default pizza type for all franchise that is veg loaded
        //only size and add on to be passes
        //it create the veg loaded pizza on its franchise style

        //the implementation comes from factory method that is implemented by concrete pizza stores
        //but the ordering logic will be same for all , only instances will depend on subclasses they all give pizza type as return

        AbstractPizzaStore pizzaStore=new SakleshpurPizzaStore();
        pizzaStore.getOrder(2,1);

        pizzaStore=new BanglorePizzaStore();
        pizzaStore.getOrder(1,2);

        pizzaStore=new ChikkamagalurPizzaStore();
        pizzaStore.getOrder(2,1);

    }
}
