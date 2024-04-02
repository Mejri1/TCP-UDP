package messagerie;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class TaskServer {
    public static void main(String[] args) {
        try {
            TaskManagerImpl taskManager = new TaskManagerImpl();
            LocateRegistry.createRegistry(12345);
            Naming.rebind("TaskManagerService", taskManager);
            System.out.println("Task Manager Server is running...");
        } catch (RemoteException | java.net.MalformedURLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}