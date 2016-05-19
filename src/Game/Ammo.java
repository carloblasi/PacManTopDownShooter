package Game;

import java.util.Random;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * La classe Ammo rappresenta munizioni che possono essere raccolte da un oggetto istanza della classe Player.
 * @author carloblasi
 */
public class Ammo {

    private Image ammoImage;
    private int size = 30;
    private int x, y;
    private boolean picked = false;
    private boolean isPickable = false;

    /**
     * Crea un oggetto Ammo con una posizione random nello schermo.
     * @param gc A {@code GameContainer}
     */
    public Ammo(GameContainer gc) {

        this.isPickable = true;
        this.x = new Random().nextInt(gc.getWidth()) + 1;
        this.y = new Random().nextInt(gc.getHeight()) + 1;
        loadImage();
    }

    public Ammo() {
        this.isPickable = false;
    }

    /**
     * Carica l'immagine delle munizioni.
     */
    private void loadImage() {

        try {
            ammoImage = new Image("Images/Ammos.png");
        } catch (SlickException e) {
            System.out.println("ammoImage not found!");
        }
    }

    /**
     * Disegna le munizioni se possono essere prese e non sono ancora state prese da un oggetto istanza della classe Player.
     */
    public void render() {

        if (!this.picked)
            if (this.isPickable)
                this.ammoImage.drawCentered(this.x, this.y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getRadius() {
        return this.size;
    }

    /**
     * "Prende" le munizioni.
     */
    public void pick() {

        this.picked = true;
        this.isPickable = false;
    }

    public boolean alreadyPicked() {
        return this.picked;
    }

    public boolean isPickable() {
        return this.isPickable;
    }
}
