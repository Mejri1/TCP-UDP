import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private BufferedReader userInput;

    public ChatClient(String serverAddress, int serverPort) {
        try {
            socket = new Socket(serverAddress, serverPort);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            userInput = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            System.out.println("Connected to chat server. Type 'exit' to quit.");

            // Start a separate thread to listen for messages from the server
            new Thread(this::receiveMessages).start();

            String message;
            while ((message = userInput.readLine()) != null) {
                if ("/group".equalsIgnoreCase(message.substring(0, Math.min(message.length(), 6)))) {
                    out.println("[GROUP] " + message.substring(7)); // Send group message to server
                } else if ("/msg".equalsIgnoreCase(message.substring(0, Math.min(message.length(), 4)))) {
                    out.println("[MSG] " + message.substring(5)); // Send private message to server
                } else {
                    out.println(message); // Send user input to the server
                }
                if (message.equalsIgnoreCase("exit")) {
                    break; // Exit the loop if user types 'exit'
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void receiveMessages() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Server: " + message); // Display messages from the server
            }
        } catch (IOException e) {
            System.err.println("Error reading message from server: " + e.getMessage());
        } finally {
            close();
        }
    }

    private void close() {
        try {
            if (out != null) out.close();
            if (in != null) in.close();
            if (userInput != null) userInput.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ChatClient <serverAddress> <serverPort>");
            return;
        }

        String serverAddress = args[0];
        int serverPort = Integer.parseInt(args[1]);

        ChatClient client = new ChatClient(serverAddress, serverPort);
        client.start();
    }
}
