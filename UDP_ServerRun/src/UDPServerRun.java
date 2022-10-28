public class UDPServerRun {
    public static void main(String[] args) {
        UDPServer server = new UDPServer();
        server.openServer();
        server.listening();
    }
}
