import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyServer extends UnicastRemoteObject implements MyInterface {
    protected MyServer() throws RemoteException {
        super();
    }

    @Override
    public String performAction(String input) throws RemoteException {
        return "Server processed: " + input;
    }

    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("MyServer", new MyServer());
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
