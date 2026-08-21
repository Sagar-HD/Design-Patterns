package concertimpl;

import templete.CaffineBeverage;

import java.util.Scanner;

public class TeaBeverage extends CaffineBeverage {
    @Override
    protected void brew() {
        System.out.println("Brewing tea");
    }
    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
    @Override
    public boolean hook() {
        Scanner sc=new Scanner(System.in);
        System.out.println(" do you want to add lemon (y/n)");
        try {
            boolean input = sc.nextBoolean();
            return input;
        }
        catch (Exception e) {
            return false;
        }

    }

}
