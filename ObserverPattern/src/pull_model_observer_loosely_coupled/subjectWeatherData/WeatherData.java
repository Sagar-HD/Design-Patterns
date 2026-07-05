package pull_model_observer_loosely_coupled.subjectWeatherData;

import pull_model_observer_loosely_coupled.interfaces.Observer;
import pull_model_observer_loosely_coupled.interfaces.Subject;

import java.util.ArrayList;

public class WeatherData implements Subject {
    ArrayList<Observer> observers;
    private int temperature;
    private int humidity;

    public int getHumidity() {
        return humidity;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public int getTemperature() {
        return temperature;
    }

    public WeatherData() {
        this.observers =new ArrayList<>();
    }


    public void setChanges(int temperature,int humidity){
        this.temperature=temperature;
        this.humidity=humidity;
        notifyObservers();
    }
    @Override
    public void register(Observer observer) {
        this.observers.add(observer);

    }

    @Override
    public void notifyObservers() {
        for(Observer obs:this.observers){
            obs.update();
        }

    }

    @Override
    public void unRegister(Observer observer) {
        this.observers.remove(observer);

    }
}
