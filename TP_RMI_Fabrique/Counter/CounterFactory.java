import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CounterFactory extends Remote {
    Counter createCounter() throws RemoteException;
}
