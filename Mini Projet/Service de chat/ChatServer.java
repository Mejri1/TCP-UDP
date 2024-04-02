import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatServer {
    private static final int PORT = 12345;
    private static Map<String, PrintWriter> clientsMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Chat Server started on port " + PORT);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private String username;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Ask for username
                out.println("Enter your username:");
                username = in.readLine();

                synchronized (clientsMap) {
                    clientsMap.put(username, out);
                }

                System.out.println(username + " connected.");

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(username + ": " + message);
                    if (message.startsWith("[GROUP]")) {
                        sendMessageToAllClients(message.substring(7));
                    } else if (message.startsWith("[MSG]")) {
                        sendPrivateMessage(message.substring(5));
                    } else {
                        out.println("Server: Unrecognized command.");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (clientsMap) {
                    clientsMap.remove(username);
                }
                System.out.println(username + " disconnected.");
            }
        }

        private void sendMessageToAllClients(String message) {
            synchronized (clientsMap) {
                for (PrintWriter writer : clientsMap.values()) {
                    writer.println("[" + username + " - Group]: " + message);
                }
            }
        }

        private void sendPrivateMessage(String message) {
            // Parse the message to get recipient and actual message
            // For simplicity, assume format is "[Recipient] Message"
            String[] parts = message.split(" ", 2);
            if (parts.length >= 2) {
                String recipient = parts[0];
                String actualMessage = parts[1];
                synchronized (clientsMap) {
                    PrintWriter recipientWriter = clientsMap.get(recipient);
                    if (recipientWriter != null) {
                        recipientWriter.println("[" + username + " - Private]: " + actualMessage);
                    } else {
                        out.println("Server: User '" + recipient + "' not found or offline.");
                    }
                }
            }
        }
    }
}
