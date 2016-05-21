package Game;

import static Game.Game.titleImage;
import static Game.Game.leaderboardButton;
import static Game.Game.multiplayerButton;
import static Game.Game.playButton;
import static Game.Game.quitButton;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 * Rappresenta la scena del menu del gioco.
 * @author carloblasi
 */
public class MenuState {

    /**
     * Metodo generico per aggiornare la logica degli oggetti della scena
     * @param gc {@code GameContainer} del gioco
     * @param input L'input del gioco
     * @param delta {@code delta} del gioco
     * @param mouseX Coordinata X del mouse
     * @param mouseY Coordinata Y del mouse
     */
    public static void update(GameContainer gc, Input input, int delta, int mouseX, int mouseY) {

        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {

            if (playButton.isPressed()) {

                Window.clear(input);
                Game.openingSound.play();
                Game.state = Game.GAMEPLAYSTATE;
            }
            if (multiplayerButton.isPressed()) {

                Window.clear(input);
                Game.state = Game.MULTIPLAYERMENUSTATE;
                Game.IPTextField.setText("");
                Game.DestinationPortTextField.setText("");
                Game.SourcePortTextField.setText("");
            }
            if (leaderboardButton.isPressed()) {

                Window.clear(input);
                Game.state = Game.LEADERBOARDSTATE;
            }
            if (quitButton.isPressed()) {
                System.exit(0);
            }
        }

        if (input.isKeyPressed(Input.KEY_ENTER)) {

            Window.clear(input);
            Game.openingSound.play();
            Game.state = Game.GAMEPLAYSTATE;
        }
        if (input.isKeyPressed(Input.KEY_M)) {

            Window.clear(input);
            Game.state = Game.MULTIPLAYERMENUSTATE;
            Game.IPTextField.setText("");
            Game.DestinationPortTextField.setText("");
            Game.SourcePortTextField.setText("");
        }
        if (input.isKeyPressed(Input.KEY_L)) {

            Window.clear(input);
            Game.state = Game.LEADERBOARDSTATE;
        }
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            System.exit(0);
        }

        playButton.hoverEffect();
        multiplayerButton.hoverEffect();
        leaderboardButton.hoverEffect();
        quitButton.hoverEffect();
    }

    public static void render(GameContainer gc, Graphics g) {

        titleImage.drawCentered(Window.HALF_WIDTH, Window.HEIGHT/5);
        playButton.render();
        multiplayerButton.render();
        leaderboardButton.render();
        quitButton.render();
    }
}
