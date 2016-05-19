package Game;

import static Game.Game.Score;
import static Game.Game.ghosts;
import org.newdawn.slick.Image;
import java.awt.Point;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Rappresenta un nemico per il {@code Player}.
 * @author carloblasi
 */
public class Enemy {

    private Image ghostImage;
    private Point coordinates = new Point(0,0);
    private boolean alive = false;
    private float speed = 168;
    private float dx;
    private float dy;

    private int diameter = 84;
    private int radius = diameter/2;
    private int playerToFollow;

    /**
     * Inizializza un nemico con la posizione data.
     * @param startX la posizione X da cui parte il nemico
     * @param startY la posizione Y da cui parte il nemico
     */
    public Enemy(int startX, int startY) {//, int playerID) {

        this.coordinates.setLocation(startX, startY);
        //this.playerToFollow = playerID;
        loadImage();
    }

    /**
     * Inizializza un nemico con la posizione data per una partita multiplayer.
     * @param startX la posizione X da cui parte il nemico
     * @param startY la posizione Y da cui parte il nemico
     * @param imageIndex l'indice dell'immagine (colore) da caricare
     * @param playerToFollow può essere 0 o 1 e dice al nemico che giocatore seguire
     */
    public Enemy(int startX, int startY, int imageIndex, int playerToFollow) {//, int playerID) {

        this.coordinates.setLocation(startX, startY);
        this.playerToFollow = playerToFollow;
        loadImage(imageIndex);
    }

    public Enemy() {

    }

    /**
     * Aggiorna la posizione del nemico.
     * @param playerCoordinates coordinate del giocatore da seguire
     * @param delta {@code delta} del gioco
     */
    public void update(Point playerCoordinates, int delta) {

        float rad = (float)(Math.atan2(playerCoordinates.x - this.coordinates.getX(), this.coordinates.getY() - playerCoordinates.y));
        this.dx = (float) Math.sin(rad) * this.speed;
        this.dy = -(float) Math.cos(rad) * this.speed;

        float x = (float) this.coordinates.getX();
        float y = (float) this.coordinates.getY();
        x += this.dx * delta/1000;
        y += this.dy * delta/1000;

        this.alive = true;
        this.coordinates.setLocation(x, y);
    }

    /**
     * Disegna il nemico se è vivo.
     */
    public void render() {
        if (this.isAlive())
            this.ghostImage.drawCentered((float)this.coordinates.getX(),(float)this.coordinates.getY());
    }

    /**
     * Controlla se il nemico è entrato in contatto con un proiettile e lo rimuove nel caso
     * sia successo.
     * @param bullets la lista che contiene i proiettili sparati
     */
    public void detectCollisionWithBullet(ArrayList<Bullet> bullets) {

        Iterator<Bullet> iter = bullets.iterator();
        while (iter.hasNext()) {

            Bullet bullet = iter.next();
            if (this.isAlive() && bullet.isFired())
                if (Math.sqrt((bullet.getX() - this.getX()) * (bullet.getX() - this.getX()) +
                              (bullet.getY() - this.getY()) * (bullet.getY() - this.getY())) <=
                               this.radius + bullet.getRadius()) {

                    this.alive = false;
                    Score.incrementScore();
                    iter.remove();
                }
        }
    }

    /**
     * Controlla se ha colliso con un proiettile del Player e rimuove il proiettile in questione.
     * @param bullets L' {@code ArrayList} che contiene i proiettili sparati da controllare
     * @return true - se ha colliso con un proiettile, false altrimenti
     */
    public boolean isCollidingWithBullets(ArrayList<Bullet> bullets) {

        Iterator<Bullet> iter = bullets.iterator();
        while (iter.hasNext()) {

            Bullet bullet = iter.next();
            if (this.isAlive() && bullet.isFired())
                if (Math.sqrt((bullet.getX() - this.getX()) * (bullet.getX() - this.getX()) +
                              (bullet.getY() - this.getY()) * (bullet.getY() - this.getY())) <=
                               this.radius + bullet.getRadius()) {

                    Score.incrementScore();
                    iter.remove();
                    return true;
                }
        }
        return false;
    }

    /**
     * Controlla se ha colliso con un proiettile del Player e rimuove il proiettile in questione.
     * @param bullets La {@code LinkedList} che contiene i proiettili sparati da controllare
     * @return true - se ha colliso con un proiettile, false altrimenti
     */
    public boolean isCollidingWithBullets(LinkedList<Bullet> bullets) {

        Iterator<Bullet> iter = bullets.iterator();
        while (iter.hasNext()) {

            Bullet bullet = iter.next();
            if (this.isAlive() && bullet.isFired())
                if (Math.sqrt((bullet.getX() - this.getX()) * (bullet.getX() - this.getX()) +
                              (bullet.getY() - this.getY()) * (bullet.getY() - this.getY())) <=
                               this.radius + bullet.getRadius()) {

                    Score.incrementScore();
                    iter.remove();
                    return true;
                }
        }
        return false;
    }

    /**
     * Carica l'immagine del fantasma con un colore random.
     */
    public void loadImage() {

        Random r = new Random();
        this.ghostImage = ghosts[r.nextInt(4)];
    }

    /**
     * Carica l'immagine del fantasma con il colore determinato dall'{@code imageIndex}.
     * @param imageIndex indice dell'immagine da caricare
     */
    public void loadImage(int imageIndex) {

        this.ghostImage = ghosts[imageIndex];
    }

    public boolean isAlive() {
        return this.alive;
    }

    public int getX() {
        return (int) this.coordinates.getX();
    }

    public int getY() {
        return (int) this.coordinates.getY();
    }

    public int getRadius() {
        return this.radius;
    }

    /**
     * Uccide (smette di disegnare) il nemico e incrementa il punteggio.
     */
    public void kill() {

        this.alive = false;
        Score.incrementScore();
    }

    /**
     * Uccide (smette di disegnare) il nemico.
     */
    public void remove() {
        this.alive = false;
    }

    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }

    public int getPlayerToFollow() {
        return this.playerToFollow;
    }
}