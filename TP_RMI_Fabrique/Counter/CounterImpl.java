import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CounterImpl extends UnicastRemoteObject implements Counter {
    private int value;

    protected CounterImpl() throws RemoteException {
        super();
    }

    @Override
    public int getValue() throws RemoteException {
        return value;
    }

    @Override
    public void increment() throws RemoteException {
        value++;
    }

    @Override
    public void decrement() throws RemoteException {
        value--;
    }
}
