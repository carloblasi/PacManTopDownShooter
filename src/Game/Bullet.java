package Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;

/**
 * La classe Bullet rappresenta un proiettile che viene sparato da un oggetto istanza della classe Player.
 * @author carloblasi
 */
public class Bullet {

    private Point Coordinates = new Point(0,0);
    private boolean fired = false;
    private final float speed = 564;

    private int startX;
    private int startY;
    private int destX;
    private int destY;
    private float dx;
    private float dy;

    private int diameter = 6;
    private int radius = diameter/2;

    /**
     * Crea un oggetto Bullet che ha come coordinate iniziali il centro del {@code Player}.
     * @param startX La posizione del {@code Player} sull'asse delle X
     * @param startY La posizione del {@code Player} sull'asse delle Y
     * @param destX La posizione del puntatore del mouse sull'asse delle X
     * @param destY La posizione del puntatore del mouse sull'asse delle Y
     */
    public Bullet(int startX, int startY, int destX, int destY) {

        this.startX = startX;
        this.startY = startY;
        this.destX = destX;
        this.destY = destY;

        this.setFired();
        this.Coordinates.setLocation(this.startX, this.startY);

        float rad = (float)(Math.atan2(this.destX - this.startX, this.startY - this.destY));
        this.dx = (float) Math.sin(rad) * this.speed;
        this.dy = -(float) Math.cos(rad) * this.speed;
    }

    public Bullet() {

    }

    /**
     * Disegna il proiettile se è stato sparato da un oggetto istanza della classe Player.
     */
    public void render() {

        if (isFired())
            new Graphics().fillOval(this.Coordinates.getX() - this.radius, this.Coordinates.getY() - this.radius, this.diameter, this.diameter);
    }

    /**
     * Aggiorna la posizione del proiettile
     * @param delta {@code delta} del gioco
     */
    public void update(int delta) {
        if (isFired()) {

            float x = this.Coordinates.getX();
            float y = this.Coordinates.getY();
            x += this.dx * delta/1000;
            y += this.dy * delta/1000;
            this.Coordinates.setLocation(x, y);
        }
    }

    public boolean isFired() {
        return this.fired;
    }

    public void setFired() {
        this.fired = true;
    }

    /**
     * Rimuove (smette di disegnare) il proiettile se è uscito dallo schermo.
     * @param gc Il {@code GameContainer} del gioco
     */
    public void removeFromGameIfOutOfBounds(GameContainer gc) {

        if (this.isOutOfBounds(gc)) {

            this.fired = false;
        }
    }

    /**
     * Controlla se il proiettile è uscito o no dallo schermo.
     * @param gc Il {@code GameContainer} del gioco
     * @return true se il proiettile è uscito dallo schermo, false altrimenti
     */
    public boolean isOutOfBounds(GameContainer gc) {

        return (this.Coordinates.getX() < - 10 || this.Coordinates.getX() > gc.getWidth() + 10) ||
                (this.Coordinates.getY() < - 10 || this.Coordinates.getY() > gc.getHeight() + 10);
    }

    /**
     * Rimuove (smette di disegnare) il proiettile.
     */
    public void remove() {
        this.fired = false;
    }

    public int getX() {
        return (int)this.Coordinates.getX();
    }

    public int getY() {
        return (int)this.Coordinates.getY();
    }

    public int getRadius() {
        return this.radius;
    }
}