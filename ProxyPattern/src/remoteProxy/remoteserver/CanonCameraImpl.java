package remoteProxy.remoteserver;

import remoteProxy.shared.Camera;
import remoteProxy.shared.CaptureData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class CanonCameraImpl extends UnicastRemoteObject implements Camera {

    protected CanonCameraImpl() throws RemoteException {
    }

    @Override
    public CaptureData getCapturedData() throws RemoteException {
       return new CaptureData(LocalDateTime.now(), "Your room in home ", "Sakleshpur");
    }
}
