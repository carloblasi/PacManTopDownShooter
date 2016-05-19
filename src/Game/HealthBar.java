package Game;

import static Game.GameFont.optionBlue;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 *
 * @author carloblasi
 */
public class HealthBar {

    private int x, y;

    /**
     *
     * @param x
     * @param y
     */
    public HealthBar(int x, int y) {

        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param health
     * @param g
     */
    public void render(int health, Graphics g) {

        g.setColor(Color.red);
        g.fillRect(this.x, this.y, health, 10);
        g.setColor(Color.white);
    }

    /**
     *
     * @param x
     * @param y
     * @param health
     * @param g
     */
    public void render(int x, int y, int health, Graphics g) {

        g.setColor(Color.green);
        g.fillRect(x, y, health, 6);
        g.setColor(Color.white);
    }

    /**
     *
     * @param x
     * @param y
     * @param health
     * @param g
     * @param isEnemy
     */
    public void render(int x, int y, int health, Graphics g, boolean isEnemy) {

        g.setColor(optionBlue);
        g.fillRect(x, y, health, 6);
        g.setColor(Color.white);
    }
}
