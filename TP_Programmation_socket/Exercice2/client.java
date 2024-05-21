import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        try {
            voiture maVoiture = new voiture("Berline", "Toyota");
            Socket socket = new Socket("localhost", 100);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(maVoiture);
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}