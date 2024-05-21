package TP2.Ex3;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class serveur {
    public static void main(String[] args) {
         int PORT = 0;
         Scanner scanner = new Scanner(System.in);
        try {
                
            System.out.println("port d'écoute : ");
            PORT = scanner.nextInt();
            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("Serveur UDP démarré sur le port " + PORT);
            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String dateHeure = dateFormat.format(date);
                byte[] sendData = dateHeure.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
                System.out.println("Date et heure envoyées à l'émetteur : " + dateHeure);
            }
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
}
