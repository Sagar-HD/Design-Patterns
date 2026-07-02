package AbstractDuck;

import family_of_flyable_algorithms.Flyable;
import family_of_quakable_algorithm.Quakable;

public abstract class Duck {

    protected Flyable flyBehavior;
    protected Quakable quackBehavior;

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float!");
    }

    public abstract void display();

    public void setFlyBehavior(Flyable flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(Quakable quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}