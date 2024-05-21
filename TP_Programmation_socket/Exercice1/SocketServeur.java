import java.io.*;
import java.net.*;
import java.util.Scanner;
public class SocketServeur {
public static void main(String argv[]) {
int port = 0;
Scanner keyb = new Scanner(System.in);
// Demande à l'utilisateur de saisir le numéro de port
System.out.print("Port d'écoute : ");
try {
port = keyb.nextInt();
} catch (NumberFormatException e) {
System.err.println("Le paramètre n'est pas un entier.");
System.err.println("Usage : java ServeurUDP port-serveur");
System.exit(-1);
}
try {
// Crée un objet ServerSocket qui écoute sur le port spécifié
ServerSocket serverSocket = new ServerSocket(port);
// Attend qu'un client se connecte

Socket socket = serverSocket.accept();

// Initialise les flux de sortie et d'entrée pour la communication avec le client
ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
// Lit une chaîne de caractères envoyée par le client
String chaine = (String) input.readObject();
System.out.println(" recu : " + chaine);
// Affiche l'adresse IP et le port du client
System.out.println(" ca vient de : " + socket.getInetAddress() + ":" + socket.getPort());
// Envoie une réponse au client pour confirmer la réception
output.writeObject(new String("bien recu"));
} catch (Exception e) {
System.err.println("Erreur : " + e);
}
}
}