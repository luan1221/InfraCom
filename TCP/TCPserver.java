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
                    String res = "";
                    System.out.println("Mensagem do cliente: " + msg);  
                    switch (msg.charAt(0)) {
                        case 'F':
                            res = "Pra já, rochedo.";
                            break;
                        case 'O':
                            res = "Dale mo pirraia!!";
                            break;
                        case 'I':
                            res = "Excama só de peixeee! Uaiinn!";
                            break;
                        case 'A':
                            res = "Eu tô só caladuu...";
                            break;
                        case 'U':
                            res = "UH A JOVI AEEE!!!!";
                            break;
                        case 'E':
                            res = "Oh 9vinha c é tudo de bom.";
                        default:
                            res = "É cada um com seu poder...";
                    }
                    out.writeUTF(res);
                } while (!msg.equals("Finaliza aê cpc"));
                
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