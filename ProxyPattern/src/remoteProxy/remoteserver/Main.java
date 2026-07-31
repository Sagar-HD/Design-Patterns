package remoteProxy.remoteserver;

import remoteProxy.shared.Camera;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        try {
            Camera camera = new CanonCameraImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Camera", camera);
            System.out.println("Server started ans listening in rmi://localhost:1099");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
