import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Serveur {
	public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9090)
                .addService(new Service())
                .build();

        server.start();
        System.out.println("Server started at port: " + server.getPort());

        // Attendre que le serveur soit terminé
        server.awaitTermination();
    }
}
