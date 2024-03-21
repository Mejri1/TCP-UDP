import java.rmi.*;
import java.rmi.registry.*;

public class BankClient {
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            BankAccountFactoryInterface factory = (BankAccountFactoryInterface) registry.lookup("BankFactory");

            BankAccountInterface account1 = factory.createAccount();
            BankAccountInterface account2 = factory.createAccount();

            account1.deposit(1000);
            account2.deposit(500);

            System.out.println("Balance of account 1: " + account1.getBalance());
            System.out.println("Balance of account 2: " + account2.getBalance());
        } catch (Exception e) {
            System.err.println("Error connecting to bank server: " + e.getMessage());
        }
    }
}
