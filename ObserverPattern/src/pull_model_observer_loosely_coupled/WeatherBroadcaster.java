package pull_model_observer_loosely_coupled;

import pull_model_observer_loosely_coupled.displaysObservers.GeneralDisplay;
import pull_model_observer_loosely_coupled.displaysObservers.HumidityDisplay;
import pull_model_observer_loosely_coupled.displaysObservers.TemperatureDisplay;
import pull_model_observer_loosely_coupled.interfaces.DisplayDevice;
import pull_model_observer_loosely_coupled.interfaces.Observer;
import pull_model_observer_loosely_coupled.subjectWeatherData.WeatherData;

public class WeatherBroadcaster {
    public static void main(String[] args) {
        WeatherData weatherData=new WeatherData();
        DisplayDevice device1=new GeneralDisplay(weatherData);
        DisplayDevice device2=new HumidityDisplay(weatherData);
        DisplayDevice device3=new TemperatureDisplay(weatherData);

        weatherData.setChanges(100,200);

        weatherData.unRegister((Observer)device1);

        weatherData.setChanges(24,12);
    }
}
