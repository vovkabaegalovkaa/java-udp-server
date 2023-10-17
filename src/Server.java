import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(8001);
        ArrayList<Weather> weathers = new ArrayList<Weather>();
        weathers.add(new Weather(1, "yes", "cloudy"));
        weathers.add(new Weather(2, "yes", "cloudy"));
        weathers.add(new Weather(3, "no", "sunny"));
        weathers.add(new Weather(4, "no", "sunny"));
        weathers.add(new Weather(5, "yes", "cloudy"));
        byte[] receivingDataBuffer = new byte[1];
        byte[] sendingDataBuffer = new byte[0];
        DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
        System.out.println("Waiting for a client to connect...");
        serverSocket.receive(inputPacket);
        String recieveData = new String(inputPacket.getData());
        System.out.println(recieveData);
        for(Weather m : weathers){
            int day = Integer.parseInt(recieveData);
            if(day == m.getDate()) {
                sendingDataBuffer = m.toString().getBytes(StandardCharsets.US_ASCII);
                break;
            }
        }
        InetAddress senderAddress = inputPacket.getAddress();
        int senderPort = inputPacket.getPort();
        DatagramPacket outputPacket = new DatagramPacket(sendingDataBuffer, sendingDataBuffer.length,
                senderAddress,senderPort
        );
        serverSocket.send(outputPacket);
        System.out.println("Message sent!");
        serverSocket.close();
    }
}
