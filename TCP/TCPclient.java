import java.io.*;
import java.net.*;

public class TCPclient {

    public static void main(String[] args) {
        int port = 4002;
        String address = "localhost";

        try {
            Socket socket = new Socket(address, port);




            socket.close();
        } catch (ConnectException e) {
            System.out.println("Não foi possível chegar ao destino");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}