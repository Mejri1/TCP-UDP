# Distributed Systems Java Project Collection

## Description
This repository is a comprehensive collection of distributed systems projects implemented in Java. It demonstrates various communication paradigms and technologies, including gRPC, RMI, TCP/UDP sockets, multithreading, and Apache Kafka. The projects are organized into subfolders, each focusing on a specific technology or use case, making this repository a valuable resource for learning, teaching, or prototyping distributed systems in Java.

---

## Features
- **gRPC Microservices**: Multiple gRPC-based services and clients, including HelloWorld, Reverse, and Route Guide examples.
- **RMI Applications**: Java RMI-based calculator, bank account management, and string reversal services.
- **Task Management via RMI**: Remote task management system using Java RMI.
- **Socket Programming**: TCP and UDP client/server implementations, including multithreaded servers.
- **Apache Kafka Integration**: Spring Boot microservice for event streaming with Kafka.
- **Chat and Messaging**: Console-based chat and messaging systems using sockets and gRPC.
- **Well-Documented Examples**: Each subproject includes code and, where available, documentation or usage instructions.

---

## Tech Stack
- **Java 8/11/17** (depending on subproject)
- **gRPC** (with Protocol Buffers)
- **Java RMI**
- **Apache Kafka** (with Spring Boot, Spring Cloud Stream)
- **Socket Programming** (TCP/UDP)
- **Maven** (for dependency management)
- **Lombok** (in Kafka demo)
- **Spring Boot** (in Kafka demo)

---

## Installation

### Prerequisites
- Java JDK 8, 11, or 17 (depending on subproject)
- Maven (for gRPC and Kafka projects)
- Apache Kafka (for Kafka demo)
- (Optional) Docker, if you wish to run Kafka in a container

### General Steps
1. **Clone the repository:**
   ```sh
   git clone <repo-url>
   cd tcpudp
   ```
2. **Build Maven projects:**
   For each Maven-based subproject (e.g., `grpc-demo`, `Mini Projet/grpcproject/grpc/pro`, `kafka/Kafka/demo`):
   ```sh
   cd <subproject-folder>
   mvn clean install
   ```
3. **Compile Java-only projects:**
   For pure Java projects (e.g., RMI, TCP_UDP):
   ```sh
   cd <subproject-folder>
   javac *.java
   ```
4. **Kafka Setup:**
   - Start Zookeeper and Kafka brokers (see [Kafka Quickstart](https://kafka.apache.org/quickstart)).
   - Or use Docker Compose if available.

---

## Usage

### gRPC Projects
- **grpc-demo**: Run servers and clients from the `io.grpc.examples` packages. Example:
  ```sh
  cd grpc-demo
  mvn exec:java -Dexec.mainClass="io.grpc.examples.helloworld.HelloWorldServer"
  mvn exec:java -Dexec.mainClass="io.grpc.examples.helloworld.HelloWorldClient"
  ```
- **Mini Projet/grpcproject/grpc/pro**: Run the gRPC MessagingServer and MessagingClient:
  ```sh
  cd Mini\ Projet/grpcproject/grpc/pro
  mvn compile
  java -cp target/classes grpc.MessagingServer
  java -cp target/classes grpc.MessagingClient
  ```

### RMI Projects
- **RMI, calculette RMI, TP RMI avec Fabrique, Rmi avec gestionnaire de sécurité et chargement dynamique**:
  - Start the RMI registry:
    ```sh
    rmiregistry &
    ```
  - Start the server and client:
    ```sh
    java MyServer
    java MyClient
    ```
  - For calculator: `CalculetteServer` and `CalculetteClient`.

### Socket Programming
- **TCP_UDP**:
  - Start the server:
    ```sh
    java TCPServer
    java UDPServer
    ```
  - Start the client:
    ```sh
    java TCPClient
    java UDPClient
    ```
- **multi threading**:
  - Run `MultithreadedTCPServer` and `MultithreadedTCPClient` for concurrent TCP communication.

### Kafka Demo
- **kafka/Kafka/demo**:
  - Start Kafka and Zookeeper.
  - Run the Spring Boot application:
    ```sh
    cd kafka/Kafka/demo
    mvn spring-boot:run
    ```
  - Use the REST endpoint to publish events:
    ```sh
    curl http://localhost:8080/publish/<topic>/<name>
    ```

### Chat and Messaging
- **Mini Projet/Service de chat**:
  - Start the server:
    ```sh
    java ChatServer
    ```
  - Start the client:
    ```sh
    java ChatClient
    ```
- **Mini Projet/messagerie**:
  - Start the RMI registry, then run `TaskServer` and `TaskClient` as described above.

---

## Folder Structure

```
.
├── grpc-demo/                # gRPC Java demo (HelloWorld, Reverse, Route Guide)
├── kafka/                    # Kafka event streaming demo (Spring Boot)
├── Mini Projet/
│   ├── grpcproject/          # gRPC messaging microservice
│   ├── messagerie/           # RMI-based task management
│   └── Service de chat/      # Socket-based chat application
├── RMI/                      # Simple RMI string reversal
├── calculette RMI/           # RMI-based calculator
├── TP RMI avec Fabrique/     # RMI with factory pattern
├── Rmi avec gestionnaire.../ # RMI with security manager and dynamic loading
├── multi threading/          # Multithreaded TCP server/client
├── TCP_UDP/                  # Basic TCP/UDP client/server
```

---

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request. For major changes, open an issue first to discuss what you would like to change.

---

## License
No license file detected. If you intend to open source this project, please add a LICENSE file. 
