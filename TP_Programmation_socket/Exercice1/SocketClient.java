import java.io.*;
import java.net.*;
import java.util.Scanner;
class SocketClient {
public static void main(String argv[]) {
int port = 0;
String host = "";
Scanner keyb = new Scanner(System.in);
// Demande à l'utilisateur de saisir le nom du serveur (port)
System.out.print("Nom du serveur : ");
host = keyb.next();
System.out.print("Port du serveur : ");
try {
port = keyb.nextInt();
} catch (NumberFormatException e) {
System.err.println("Le second paramètre n'est pas un entier.");
System.exit(-1);
}
// Etablit de connection 
try {
// Résout l'adresse IP du serveur en fonction de son nom
InetAddress adr = InetAddress.getByName(host);
// Crée un socket et se connecte au serveur à l'adresse et au port spécifiés
Socket socket = new Socket(adr, port);
// Initialise les flux de sortie et d'entrée pour la communication avec le serveur
ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
// Envoie une chaîne de caractères au serveur
output.writeObject(new String("ma première socket"));
// Lit une réponse du serveur
String chaine = (String) input.readObject();
System.out.println(" recu du serveur : " + chaine);
} catch (Exception e) {
System.err.println("Erreur : " + e);
}
}
}