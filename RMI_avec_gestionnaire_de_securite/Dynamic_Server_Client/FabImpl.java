package src.Fabrique;
import src.client.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import src.Server.AppInterface;
import src.Fabrique.Reverse;
public class FabImpl extends UnicastRemoteObject implements FabInterface {
    public FabImpl() throws RemoteException {
        // Constructeur par défaut
    }

    @Override
    public AppInterface newReverse() throws RemoteException {
        return new Reverse();
    }
}
