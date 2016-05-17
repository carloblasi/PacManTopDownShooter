package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

class UDPSenderThread extends Thread {

    private InetAddress serverIPAddress;
    private DatagramSocket udpClientSocket;
    private int serverPort;

    public UDPSenderThread(InetAddress address, int serverPort) throws SocketException {

        this.serverIPAddress = address;
        this.serverPort = serverPort;
        this.udpClientSocket = new DatagramSocket();
        this.udpClientSocket.connect(this.serverIPAddress, this.serverPort);
    }

    public DatagramSocket getSocket() {
        return this.udpClientSocket;
    }

    @Override
    public void run() {
        try {

            byte[] data = new byte[1024];
            data = "Connected".getBytes();
            DatagramPacket connectionPacket = new DatagramPacket(data, data.length, this.serverIPAddress, this.serverPort);
            this.udpClientSocket.send(connectionPacket);
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                // Messaggio da inviare
                String clientMessage = inFromUser.readLine();

                if (clientMessage.equals("."))
                    break;

                // Il messaggio
                byte[] sendData = new byte[1024];
                sendData = clientMessage.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, this.serverIPAddress, this.serverPort);

                this.udpClientSocket.send(sendPacket);
                Thread.yield();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
