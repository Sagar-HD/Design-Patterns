package remoteProxy.client;

import remoteProxy.shared.Camera;
import remoteProxy.shared.CaptureData;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MyMobile {
    public static void main(String[] args) {
        System.out.println("accessing in my Mobile");
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry("localhost", 1099);
            Camera camera = (Camera) registry.lookup("Camera");
            //just trying new concept i learnt executor service

            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
            //so this creates a scheduled thread that runs every 2 seconds the callable task i gave
            //it gives a completable future but i want every 2 seconds new data so iam printing in task itself
             executorService.scheduleAtFixedRate(
                    () -> {
                        try {
                            CaptureData data=camera.getCapturedData();
                            System.out.println("Data captured at " + data.getTimestamp() );
                            System.out.println("Data : " + data.getData());
                            System.out.println("Location : " + data.getLocation());
                            System.out.println("--------------------------------");

                        } catch (RemoteException e) {
                            throw new RuntimeException(e);
                        }
                    },
                    2,
                    2,
                    TimeUnit.SECONDS
            );



            // Stop after 10 seconds
            executorService.schedule(() -> {
                System.out.println("Yoo successfully invoked method from different jvm");
                System.out.println("Stopping...");
                executorService.shutdown();
            }, 10, TimeUnit.SECONDS);

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }



    }
}
