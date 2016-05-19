package Game;

import static Game.Game.Score;
import static Game.Game.opponent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import javax.swing.JOptionPane;

/**
 * Rappresenta la connessione tra due giocatori.
 *
 * @author carloblasi
 */
public class Connection implements Runnable {

    // È un server con un metodo sendTo()
    private DatagramSocket socket;
    private boolean running;
    InetSocketAddress address;
    String opponentPosition = "";
    public boolean setting = true;
    private int opponentScreenWidth, opponentScreenHeight;
    //Info oppInfo = new Info(0, 0, 0, 0, 0);

    /**
     *
     * @param port
     * @param address
     * @throws SocketException
     */
    public void connect(int port, InetSocketAddress address) throws SocketException {
        try {
            this.socket = new DatagramSocket(port);
            this.address = address;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "INVALID ADDRESS or PORT/S", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void start() {

        this.running = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public void stop() {

        this.running = false;
        this.socket.close();
    }

    @Override
    public void run() {
        byte[] buffer = new byte[128];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        while (Game.opponent.setScreenRatio() && setting) {
            try {

                send(Integer.toString(Window.WIDTH));
                send(Integer.toString(Window.HEIGHT));

                this.socket.receive(packet);
                Game.opponentScreenWidth = Integer.parseInt(new String(buffer, 0, packet.getLength()));
                this.socket.receive(packet);
                Game.opponentScreenHeight = Integer.parseInt(new String(buffer, 0, packet.getLength()));

                opponent.setScreenRatio();
            } catch (IOException e) {
                break;
            }
        }

        while (running) {
            try {
                this.socket.receive(packet);

                if (Game.state == Game.MULTIPLAYERGAMEOVERSTATE) {
                    Score.resetScore();
                }
                this.opponentPosition = new String(buffer, 0, packet.getLength());

                //oppInfo = Info.deserialize(buffer);
                switch (this.opponentPosition) {

                    case "2":

                        MultiplayerGamePlayState.quitGame();
                        break;

                    case "3":

                        MultiplayerGamePlayState.resetGame();
                        break;

                    case "1":

                        Game.opponentFired = true;
                        break;

                    default:
                        break;
                }

            } catch (IOException e) {
                break;
            }
        }
    }

    /**
     *
     * @param msg
     * @throws IOException
     */
    public void send(String msg) throws IOException {

        try {
            byte[] buffer = msg.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            packet.setSocketAddress(this.address);

            this.socket.send(packet);
        } catch (IllegalArgumentException e) {
            //JOptionPane.showMessageDialog(null, "INVALID ADDRESS or PORT/S", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     *
     * @param ba
     * @throws IOException
     */
    public void send(byte[] ba) throws IOException {

        byte[] buffer = ba;

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        packet.setSocketAddress(this.address);

        this.socket.send(packet);
    }

    /**
     *
     * @return
     */
    public String getOpponentPosition() {
        return this.opponentPosition;
    }

    /*public Info getInfo() {
        return this.oppInfo;
    }*/
}
