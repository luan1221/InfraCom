import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPclient {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        DatagramSocket clienteSocket = new DatagramSocket();
        InetAddress IPserver = InetAddress.getByName("localhost");
        byte[] sendData;
        byte[] rcvData = new byte[20000];
        sendData = ("1").getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPserver, 8708);
        String msg = in.nextLine();
        sendData = msg.getBytes();
        sendPacket.setData(sendData);
        clienteSocket.send(sendPacket);
        DatagramPacket resposta = new DatagramPacket(rcvData, rcvData.length);
        clienteSocket.receive(resposta);
        String r = new String(resposta.getData());
        System.out.println("Resposta recebida: " + r);

        clienteSocket.close();

    }

}    
