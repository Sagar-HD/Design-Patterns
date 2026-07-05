package pull_model_observer_loosely_coupled.displaysObservers;

import pull_model_observer_loosely_coupled.interfaces.DisplayDevice;
import pull_model_observer_loosely_coupled.interfaces.Observer;
import pull_model_observer_loosely_coupled.interfaces.Subject;
import pull_model_observer_loosely_coupled.subjectWeatherData.WeatherData;

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
    public void update() {
        WeatherData wd=(WeatherData)weatherData;

        this.temperature=wd.getTemperature();
        display();

    }


}
