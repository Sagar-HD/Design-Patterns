package remoteProxy.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
//adding in shared to match package name
public interface Camera extends Remote {
    CaptureData getCapturedData() throws RemoteException;

}
