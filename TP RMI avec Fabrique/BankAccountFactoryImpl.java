import java.rmi.*;
import java.rmi.server.*;

public class BankAccountFactoryImpl extends UnicastRemoteObject implements BankAccountFactoryInterface {
    public BankAccountFactoryImpl() throws RemoteException {
        super();
    }

    @Override
    public BankAccountInterface createAccount() throws RemoteException {
        try {
            return new BankAccountImpl();
        } catch (RemoteException e) {
            throw new RemoteException("Error creating account.", e);
        }
    }
}
