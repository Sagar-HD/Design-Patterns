package push_model_observer_with_hidden_api_coupling.subject_weatherData;

import push_model_observer_with_hidden_api_coupling.interfaces.Observer;
import push_model_observer_with_hidden_api_coupling.interfaces.Subject;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private int temperature;
    private int humidity;
    ArrayList<Observer> observers;

    public WeatherData() {
        this.observers=new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer obs:this.observers){
            obs.update(this.temperature,this.humidity);

        }

    }

    public void setChanges(int temperature, int humudity) {
        this.temperature=temperature;
        this.humidity=humudity;
        notifyObservers();

    }

    @Override
    public void unRegister(Observer observer) {
    observers.remove(observer);

    }
}
