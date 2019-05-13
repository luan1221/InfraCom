import java.io.*;
import java.net.*;

public class TCPserver {

    public static void main(String[] args) {
        int port = 8888;
        String msg;
        boolean conex = true;

        try {
            ServerSocket tmpsocket = new ServerSocket(port);
            System.out.println("Aguardando cliente...");
            while (conex) {
                Socket socket = tmpsocket.accept();
                System.out.println("Cliente conectado: " + socket.getInetAddress().getHostAddress());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());  

                out.writeUTF("Conexão estabelecida...");
                do {
                    msg = in.readUTF();
                    System.out.println("Mensagem do cliente: " + msg);  
                    out.writeUTF(msg);
                } while (!msg.equals("Finalizar"));
                
                System.out.println("Conexão encerrada.");

                conex = false;
                
            }
            

            tmpsocket.close();
        } catch (BindException e) {
            System.out.println("Endereço em uso");
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

    }

}