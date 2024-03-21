import java.rmi.*;
import java.rmi.registry.*;

public class BankServer {
    public static void main(String[] args) {
        try {
            BankAccountFactoryImpl factory = new BankAccountFactoryImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("BankFactory", factory);
            System.out.println("Bank server ready.");
        } catch (Exception e) {
            System.err.println("Error starting bank server: " + e.getMessage());
        }
    }
}
