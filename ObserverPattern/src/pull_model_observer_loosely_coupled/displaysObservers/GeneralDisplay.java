package pull_model_observer_loosely_coupled.displaysObservers;


import pull_model_observer_loosely_coupled.interfaces.DisplayDevice;
import pull_model_observer_loosely_coupled.interfaces.Observer;
import pull_model_observer_loosely_coupled.interfaces.Subject;
import pull_model_observer_loosely_coupled.subjectWeatherData.WeatherData;

public class GeneralDisplay implements Observer, DisplayDevice {
    private int temperature;
    private int humidity;
    private Subject weatherData;

    public GeneralDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.register(this);
    }




    @Override
    public void display() {
        System.out.println("General weather display ");
        System.out.println(" temp "+temperature+" humidity "+humidity);

    }



    @Override
    public void update() {
        WeatherData wd=(WeatherData)weatherData;
        this.humidity=wd.getHumidity();
        this.temperature=wd.getTemperature();
        display();

    }
}
