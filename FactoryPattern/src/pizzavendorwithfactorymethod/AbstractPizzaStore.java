package pizzavendorwithfactorymethod;


import pizzavender.Pizza;

public abstract class AbstractPizzaStore {
    public void getOrder( int sizeType, int addOnType){
        Pizza pizza=createPizza(sizeType,addOnType);
        pizza.display();

    }
   public abstract Pizza createPizza( int sizeType, int addOnType);

}
