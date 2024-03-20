import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculetteServer extends UnicastRemoteObject implements CalculetteInterface {

    protected CalculetteServer() throws RemoteException {
        super();
    }

    @Override
    public double addition(double a, double b) throws RemoteException {
        return a + b;
    }

    @Override
    public double soustraction(double a, double b) throws RemoteException {
        return a - b;
    }

    @Override
    public double multiplication(double a, double b) throws RemoteException {
        return a * b;
    }

    @Override
    public double division(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Division par zéro impossible");
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(12345); // Créer le registre RMI sur le port 1099
            CalculetteServer calcServer = new CalculetteServer();
            java.rmi.Naming.rebind("CalcServer", calcServer); // Publier l'objet sur le registre RMI
            System.out.println("Serveur RMI prêt.");
        } catch (Exception e) {
            System.err.println("Erreur serveur : " + e.toString());
            e.printStackTrace();
        }
    }
}
