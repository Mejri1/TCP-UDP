package grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import messaging.MessagingServiceGrpc;
import messaging.MessagingServiceOuterClass.MessageRequest;
import messaging.MessagingServiceOuterClass.MessageResponse;
import messaging.MessagingServiceOuterClass.MessagesResponse;
import messaging.MessagingServiceOuterClass.UserRequest;

public class MessagingClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9000)
                .usePlaintext()
                .build();

        MessagingServiceGrpc.MessagingServiceBlockingStub stub = MessagingServiceGrpc.newBlockingStub(channel);

        // Call sendMessage RPC
        MessageRequest sendMessageRequest = MessageRequest.newBuilder()
                .setSenderId("sender123")
                .setRecipientId("recipient456")
                .setText("Hello, this is a message!")
                .build();
        MessageResponse sendMessageResponse = stub.sendMessage(sendMessageRequest);
        System.out.println("Message sent. Response: " + sendMessageResponse);

        // Call getMessagesForUser RPC
        UserRequest getMessagesRequest = UserRequest.newBuilder()
                .setUserId("user789")
                .build();
        MessagesResponse messagesForUserResponse = stub.getMessagesForUser(getMessagesRequest);
        System.out.println("Messages for user. Response: " + messagesForUserResponse);

        channel.shutdown();
    }
}
