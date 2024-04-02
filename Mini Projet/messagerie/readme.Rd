RMI Task Management System
Overview

This project implements a simple Task Management System using Java RMI (Remote Method Invocation). It allows users to add tasks, remove tasks, and retrieve the task list remotely using RMI.
Files

    TaskManager.java: Defines the remote interface for task management operations.
    TaskManagerImpl.java: Implements the remote interface and provides the actual task management functionality.
    TaskServer.java: Sets up and starts the RMI registry and registers the task management service.
    TaskClient.java: Provides a client interface to interact with the remote task management system.

How to Compile

Compile the Java files using the following command:

javac TaskManager.java TaskManagerImpl.java TaskServer.java TaskClient.java

How to Run
    Start the RMI registry using the command:
        rmiregistry

Start the Task Server using the command:
        java TaskServer

Run the Task Client using the command:
        java TaskClient
