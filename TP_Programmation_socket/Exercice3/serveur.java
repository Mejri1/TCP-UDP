import java.io.*;
import java.net.*;

public class serveur {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(100);

            while (true) {
                Socket socket = serverSocket.accept();

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                int age = in.readInt();
                int i=1;
                String nom = in.readUTF();

                int identifiantClient =i;
                i++;
                out.writeInt(identifiantClient);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}