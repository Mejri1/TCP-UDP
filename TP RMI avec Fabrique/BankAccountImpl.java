import java.rmi.*;
import java.rmi.server.*;

public class BankAccountImpl extends UnicastRemoteObject implements BankAccountInterface {
    private double balance;

    public BankAccountImpl() throws RemoteException {
        super();
        this.balance = 0;
    }

    @Override
    public synchronized void deposit(double amount) throws RemoteException {
        this.balance += amount;
    }

    @Override
    public synchronized void withdraw(double amount) throws RemoteException {
        if (this.balance >= amount) {
            this.balance -= amount;
        } else {
            throw new RemoteException("Insufficient balance.");
        }
    }

    @Override
    public synchronized double getBalance() throws RemoteException {
        return this.balance;
    }
}
