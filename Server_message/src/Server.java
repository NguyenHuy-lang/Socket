//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class Server {
//    public static void main(String[] args) throws IOException {
//        Socket socket = null;
//        InputStreamReader inputStreamReader = null;
//        OutputStreamWriter outputStreamWriter = null;
//        BufferedReader bufferedReader = null;
//        BufferedWriter bufferedWriter = null;
//        ServerSocket serverSocket = null;
//        serverSocket = new ServerSocket(1234);
//        while(true){
//            try{
//                socket = serverSocket.accept();
//                inputStreamReader = new InputStreamReader(socket.getInputStream());
//                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
//                bufferedReader = new BufferedReader(inputStreamReader);
//                bufferedWriter = new BufferedWriter(outputStreamWriter);
//                while(true){
//                    String messFromClient = bufferedReader.readLine();
//                    System.out.println("Client: " + messFromClient);
//                    bufferedWriter.write("MSG Received.");
//                    bufferedWriter.newLine();
//                    bufferedWriter.flush();
//                    if(messFromClient.equalsIgnoreCase("BYE")){
//                        break;
//                    }
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }
//}


import java.net.*;
import java.io.*;

class Server {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        while (!str.equals("stop")) {
            str = din.readUTF();
            System.out.println("client says: " + str);
            str2 = br.readLine();
            dout.writeUTF(str2);
            dout.flush();
        }
        din.close();
        s.close();
        ss.close();
    }
}

