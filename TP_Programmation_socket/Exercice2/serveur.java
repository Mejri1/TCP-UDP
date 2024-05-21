import java.io.*;
import java.net.*;

public class serveur {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(100);
            Socket socket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            voiture voitureRecue = (voiture) in.readObject();
            voitureRecue.setCarburant(50);
            System.out.println("Quantité de carburant de la voiture reçue : " + voitureRecue.getCarburant());
            in.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}