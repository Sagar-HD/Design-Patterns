package push_model_observer_with_hidden_api_coupling.displaysObservers;

import push_model_observer_with_hidden_api_coupling.interfaces.DisplayDevice;
import push_model_observer_with_hidden_api_coupling.interfaces.Observer;
import push_model_observer_with_hidden_api_coupling.interfaces.Subject;

public class TemperatureDisplay implements Observer, DisplayDevice {
    private int temperature;
    private Subject weatherData;

    public TemperatureDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.register(this);

    }

    @Override
    public void display() {
        System.out.println("temperature display :");
        System.out.println("temperature "+temperature);
    }

    @Override
    public void update(int temperature, int humidity) {
        this.temperature=temperature;
        display();

    }


}
