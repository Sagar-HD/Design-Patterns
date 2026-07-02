import AbstractDuck.Duck;
import ducks.NormalDuck;
import family_of_flyable_algorithms.DuckFly;
import family_of_flyable_algorithms.LuffyDuck;
import family_of_quakable_algorithm.DuckQuak;
import family_of_quakable_algorithm.WeirdQuak;

public class PondOfDucks {
    public static void main(String[] args) {
        Duck duck = new NormalDuck();
        duck.setFlyBehavior(new DuckFly());
        duck.setQuackBehavior(new DuckQuak());
        duck.performFly();
        duck.performQuack();

        //now lets giv e our normal duck a luffy fly and weird quak

        duck.setFlyBehavior(new LuffyDuck());
        duck.setQuackBehavior(new WeirdQuak());
        duck.performFly();
        duck.performQuack();


        //all code that to call duck is kept in abstract class and inherited
        //all code which may differ duck by duck and may change on time is kept as interface and given some implementation
        //the differable and changable code is abtracted in abstract parent class using interface

    }
}
