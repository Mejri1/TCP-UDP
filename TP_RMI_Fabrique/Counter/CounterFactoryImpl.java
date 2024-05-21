import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CounterFactoryImpl extends UnicastRemoteObject implements CounterFactory {
    protected CounterFactoryImpl() throws RemoteException {
        super();
    }

    @Override
    public Counter createCounter() throws RemoteException {
        return new CounterImpl();
    }
}
