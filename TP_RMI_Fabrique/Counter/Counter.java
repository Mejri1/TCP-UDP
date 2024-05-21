import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Counter extends Remote {
    int getValue() throws RemoteException;
    void increment() throws RemoteException;
    void decrement() throws RemoteException;
}
