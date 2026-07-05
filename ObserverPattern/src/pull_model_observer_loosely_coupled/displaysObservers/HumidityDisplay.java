package pull_model_observer_loosely_coupled.displaysObservers;

import pull_model_observer_loosely_coupled.interfaces.DisplayDevice;
import pull_model_observer_loosely_coupled.interfaces.Observer;
import pull_model_observer_loosely_coupled.interfaces.Subject;
import pull_model_observer_loosely_coupled.subjectWeatherData.WeatherData;

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
    public void update() {
        WeatherData wd=(WeatherData)weatherData;
        this.humidity=wd.getHumidity();

        display();

    }


}
