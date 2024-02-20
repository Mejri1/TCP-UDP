# Multithreaded TCP Server and Client

This project demonstrates a simple multithreaded TCP server and client implementation in Java.
The server can handle up to 10 clients simultaneously, each client sending a message to the server, which then reverses the message and returns it.


    MuiltithreadedTCPServer.java: Sets up a TCP server that listens for incoming client connections and handles them using multiple threads.
    MultithreadedTCPClient.java: Represents a TCP client that connects to the server, sends messages, and receives reversed messages.
    ClientHandler.java: Manages individual client connections on the server side, reversing messages sent by clients and sending them back.
