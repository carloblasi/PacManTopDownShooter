package Game;

import static Game.Game.mouseY;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Point;
import java.util.ConcurrentModificationException;
import org.newdawn.slick.Sound;

/**
 * Rappresenta il giocatore sia in single player che in multiplayer.
 * @author carloblasi
 */
public class Player {

    private Image playerImage;
    private int health = 100;
    private int rotation = 0, radius = 22;
    private Point Coordinates = new Point(Window.WIDTH/2, Window.HEIGHT/2);
    private final int speed = 324, damage = 10;
    private boolean alive = true;
    private HealthBar healthbar;
    private int ammos = 50;
    private int ID = Game.players++;

    /**
     * Inizializza il giocatore.
     */
    public Player() {

        loadImage();
        this.healthbar = new HealthBar(0, 0);
    }

    /**
     * Disegna il giocatore se è vivo.
     * @param g L'oggetto grafico che permette di disegnare su schermo
     */
    public void render(Graphics g) {

        if (isAlive()) {

            this.playerImage.drawCentered(this.Coordinates.x, this.Coordinates.y);
            this.playerImage.setRotation((float)this.rotation);
            this.healthbar.render(this.Coordinates.x - 24, this.Coordinates.y - 50,/*(Window.WIDTH * this.getHealth()) / 100*/this.getHealth()/2, g);
        }
    }

    /**
     * Carica l'immagine.
     */
    public void loadImage() {

        try {
            this.playerImage = new Image("Images/Pac Man.png");
        } catch (SlickException e) {
            System.out.println("playerImage not found");
        }
    }

    /**
     * Aggiorna la posizione del giocatore in base all'input fornito.
     * @param input L'oggetto che si occupa degli input da tastiera e da mouse
     * @param delta {@code delta} del gioco
     */
    public void update(Input input, int delta) {

        if (this.alive) {

            this.rotation = (int)getAngleFromPoint(new Point(input.getMouseX(), input.getMouseY()), this.Coordinates);
            int speed = (this.speed * delta/1000);

            // RIGHT
            if(input.isKeyDown(Input.KEY_D))
                this.Coordinates.x += speed;

            // LEFT
            if(input.isKeyDown(Input.KEY_A))
                this.Coordinates.x -= speed;

            // UP
            if(input.isKeyDown(Input.KEY_W))
                this.Coordinates.y -= speed;

            // DOWN
            if(input.isKeyDown(Input.KEY_S))
                this.Coordinates.y += speed;

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
     * Controlla se il giocatore ha colliso con un nemico e diminuisce la sua vita nel caso sia successo.
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
                    if(enemy.isAlive())
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
     * Controlla se il giocatore ha colliso con un proiettile e diminuisce la sua vita nel caso sia successo.
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
     * Controlla se ha preso delle munizioni e aumenta le munizioni a disposizione se è successo.
     * @param ammos Il vettore che contiene le munizioni da prendere
     * @throws SlickException
     */
    public void checkIfPickedUpAmmos(Ammo[] ammos) throws SlickException {

        for (Ammo ammo : ammos) {
            if(this.health != 0)
                if (!ammo.alreadyPicked())
                    if (Math.sqrt((ammo.getX() - this.getX()) * (ammo.getX() - this.getX()) +
                                  (ammo.getY() - this.getY()) * (ammo.getY() - this.getY())) <=
                                   this.radius + ammo.getRadius()) {
                        ammo.pick();
                        new Sound("Sounds/pacmanPickedAmmo.wav").play();
                        this.ammos += 50;
                    }
        }
    }

    /**
     * Calcola l'angolo (compreso tra 0 e 359 inclusi) formato dalla posizione del giocatore e dalla posizione del puntatore.
     * @param firstPoint Coordinate del giocatore
     * @param secondPoint Coordinate del puntatore
     * @return l'angolo
     */
    private double getAngleFromPoint(Point firstPoint, Point secondPoint) {

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
     * Colpisce il giocatore e gli toglie un po' di vita.
     */
    public void hit() {
        this.health -= this.damage;
    }

    public int getHealth() {
        return this.health;
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

    public int getAmmos() {
        return this.ammos;
    }

    public void removeAmmo() {
        this.ammos--;
    }

    public int getID() {
        return this.ID;
    }

    /**
     * Ripristina le condizioni iniziali del giocatore.
     */
    public void reset() {

        this.alive = true;
        this.health = 100;
        this.ammos = 50;
        loadImage();
        this.Coordinates = new Point(Window.WIDTH/2, Window.HEIGHT/2);
    }
}
