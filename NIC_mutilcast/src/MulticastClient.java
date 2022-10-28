import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {
    public static void main(String[] args) throws IOException {
        MulticastSocket socket = new MulticastSocket(1107);
        InetAddress address = InetAddress.getByName("224.2.2.3");
        socket.joinGroup(address);
        byte[] buf = new byte[256];
        DatagramPacket packet;
        while (true) {
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String received = new String(packet.getData());
            System.out.println("Received: " + received);
            try {
                Thread.currentThread().sleep(0);
            } catch (InterruptedException e) {
            }
        }
    }
}