import java.io.*;
import java.net.*;


public class UDPclient {
    public static void main(String[] args) throws IOException {
        BufferedReader userMsg = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clienteSocket = new DatagramSocket();
        InetAddress IPserver = InetAddress.getByName("localhost");
        byte[] sendData = new byte[2000];
        byte[] rcvData = new byte[2000];
        String msg = userMsg.readLine();
        
        sendData = msg.getBytes();
        
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPserver, 8708);
        long tempoIda = System.currentTimeMillis();
        clienteSocket.send(sendPacket);
        System.out.println("Tempo de ida: " + tempoIda + ".");
        
        DatagramPacket resposta = new DatagramPacket(rcvData, rcvData.length);
        clienteSocket.receive(resposta);
        long tempoVolta = System.currentTimeMillis();
        String r = new String(resposta.getData());
        System.out.println("Tempo de volta: " + tempoVolta + ".");
        double rtt = tempoVolta - tempoIda;

        System.out.println("Resposta recebida: " + r);
        System.out.printf("RTT: %.15f.\n", rtt);
        clienteSocket.close();
        System.out.println("Encerrando a conexão...\nBye bye.");

    }

}    
