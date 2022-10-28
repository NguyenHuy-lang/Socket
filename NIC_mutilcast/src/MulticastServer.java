import java.io.BufferedReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastServer {
    public static void main(String args[]) {
        DatagramSocket socket = null;
        BufferedReader in = null;
        boolean moreQuotes = true;
        try {
            socket = new DatagramSocket();
            while (true) {
                InetAddress group = InetAddress.getByName("224.2.2.3");
                for (int i = 1; i < 1000; i++) {
                    String dString = i + "--" + (InetAddress.getLocalHost());
                    byte[] buf = dString.getBytes();
                    DatagramPacket packet
                            = new DatagramPacket(buf, buf.length, group, 1107);
                    socket.send(packet);
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
        }
    }
}
