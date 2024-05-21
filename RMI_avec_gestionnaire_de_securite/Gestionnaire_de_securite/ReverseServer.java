package Server;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class ReverseServer {
    public static void main(String[] args) {
        try {
        	if(System.getSecurityManager()==null) System.setSecurityManager(new RMISecurityManager());
            // Créez une instance de l'objet fabrique d'objets
            AppInterface fabrique = new AppImpl();

            // Liez l'objet fabrique dans le registre RMI
            Naming.rebind("Fabrique", fabrique);

            System.out.println("Serveur prêt. Attente des invocations des clients...");
        } catch (Exception e) {
            System.out.println("Erreur de liaison de l'objet Fabrique");
            System.out.println(e.toString());
        }
    }
}
