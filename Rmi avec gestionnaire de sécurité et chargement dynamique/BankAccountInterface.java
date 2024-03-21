import java.rmi.*;

public interface BankAccountInterface extends Remote {
    void deposit(double amount) throws RemoteException;
    void withdraw(double amount) throws RemoteException;
    double getBalance() throws RemoteException;
}
