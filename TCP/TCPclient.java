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
            
            System.out.println("Mensagem do servidor: " + msg);
            do { 
                msg = userMsg.readLine();
                out.writeUTF(msg);
                long tempoIda = System.currentTimeMillis();
                System.out.println("t1: " + tempoIda + ".");
                msg = in.readUTF();
                long tempoVolta = System.currentTimeMillis();
                double rtt = tempoVolta - tempoIda;
                System.out.println("t2: " + tempoVolta + ".");
                System.out.printf("RTT: %.15f.\n", rtt);
                System.out.println("Mensagem do servidor: " + msg);

            } while (!msg.equals("Pra já, rochedo."));

            System.out.println("Conexão Encerrada.");
            socket.close();
 
        } catch (ConnectException e) {
            System.out.println("Não foi possível chegar ao destino");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}