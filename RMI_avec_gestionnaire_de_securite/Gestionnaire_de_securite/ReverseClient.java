package client;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import Fabrique.FabInterface;
import Server.AppInterface;

public class ReverseClient {
    public static void main(String[] args) {
        try {
        	if(System.getSecurityManager()==null) System.setSecurityManager(new RMISecurityManager());
            // Obtenez une référence à l'objet fabrique distant
            FabInterface fabrique = (FabInterface) Naming.lookup("Fabrique");

            // Créez une instance d'objet distant
            AppInterface reverseInstance = fabrique.newReverse();

            // Appelez la méthode distante pour inverser une chaîne
            String result = reverseInstance.reverseString("Hello, World!");
            System.out.println("Chaîne inversée : " + result);
        } catch (Exception e) {
            System.out.println("Erreur d'accès à l'objet distant.");
            System.out.println(e.toString());
        }
    }
}
