package TP2.Ex2;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        int port = 0;
        String host = "";
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Adress du serveur : ");
            host = scanner.next();
            System.out.println("port d'écoute du serveur : ");
            port = scanner.nextInt();
            voiture maVoiture = new voiture("SUV", "Toyota");
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName(host);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ObjectOutputStream ob_output = new ObjectOutputStream(output);
            ob_output.writeObject(maVoiture);
            byte[] sendData = output.toByteArray();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, port);
            socket.send(sendPacket);
            ob_output.close();
            socket.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
