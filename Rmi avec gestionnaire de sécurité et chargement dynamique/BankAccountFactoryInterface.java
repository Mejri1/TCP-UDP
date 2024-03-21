import java.rmi.*;

public interface BankAccountFactoryInterface extends Remote {
    BankAccountInterface createAccount() throws RemoteException;
}
