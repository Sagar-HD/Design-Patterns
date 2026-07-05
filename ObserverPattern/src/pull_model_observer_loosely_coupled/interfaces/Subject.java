package pull_model_observer_loosely_coupled.interfaces;

public interface Subject {
    void register(Observer observer);
    void notifyObservers();
    void unRegister(Observer observer);
}
