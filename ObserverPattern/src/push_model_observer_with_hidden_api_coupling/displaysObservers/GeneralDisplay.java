package push_model_observer_with_hidden_api_coupling.displaysObservers;

import push_model_observer_with_hidden_api_coupling.interfaces.DisplayDevice;
import push_model_observer_with_hidden_api_coupling.interfaces.Observer;
import push_model_observer_with_hidden_api_coupling.interfaces.Subject;

public class GeneralDisplay implements Observer, DisplayDevice {
    private int temperature;
    private int humidity;
    private Subject weatherData;

    public GeneralDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.register(this);
    }

    @Override
    public void update(int temperature, int humidity) {
        this.temperature=temperature;
        this.humidity=humidity;
        display();

    }



    @Override
    public void display() {
        System.out.println("General weather display ");
        System.out.println(" temp "+temperature+" humidity "+humidity);

    }
}
