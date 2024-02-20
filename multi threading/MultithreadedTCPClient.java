import java.io.*;
import java.net.*;

public class MultithreadedTCPClient {
    public static void main(String[] args) {
        String serverHostname = "localhost";

        try {
            for (int i = 0; i < 5; i++) {
                Socket socket = new Socket(serverHostname, 6789);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                out.println("Hello Server");

                String response = in.readLine();
                System.out.println("Server: " + response);

                socket.close();
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + serverHostname);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + serverHostname);
        }
    }
}
