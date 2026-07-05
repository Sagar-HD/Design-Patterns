package push_model_observer_with_hidden_api_coupling;

import push_model_observer_with_hidden_api_coupling.displaysObservers.GeneralDisplay;
import push_model_observer_with_hidden_api_coupling.displaysObservers.HumidityDisplay;
import push_model_observer_with_hidden_api_coupling.displaysObservers.TemperatureDisplay;
import push_model_observer_with_hidden_api_coupling.interfaces.DisplayDevice;
import push_model_observer_with_hidden_api_coupling.interfaces.Observer;
import push_model_observer_with_hidden_api_coupling.subject_weatherData.WeatherData;

public class WeatherBroadcaster {
    public static void main(String[] args) {
        WeatherData weatherData=new WeatherData();
        DisplayDevice device1=new GeneralDisplay(weatherData);
        DisplayDevice device2=new HumidityDisplay(weatherData);
        DisplayDevice device3=new TemperatureDisplay(weatherData);

        weatherData.setChanges(100,200);

        Observer observer=(Observer) device1;
       weatherData.unRegister(observer);

        weatherData.setChanges(24,12);


    }

}
