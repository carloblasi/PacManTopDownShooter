package Game;

import static Game.Game.enemyPositionX;
import static Game.Game.enemyPositionY;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

/**
 * Rappresenta il server che ha il compito di inviare a intervalli regolari le posizioni dei nuovi nemici
 * in una parita multiplayer.
 * @author carloblasi
 */
public class UDPServerThread extends Thread {

    private static HashMap<Integer, InetAddress> portMap = new HashMap<>();
    private DatagramSocket udpServerSocket;
    private int clientsConnected = 0, clientsToConnect;
    private byte[] sendData = new byte[128];
    private String sendString = "";
    private InetAddress clientIP = null;
    private int clientPort;
    public boolean canSpawnEnemy = true;
    private boolean isRunning;

    /**
     * Inizializza un server UDP con la porta specificata e il numero di clients che devono connettersi
     * @param serverPort il numero di porta su cui il server deve stare in ascolto
     * @param clientsToConnect il numero di clients che devono connettersi al server
     */
    public UDPServerThread(int serverPort, int clientsToConnect) {

        this.clientsToConnect = clientsToConnect;
        try {
            udpServerSocket = new DatagramSocket(serverPort);
        } catch (SocketException e) {
            System.out.println("Error starting server");
        }
        System.out.println("Server started...");
        this.isRunning = true;
    }

    public void close() {

        this.isRunning = false;
        this.udpServerSocket.close();
        this.portMap.clear();
        //this.interrupt();
    }

    public void isRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    /**
     * Aspetta che due client siano connessi, poi inizia a generare e inviare nuove posizioni per i nemici
     * in una partita multiplayer.
     */
    @Override
    public void run() {

        while (true/* && Game.connection.setting == false*/) {
            try {
                this.sleep(Game.ENEMY_DELAY);
                connect();
                createPosition();
                sendData = sendString.getBytes();

                for (Entry<Integer, InetAddress> entry : portMap.entrySet()) {

                    clientPort = entry.getKey();
                    clientIP = entry.getValue();

                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, clientPort);
                    udpServerSocket.send(sendPacket);
                }

            } catch (InterruptedException e) {
                System.out.println("Server Error sleep()");
            } catch (IOException e) {
                System.out.println("Server Error sending new enemy position");
            }
        }
    }

    /**
     * Connette il numero di clients definiti dalla variabile {@code clientsToConnect}.
     * Il server non inizia finché tutti i client non sono connessi.
     */
    private void connect() {

        while (clientsConnected != clientsToConnect) {
            try {
                byte[] receiveData = new byte[128];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // Riceve il pacchetto appena è pronto
                udpServerSocket.receive(receivePacket);

                // Converte il pacchetto in una stringa e lo stampa
                String clientMessage = (new String(receivePacket.getData())).trim();
                //System.out.println(clientMessage);

                // Stampa stati connessione
                System.out.println("Client connected - socket address: " + receivePacket.getSocketAddress());
                System.out.println("Client: \"" + clientMessage + "\"");

                // Prende l'indirizzo da dove è arrivato il pacchetto e il numero di porta
                // del client che ha inviato il pacchetto e lo aggiunge alla mappa
                portMap.put(receivePacket.getPort(), receivePacket.getAddress());
                clientsConnected = portMap.size();

            } catch (IOException | NullPointerException e) {
                System.out.println("Server Error connecting new clients");
            }
        }
    }

    /**
     * Crea una posizione random per i nemici, partendo da fuori lo schermo.
     * Genera anche un indice per il colore del nemico e un indice per dire al nemico che giocatore seguire.
     */
    private void createPosition() {

        switch (new Random().nextInt(4)) {

            case 0:
                sendString = enemyPositionX.nextInt(Window.WIDTH) + ":-90";
                break;

            case 1:
                sendString = enemyPositionX.nextInt(Window.WIDTH) + ":" + (Window.HEIGHT + 90);
                break;

            case 2:
                sendString = "-90:" + enemyPositionY.nextInt(Window.HEIGHT);
                break;

            case 3:
                sendString = (Window.WIDTH + 90) + ":" + enemyPositionY.nextInt(Window.HEIGHT);
                break;
        }
        sendString += ":" + new Random().nextInt(4);
        sendString += ":" + new Random().nextInt(2);
    }
}
