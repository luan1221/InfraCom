import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class UDPserver {
    public static void main(String[] args) throws IOException {
        DatagramSocket servidorSocket = new DatagramSocket(8708);
        System.out.println("Estabelecido o Socket UDP servidor com número de porta 8708.");
        System.out.println("================================================\n================================================");
        byte[] receiveData = new byte[2000];
        byte[] sendData;
        InetAddress clienteIP;
        int port;
        while (true) {
            System.out.println("Inicializando a conexão com o cliente UDP...");
            System.out.println("================================================\n================================================");
            DatagramPacket recvPacket = new DatagramPacket(receiveData, receiveData.length);
            servidorSocket.receive(recvPacket);
            System.out.println("Pacote recebido com sucesso!");
            clienteIP = recvPacket.getAddress();
            port = recvPacket.getPort();
            
            
            String s = "Olá, como posso ajudá-lo?";
            sendData = s.getBytes();
            DatagramPacket send = new DatagramPacket(sendData, sendData.length, clienteIP, port);
            servidorSocket.send(send);



        }

    }
}