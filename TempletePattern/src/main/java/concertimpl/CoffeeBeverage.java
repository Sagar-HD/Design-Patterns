package concertimpl;

import templete.CaffineBeverage;


public class CoffeeBeverage extends CaffineBeverage {
    @Override
    protected void brew() {
        System.out.println("Brewing coffee");

    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding milk and sugar");
    }
}
