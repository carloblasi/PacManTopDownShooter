package Game;

import static Game.Game.menuButton;
import static Game.Game.playFont;
import static Game.Game.retryButton;
import static Game.MultiplayerMenuState.isServer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class MultiplayerGameOverState {

    public static void update(GameContainer gc, Input input, int delta, int mouseX, int mouseY) {

        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {

            if (menuButton.isPressed()) {

                Window.clear(input);
                isServer = false;
                Game.isServer = false;
                Game.state = Game.MENUSTATE;
            }

            if (retryButton.isPressed()) {

                Window.clear(input);
                Game.state = Game.MULTIPLAYERGAMEPLAYSTATE;
            }
        }

        if (input.isKeyPressed(Input.KEY_ESCAPE)) {

            Window.clear(input);
            isServer = false;
            Game.isServer = false;
            Game.state = Game.MENUSTATE;
        }

        if (input.isKeyPressed(Input.KEY_R)) {

            Window.clear(input);
            Game.state = Game.MULTIPLAYERGAMEPLAYSTATE;
        }

        menuButton.hoverEffect();
        retryButton.hoverEffect();
    }

    public static void render(GameContainer gc, Graphics g) {

        playFont.drawCenteredString(Game.winnerString, Window.HALF_WIDTH, Window.HEIGHT/4, Color.red);
        menuButton.render();
        retryButton.render();
    }
}
