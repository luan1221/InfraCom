import java.io.*;
import java.net.*;


public class UDPserver {
    public static void main(String[] args) throws IOException {
        DatagramSocket servidorSocket = new DatagramSocket(8708);
        System.out.println("Estabelecido o Socket UDP servidor com número de porta 8708.\n======================================\n======================================");
        
        byte[] receiveData = new byte[2000];
        byte[] sendData = new byte[2000];
        
        InetAddress clienteIP;
        int port;
        System.out.println("Inicializando a conexão com o cliente UDP...\n======================================\n======================================");
        
        while (true) {
            
            DatagramPacket recvPacket = new DatagramPacket(receiveData, receiveData.length);
            servidorSocket.receive(recvPacket);
            System.out.println("Pacote recebido com sucesso!\n");
            clienteIP = recvPacket.getAddress();
            port = recvPacket.getPort();
            
            String s = "Olá, como posso ajudá-lo?";
            sendData = s.getBytes();
            DatagramPacket send = new DatagramPacket(sendData, sendData.length, clienteIP, port);
            servidorSocket.send(send);
            System.out.println("Respondendo ao cliente UDP...\n======================================\n======================================");




        }

    }
}