package Client;

import java.util.Scanner;

import grpc.grpc.ChatServiceGrpc;
import grpc.grpc.ChatServiceOuterClass.MessageRequest;
import grpc.grpc.ChatServiceOuterClass.MessageResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class Client {
	private static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        ChatServiceGrpc.ChatServiceStub asyncStub = ChatServiceGrpc.newStub(channel);

        // Create a scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);

        // Afficher le menu initial une seule fois
        printMenu();

        while (true) {
            String choice = scanner.nextLine();

            if ("1".equals(choice)) {
                sendMessage(asyncStub, scanner);
            } else if ("2".equals(choice)) {
                break; // Quitter l'application
            } else {
                System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

        // Fermer le scanner et le canal
        scanner.close();
        channel.shutdown();
    }

    private static void sendMessage(ChatServiceGrpc.ChatServiceStub asyncStub, Scanner scanner) {
        System.out.print("Enter sender username: ");
        String sender = scanner.nextLine();

        System.out.print("Enter recipient username: ");
        String recipient = scanner.nextLine();

        System.out.print("Enter message: ");
        String messageText = scanner.nextLine();

        // Build the message request
        MessageRequest messageRequest = MessageRequest.newBuilder()
                .setSender(sender)
                .setRecipient(recipient)
                .setMessage(messageText)
                .build();

        // Send the message asynchronously
        asyncStub.sendMessage(messageRequest, new StreamObserver<MessageResponse>() {
            @Override
            public void onNext(MessageResponse response) {
                // Traitement de la réponse du serveur
                System.out.println("Server response: " + response.getStatus());
            }

            @Override
            public void onError(Throwable t) {
                // Gestion des erreurs
                System.err.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // Le serveur a terminé de répondre
                System.out.println("Message sent successfully.");
                System.out.println(); // Ligne vide pour plus de clarté

                // Afficher à nouveau le menu après l'envoi d'un message
                printMenu();
            }
        });
    }

    private static void printMenu() {
        System.out.println("1. Envoyer un message");
        System.out.println("2. Quitter");
        System.out.print("Choix : ");

    }

}
