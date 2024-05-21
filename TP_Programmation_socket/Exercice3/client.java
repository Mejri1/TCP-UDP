
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 100);
            System.out.println("Connecté au serveur : " + socket);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez l'âge de la personne : ");
            int age = scanner.nextInt();
            System.out.print("Entrez le nom de la personne : ");
            String nom = scanner.next();

            out.writeInt(age);
            out.writeUTF(nom);

            int identifiantClient = in.readInt();
            System.out.println("Identifiant du client : " + identifiantClient);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}