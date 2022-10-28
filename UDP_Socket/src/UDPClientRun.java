public   class UDPClientRun {
    public static void main(String[] args) {
        UDPClient client = new UDPClient();
        client.connect();
        client.send("");
        System.out.println(client.receive());
    }
}
