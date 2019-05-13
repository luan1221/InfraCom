import java.io.*;
import java.net.*;

public class TCPserver {

    public static void main(String[] args) {
        int port = 8888;

        try {
            ServerSocket tmpsocket = new ServerSocket(port);
            System.out.println("Aguardando cliente");
            while (true) {
                Socket socket = tmpsocket.accept();
                System.out.println("Cliente conectado: " + socket.getInetAddress().getHostAddress());
            }
            




            socket.close();
        } catch (BindException e) {
            System.out.println("Endereço em uso");
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

    }

}