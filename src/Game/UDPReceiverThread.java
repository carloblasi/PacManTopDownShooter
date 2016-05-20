package Game;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Rappresenta il thread che sta sempre in ascolto del server per la posizione di un nuovo nemico.
 * @author carloblasi
 */
class UDPReceiverThread extends Thread {

    private DatagramSocket udpClientSocket = null;
    private boolean stopped = false;
    private String serverReply;
    private String[] enemyPosition;

    /**
     * Inizializza il Receiver.
     * @param udpClientSocket Il socket sul server
     * @throws SocketException
     */
    public UDPReceiverThread(DatagramSocket udpClientSocket) throws SocketException {
        this.udpClientSocket = udpClientSocket;
    }

    public void close() {
        this.stopped = true;
    }

    /**
     * Sta sempre in ascolto per una nuova posizione, se la stringa che arriva è valida (non vuota), crea un
     * nuovo nemico nella partita multiplayer con la posizione ricevuta.
     */
    @Override
    public void run() {

        byte[] receiveData = new byte[1024];
        while (true) {

            if (this.stopped)
                return;

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            try {

                this.udpClientSocket.receive(receivePacket);
                this.serverReply = new String(receivePacket.getData(), 0, receivePacket.getLength());
                if (!this.serverReply.equals("")) {

                    enemyPosition = this.serverReply.split(":");
                    synchronized(Game.enemyList) {
                        MultiplayerGamePlayState.addEnemy(Integer.parseInt(enemyPosition[0]), Integer.parseInt(enemyPosition[1]), Integer.parseInt(enemyPosition[2]), Integer.parseInt(enemyPosition[3]));
                    }
                }
                Thread.yield();

            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}