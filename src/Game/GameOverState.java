package Game;

import static Game.Game.menuButton;
import static Game.Game.retryButton;
import static Game.Game.youLostImage;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author carloblasi
 */
public class GameOverState {

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
                Game.state = Game.MENUSTATE;
            }

            if (retryButton.isPressed()) {

                Window.clear(input);
                Game.openingSound.play();
                Game.state = Game.GAMEPLAYSTATE;
            }
        }

        if (input.isKeyPressed(Input.KEY_ESCAPE)) {

            Window.clear(input);
            Game.state = Game.MENUSTATE;
        }

        if (input.isKeyPressed(Input.KEY_R)) {

            Window.clear(input);
            Game.openingSound.play();
            Game.state = Game.GAMEPLAYSTATE;
        }

        menuButton.hoverEffect();
        retryButton.hoverEffect();
    }

    public static void render(GameContainer gc, Graphics g) throws SlickException {

        youLostImage.drawCentered(Window.HALF_WIDTH, Window.HEIGHT/4);
        menuButton.render();
        retryButton.render();
    }
}
