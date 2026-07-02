package ducks;

import AbstractDuck.Duck;

public class NormalDuck extends Duck {
    @Override
    public void display() {
        System.out.println("displaying normal duck");
    }
}
