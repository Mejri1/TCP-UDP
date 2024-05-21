package src.Server;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClassLoader; 
import java.util.Properties;

import src.Fabrique.*;


public class DynamicReverseServer {
    public static void main(String[] args) {
    	try{if (System.getSecurityManager() == null)
    		System.setSecurityManager (new RMISecurityManager());
    		Registry registry =LocateRegistry.createRegistry (1099); 
    		System.out.println( "Serveur : Construction de l'implementation");
            System.out.println("Serveur prêt. Attente des invocations des clients...");
            Properties p= System.getProperties();
            String url=p.getProperty("java.rmi.server.codebase"); 
            Class ClasseServeur = RMIClassLoader.loadClass(url, "FabReverseImpl");
            registry.rebind("Fabrique", (Remote) ClasseServeur.newInstance());
            System.out.println ("Serveur prêt.");
            System.out.println("Attente des invocations des clients ...");}
            catch (Exception e) {
            System.out.println("Erreur de liaison de l'objet Fabrique"); System.out.println(e.toString());
            }
}}
