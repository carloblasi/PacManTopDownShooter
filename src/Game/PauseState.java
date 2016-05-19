package Game;

import static Game.Game.AMMOS_DELAY;
import static Game.Game.START_DELAY;
import static Game.Game.Score;
import static Game.Game.ammos;
import static Game.Game.bulletList;
import static Game.Game.canSpawnAmmo;
import static Game.Game.enemyList;
import static Game.Game.menuButton;
import static Game.Game.paused;
import static Game.Game.player;
import static Game.Game.startDelay;
import static Game.Game.resumeButton;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author carloblasi
 */
public class PauseState {

    /**
     * Metodo generico per aggiornare la logica degli oggetti della scena
     * @param gc {@code GameContainer} del gioco
     * @param input L'input del gioco
     * @param delta {@code delta} del gioco
     * @param mouseX Coordinata X del mouse
     * @param mouseY Coordinata Y del mouse
     * @throws SlickException
     */
    public static void update(GameContainer gc, Input input, int delta, int mouseX, int mouseY) throws SlickException {

        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {

            if (menuButton.isPressed()) {

                Window.clear(input);
                startDelay = START_DELAY;
                canSpawnAmmo = AMMOS_DELAY;
                paused = false;
                player.reset();
                enemyList.clear();
                bulletList.clear();
                for (Ammo ammo : ammos) {
                    ammo.pick();
                }
                Score.resetScore();
                Game.state = Game.MENUSTATE;
            }

            if (resumeButton.isPressed()) {

                Window.clear(input);
                Game.state = Game.GAMEPLAYSTATE;
            }
        }

        if (input.isKeyPressed(Input.KEY_ESCAPE)) {

            Window.clear(input);
            startDelay = START_DELAY;
            canSpawnAmmo = AMMOS_DELAY;
            paused = false;
            player.reset();
            enemyList.clear();
            bulletList.clear();
            for (Ammo ammo : ammos) {
                ammo.pick();
            }
            Score.resetScore();
            Game.state = Game.MENUSTATE;
        }
        if (input.isKeyPressed(Input.KEY_R)) {

            Window.clear(input);
            Game.state = Game.GAMEPLAYSTATE;
        }

        resumeButton.hoverEffect();
        menuButton.hoverEffect();
    }

    public static void render(GameContainer gc, Graphics g) throws SlickException {

        resumeButton.render();
        menuButton.render();
    }
}
