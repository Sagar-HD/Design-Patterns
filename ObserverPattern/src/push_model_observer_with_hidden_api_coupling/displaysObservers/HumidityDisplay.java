package push_model_observer_with_hidden_api_coupling.displaysObservers;

import push_model_observer_with_hidden_api_coupling.interfaces.DisplayDevice;
import push_model_observer_with_hidden_api_coupling.interfaces.Observer;
import push_model_observer_with_hidden_api_coupling.interfaces.Subject;

public class HumidityDisplay implements Observer, DisplayDevice {
    private int humidity;
    private Subject weatherData;

    public HumidityDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.register(this);
    }

    @Override
    public void display() {
        System.out.println(" Humidity display :");
        System.out.println("humdity "+humidity);
    }

    @Override
    public void update(int temperature, int humidity) {
        this.humidity=humidity;
        display();

    }


}
