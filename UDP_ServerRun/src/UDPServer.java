import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
    DatagramSocket myServer = null;
    String input;
    int port = 1107;
    public void openServer() {
        try {
            myServer = new DatagramSocket(port);
        } catch (SocketException e) {
            System.out.println(e);
        }
    }
    public void listening() {
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while (true) {
            try {
// Nhan du lieu
                DatagramPacket receivePacket = new DatagramPacket(receiveData,
                        receiveData.length);
                myServer.receive(receivePacket);
                input = new String(receivePacket.getData());
                System.out.println(input);
                ReverseString obj = new ReverseString(input);
                obj.reverse();
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                System.out.println(port);
                sendData = obj.getStr().getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData,
                        sendData.length, IPAddress, port);
// Gui du lieu ve client
                myServer.send(sendPacket);
            } catch (SocketException e) {
                System.out.println(e);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
