Chat Application using Sockets

This project implements a simple chat application using Java Sockets for communication. 
The application allows users to send messages to a group or privately to specific users connected to the chat server.

Features

    Send messages to a group of users.
    Send private messages to specific users.
    Identify users by their names.

    Server Setup: The server starts and listens on a specific port for incoming client connections. It maintains a set of active client connections (clientWriters) using a HashSet.

    Client Connection: Clients connect to the server by providing the server's address and port number. Upon successful connection, clients can send messages to the server.

    Message Transmission:
        Group Messages: Clients can send messages intended for the entire group by prefixing their message with [GROUP].
        Private Messages: Clients can send private messages to specific users by using the format [MSG]recipient_username message_here.

    Server Handling:
        Receiving Messages: The server listens for incoming messages from clients. It identifies group messages and private messages based on their prefixes.
        Broadcasting Group Messages: When a group message is received, the server broadcasts it to all connected clients except the sender.
        Sending Private Messages: For private messages, the server parses the recipient's username and forwards the message only to the intended recipient.

    Client Interaction:
        User Input: Clients read user input from the console and send messages to the server.
        Display Messages: Clients display messages received from the server, indicating whether they are group messages or private messages.

    Exiting the Application: Clients can exit the chat application by typing exit, which closes the client socket and ends the communication with the server.