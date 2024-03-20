This project implements a simple Remote Method Invocation (RMI) application where the server reverses any string received from the client and sends back the reversed string.

Implementation Details
- The project includes two main classes:
  - `MyServer`: Implements the RMI server that exposes a remote method (`performAction`) to clients.
  - `MyClient`: Implements the RMI client that connects to the server and invokes the remote method.
- The server binds its remote object to the RMI registry using `java.rmi.Naming.rebind`.
- The client looks up the remote object from the RMI registry using `java.rmi.Naming.lookup`.
- Both server and client communicate using the `MyInterface` interface, which defines the remote method.
