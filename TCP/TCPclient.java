import java.io.*;
import java.net.*;

public class TCPclient {

    public static void main(String[] args) {
        int port = 8888;
        String address = "localhost";

        try {
            BufferedReader userMsg = new BufferedReader(new InputStreamReader(System.in));
            Socket socket = new Socket(address, port);
            System.out.println("Conectado ao servidor de porta " + port + "!");
            System.out.println("Digite " + '"' + "Finalizar" + '"' + " para encerrar a conexão.");
            
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream()); 
            
            String msg = in.readUTF();
            System.out.println("Mensagem do servidor: " + msg + ".");
            do { 
                msg = userMsg.readLine();
                out.writeUTF(msg);
                msg = in.readUTF();
                System.out.println("Mensagem do servidor: " + msg + ".");

            } while (!msg.equals("Finalizar"));

            System.out.println("Conexão Encerrada.");
            socket.close();
 
        } catch (ConnectException e) {
            System.out.println("Não foi possível chegar ao destino");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}