package io.grpc.examples.helloworld;

/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple client that requests a greeting from the {@link HelloWorldServer}.
 */
public class HelloWorldClient {
    private static final Logger logger = Logger.getLogger(HelloWorldClient.class.getName());

    private final GreeterGrpc.GreeterBlockingStub blockingStub;

    /** Construct client for accessing HelloWorld server using the existing channel. */
    public HelloWorldClient(Channel channel) {
        // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's responsibility to
        // shut it down.

        // Passing Channels to code makes code easier to test and makes it easier to reuse Channels.
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    /** Say hello to server. */
    public void greet(String firstName, String lastName, String cin) {
        logger.info("Will try to greet " + firstName + " " + lastName + " with CIN: " + cin + " ...");
        HelloRequest request = HelloRequest.newBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setCin(cin)
                .build();
        HelloReply response;
        try {
            response = blockingStub.sayHello(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Greeting: " + response.getMessage());
    
        try {
            response = blockingStub.sayHelloAgain(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Greeting: " + response.getMessage());
    }
    

    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting. The second argument is the target server.
     */
    public static void main(String[] args) throws Exception {
        String firstName = "John";
        String lastName = "Doe";
        String cin = "123456789";
    
        String target = "localhost:50051";
    
        if (args.length > 0) {
            if ("--help".equals(args[0])) {
                System.err.println("Usage: [firstName lastName cin [target]]");
                System.err.println("");
                System.err.println("  firstName    First name");
                System.err.println("  lastName     Last name");
                System.err.println("  cin          CIN");
                System.err.println("  target       The server to connect to. Defaults to " + target);
                System.exit(1);
            }
            firstName = args[0];
            lastName = args[1];
            cin = args[2];
        }
        if (args.length > 3) {
            target = args[3];
        }
    
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        try {
            HelloWorldClient client = new HelloWorldClient(channel);
            client.greet(firstName, lastName, cin);
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
    
}

