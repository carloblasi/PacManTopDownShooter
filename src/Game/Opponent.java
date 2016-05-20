package Game;

import static Game.Game.mouseY;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Point;
import java.util.ConcurrentModificationException;

/**
 * Rappresenta il secondo giocatore in una partita multiplayer.
 * @author carloblasi
 */
public class Opponent {

    private Image playerImage;
    private int health = 100;
    private int rotation = 0, radius = 45;
    private Point Coordinates = new Point(Window.HALF_WIDTH, Window.HALF_HEIGHT);
    private final int damage = 10;
    private boolean alive = true;
    private HealthBar healthbar;
    static int ID = Game.players++;
    private float xRatio = 1;
    private float yRatio = 1;

    /**
     * Inizializza il secondo giocatore.
     */
    public Opponent() {

        loadImage();
        healthbar = new HealthBar(this.Coordinates.x, this.Coordinates.y);
    }

    /*public boolean setScreenRatio() {

        if (Game.opponentScreenWidth > 0 && Game.opponentScreenHeight > 0) {

            if (Window.WIDTH > Game.opponentScreenWidth)
                this.xRatio = Window.WIDTH/Game.opponentScreenWidth;
            else
                this.xRatio = Game.opponentScreenWidth/Window.WIDTH;

            if (Window.HEIGHT > Game.opponentScreenHeight)
                this.yRatio = Window.HEIGHT/Game.opponentScreenHeight;
            else
                this.yRatio = Game.opponentScreenHeight/Window.HEIGHT;

            Game.connection.setting = false;
            return true;
        }
        return false;
    }*/

    /**
     * Disegna il secondo giocaotore se è vivo.
     * @param g La grafica del gioco
     */
    public void render(Graphics g) {

        if (isAlive()) {

            playerImage.drawCentered(this.Coordinates.x, this.Coordinates.y);
            playerImage.setRotation((float)this.rotation);
            healthbar.render(this.Coordinates.x - 48/2, this.Coordinates.y - 80+30, this.getHealth()/2, g, true);
        }
    }

    /**
     * Carica l'immagine.
     */
    public void loadImage() {

        try {
            playerImage = new Image("Images/Pac Man.png");
        } catch (SlickException ex) {
            System.out.println("playerImage not found");
        }
    }

    /**
     * Aggiorna la posizione del secondo giocatore in base alle coordinate che arrivano dalla classe {@code Connection}.
     * @param oppCoordinates Coordinate in cui spostare il secondo giocatore
     * @param x Coordinata X del mouse del secondo giocatore
     * @param y Coordinata Y del mouse del secondo giocatore
     */
    public void update(Point oppCoordinates, int x, int y) {

        if (this.alive) {

            this.rotation = (int)getAngleFromPoint(new Point(x, y), this.Coordinates);

            this.Coordinates.x = (int) (oppCoordinates.x * xRatio);
            this.Coordinates.y = (int) (oppCoordinates.y * yRatio);

            if(this.Coordinates.y >= Window.HEIGHT - 45)
                this.Coordinates.y = Window.HEIGHT - 45;
            if(this.Coordinates.y <= 45)
                this.Coordinates.y = 45;
            if(this.Coordinates.x >= Window.WIDTH - 45)
                this.Coordinates.x = Window.WIDTH - 45;
            if(this.Coordinates.x <= 45)
                this.Coordinates.x = 45;

            if (health == 0)
                this.alive = false;
        }
    }

    /**
     * Controlla se il secondo giocatore ha colliso con un proiettile e diminuisce la sua vita nel caso sia successo.
     * @param bullets La lista che contiene i proiettili sparati
     * @throws SlickException
     */
    public void detectCollisionWithBullet(Bullet[] bullets) throws SlickException {

        for (Bullet bullet : bullets) {
            if (this.isAlive())
                if (Math.sqrt((bullet.getX() - this.getX()) * (bullet.getX() - this.getX()) +
                              (bullet.getY() - this.getY()) * (bullet.getY() - this.getY())) <=
                               this.radius + bullet.getRadius()) {

                    bullet.remove();
                }
        }
    }

    /**
     * Controlla se il secondo giocatore ha colliso con un proiettile e diminuisce la sua vita nel caso sia successo.
     * @param bullets La lista che contiene i proiettili sparati
     * @throws SlickException
     */
    public void detectCollisionWithBullet(ArrayList<Bullet> bullets) throws SlickException {

        Iterator<Bullet> iter = bullets.iterator();

        while (iter.hasNext()) {
            Bullet bullet = iter.next();

            if (this.isAlive())
                if (Math.sqrt((bullet.getX() - this.getX()) * (bullet.getX() - this.getX()) +
                              (bullet.getY() - this.getY()) * (bullet.getY() - this.getY())) <=
                               this.radius + bullet.getRadius()) {

                    this.hit();
                    iter.remove();
                }
        }
    }

    /**
     * Controlla se il secondo giocatore ha colliso con un nemico e diminuisce la sua vita nel caso sia successo.
     * Rimuove anche il nemico dalla lista che lo contiene.
     * @param enemies La lista che contiene i nemici ancoara vivi
     * @throws SlickException
     */
    public void detectCollisionWithEnemies(ArrayList<Enemy> enemies) throws SlickException {

        try {
            Iterator<Enemy> iter = enemies.iterator();

            while (iter.hasNext()) {
                Enemy enemy = iter.next();

                if (this.health != 0)
                    if (enemy.isAlive())
                        if (Math.sqrt((enemy.getX() - this.getX()) * (enemy.getX() - this.getX()) +
                                      (enemy.getY() - this.getY()) * (enemy.getY() - this.getY())) <=
                                       this.radius + enemy.getRadius()) {

                            iter.remove();
                            this.hit();
                        }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Poteva andare peggio...");
        }
    }

    /**
     * Calcola l'angolo (compreso tra 0 e 359 inclusi) formato dalla posizione del secondo giocatore e dalla posizione del puntatore.
     * @param firstPoint Coordinate del secondo giocatore
     * @param secondPoint Coordinate del puntatore
     * @return l'angolo
     */
    private double getAngleFromPoint(java.awt.Point firstPoint, java.awt.Point secondPoint) {

        double r;

        if (((secondPoint.x) > firstPoint.x)) //above 0 to 180 degrees
            r = (Math.atan2((secondPoint.x - firstPoint.x), (firstPoint.y - secondPoint.y)) * 180 / Math.PI) + 90;

        else if (((secondPoint.x) < firstPoint.x)) //above 180 degrees to 360/0
            r = 360 - (Math.atan2((firstPoint.x - secondPoint.x), (firstPoint.y - secondPoint.y)) * 180 / Math.PI) + 90;

        else
            r = Math.atan2(0 ,0) + 90;

        if (r == 90 && mouseY < this.Coordinates.y)
            return 270;

        return r;
    }

    /**
     * Colpisce il secondo giocatore e gli toglie un po' di vita.
     */
    public void hit() {
        health -= this.damage;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getX() {
        return (int)this.Coordinates.getX();
    }

    public int getY() {
        return (int)this.Coordinates.getY();
    }

    public boolean isAlive() {
        return this.alive;
    }

    public Point getCoordinates() {
        return this.Coordinates;
    }

    public int getID() {
        return this.ID;
    }

    /**
     * Ripristina le condizioni iniziali del secondo giocatore.
     */
    public void reset() {

        this.alive = true;
        this.health = 100;
        loadImage();
        this.Coordinates = new Point(Window.HALF_WIDTH, Window.HALF_HEIGHT);
    }
}

