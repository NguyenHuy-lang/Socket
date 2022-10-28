import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {
    //khai bao socket cho client, cong gui va nhan du lieu
    DatagramSocket client = null;
    int port = 1107;
    //Tao ket noi
    public void connect() {
        try {
            client = new DatagramSocket(); //không cần khai báo port
        } catch (SocketException e) {
            System.err.println(e);
        }
    }
    public void send(String str) {
        if (client != null) {
            byte[] sendData = new byte[1024]; // bo dem gui dl
            try {
                InetAddress IPAddress = InetAddress.getByName("localhost");
                sendData = str.getBytes();
                DatagramPacket sendPacket = new
                        DatagramPacket(sendData, sendData.length, IPAddress, port);
                client.send(sendPacket);
            } catch (SocketException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
    public String receive() {
        if (client != null) {
            byte[] receiveData = new byte[1024]; // bo dem nhan dl
            try {
                DatagramPacket receivePacket = new
                        DatagramPacket(receiveData, receiveData.length);
                client.receive(receivePacket);
                return new String(receivePacket.getData());
            } catch (SocketException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        return null;
    }
    public void close() {
        if (client != null) {
            try {
                client.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

}
