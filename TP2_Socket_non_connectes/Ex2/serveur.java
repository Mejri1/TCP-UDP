package TP2.Ex2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class serveur {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int port = 0;
        try {
            
            System.out.println("port d'écoute : ");
            port = scanner.nextInt();
            DatagramSocket socket = new DatagramSocket(port);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            ByteArrayInputStream input = new ByteArrayInputStream(receivePacket.getData());
            ObjectInputStream ob_intput = new ObjectInputStream(input);
            voiture voitureRecue = (voiture) ob_intput.readObject();

            voitureRecue.setCarburant(50);
            System.out.println("Quantité de carburant de la voiture reçue : " + voitureRecue.getCarburant());

            ob_intput.close();
            socket.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
