package pizzavendorwithSimplefactory;

import pizzavender.Pizza;

public class PizzaShop {
    private  SimplePizzaFactory factory;
    public PizzaShop(SimplePizzaFactory factory) {
        this.factory = factory;
    }
     void getOrder(int pizzaType, int sizeType, int addOnType){

        Pizza pizza= factory.preparePizza(pizzaType, sizeType, addOnType);
        pizza.display();

    }

    public static void main(String[] args) {
        //i have just add jar file from decorator where pizza logic is written
        //all pizza interfaces , classes , enum and decorators are used from decorator jar file



        //created a simple pizza factory just moved the code which is changed frequently into pizza factory
        //by this any new changes need not to be done in pizza shop but changes are done in pizza factory
        PizzaShop pizzaShop=new PizzaShop(new SimplePizzaFactory());

        pizzaShop.getOrder(1, 1, 1);
        pizzaShop.getOrder(2, 2, 2);

        //in this simple factory we cant add another type of factory
        //and create pizza making process may differ from store to store
        // so we need an abstract store which doesnt know about pizza making process
        //we will be having an interface for factory and we call factory.createPizza in abstract store
        // the concrete store will decide the factory they want by passing in contructor
        //by this we can code to abstract store means we can use abstractStore ref and call order method


    }
}
