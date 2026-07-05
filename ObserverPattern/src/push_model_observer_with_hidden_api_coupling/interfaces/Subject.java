package push_model_observer_with_hidden_api_coupling.interfaces;

public interface Subject {
    void register(Observer observer);
    void notifyObservers();
    void unRegister(Observer observer);
}
