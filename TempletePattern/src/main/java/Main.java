import concertimpl.CoffeeBeverage;
import concertimpl.TeaBeverage;

public class Main {
    public static void main(String[] args) {
        CoffeeBeverage coffeeBeverage = new CoffeeBeverage();
        coffeeBeverage.prepare();

        TeaBeverage teaBeverage = new TeaBeverage();
        teaBeverage.prepare();
    }
}
