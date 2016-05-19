package Game;

import static Game.GameFont.optionBlue;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 * Rappresenta la barra della vita disegnata vicino ad un {@code Player}.
 * @author carloblasi
 */
public class HealthBar {

    private int x, y;

    /**
     * Inizializza la barra della vita con la posizone data
     * @param x La posizione sull'asse X
     * @param y La posizione sull'asse y
     */
    public HealthBar(int x, int y) {

        this.x = x;
        this.y = y;
    }

    /**
     * Disegna la barra della vita di colore rosso e posizione fissa con la vita del giocatore
     * @param health La vita del giocatore
     * @param g La grafica del gioco
     */
    public void render(int health, Graphics g) {

        g.setColor(Color.red);
        g.fillRect(this.x, this.y, health, 10);
        g.setColor(Color.white);
    }

    /**
     * Disegna la barra della vita di colore verde con la vita del giocatore nella posizione data.
     * @param x La posizione sull'asse X
     * @param y La posizione sull'asse Y
     * @param health La vita del giocatore
     * @param g La grafica del gioco
     */
    public void render(int x, int y, int health, Graphics g) {

        g.setColor(Color.green);
        g.fillRect(x, y, health, 6);
        g.setColor(Color.white);
    }

    /**
     * Disegna la barra della vita di colore azzurro con la vita del giocatore nella posizione data.
     * @param x La posizione sull'asse X
     * @param y La posizione sull'asse Y
     * @param health La vita del giocatore
     * @param g La grafica del gioco
     * @param isAnotherPlayer Boolean per dire se la barra della vita appartiene ad un altro giocatore
     */
    public void render(int x, int y, int health, Graphics g, boolean isAnotherPlayer) {

        g.setColor(optionBlue);
        g.fillRect(x, y, health, 6);
        g.setColor(Color.white);
    }
}
