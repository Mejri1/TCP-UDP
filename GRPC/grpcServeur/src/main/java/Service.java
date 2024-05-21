import grpc.grpc.ChatServiceGrpc.ChatServiceImplBase;
import grpc.grpc.ChatServiceOuterClass.Message;
import grpc.grpc.ChatServiceOuterClass.MessageList;
import grpc.grpc.ChatServiceOuterClass.MessageRequest;
import grpc.grpc.ChatServiceOuterClass.MessageResponse;
import grpc.grpc.ChatServiceOuterClass.UserRequest;
import io.grpc.stub.StreamObserver;

public class Service extends ChatServiceImplBase {
	@Override
    public void sendMessage(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
        // Logique pour envoyer le message au destinataire
        // Ici, vous pouvez implémenter le code pour envoyer un message à l'utilisateur spécifié
        String status = "Message sent successfully";
        MessageResponse response = MessageResponse.newBuilder().setStatus(status).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getMessagesForUser(UserRequest request, StreamObserver<MessageList> responseObserver) {
        // Logique pour récupérer les messages pour un utilisateur donné
        // Ici, vous pouvez implémenter le code pour récupérer les messages destinés à un utilisateur spécifié
        MessageList messageList = MessageList.newBuilder()
                                .addMessages(Message.newBuilder().setSender("Sender").setMessage("Hello").build())
                                .build();
        responseObserver.onNext(messageList);
        responseObserver.onCompleted();
    }

}
