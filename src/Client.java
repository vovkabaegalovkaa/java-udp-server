import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendingDataBuffer = new byte[1024];
        byte[] receivingDataBuffer = new byte[1024];
        boolean flag = true;
        int date = 0;
        while(flag) {
            System.out.println("Enter date: ");
            date = sc.nextInt();
            if(date<=0 || date>=5){
                System.out.println("Try again");
            }
            else
                flag = false;
        }
        sendingDataBuffer = Integer.toString(date).getBytes(StandardCharsets.US_ASCII);
        DatagramPacket sendingPacket = new DatagramPacket(sendingDataBuffer,sendingDataBuffer.length,IPAddress, 8001);
        clientSocket.send(sendingPacket);
        DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
        clientSocket.receive(receivingPacket);
        String recieve = new String(receivingPacket.getData());
        System.out.println("Server send: " + recieve.trim());
        clientSocket.close();;
    }
}