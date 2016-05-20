package Game;

import static Game.Game.Score;
import static Game.Game.playFont;
import static Game.Game.IPFont;
import static Game.Game.menuButton;
import static Game.Game.showMultiplayerScoresButton;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class LeaderBoardState {

    public static GameFont titleFont = playFont;
    public static GameFont highscoreFont = IPFont;
    public static boolean showMultiplayerScores = false;

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

            if (showMultiplayerScoresButton.isPressed()) {

                Window.clear(input);
                showMultiplayerScores = !showMultiplayerScores;
            }
        }

        if (input.isKeyPressed(Input.KEY_ESCAPE)) {

            Window.clear(input);
            Game.state = Game.MENUSTATE;
        }

        menuButton.hoverEffect();
        showMultiplayerScoresButton.hoverEffect();
    }

    public static void render(GameContainer gc, Graphics g) throws SlickException {

        titleFont.drawCenteredString("HIGHSCORES:", Window.HALF_WIDTH, Window.HEIGHT/4, Color.white);

        if (!showMultiplayerScores) {

            showMultiplayerScoresButton.render();
            titleFont.drawCenteredString("SINGLE PLAYER", Window.HALF_WIDTH, Window.HEIGHT/4 - Window.WIDTH/20, Color.white);
            Score.sortScores();
            for (int i = 0; i < Score.scoreStrings.length; i++)
                highscoreFont.drawCenteredString(Score.scoreStrings[i], Window.HALF_WIDTH, (int)(Window.HEIGHT/2.6) + (i * 64), Color.white);
        }
        else {

            showMultiplayerScoresButton.render("SHOW SINGLE PLAYER HIGHSCORES");
            titleFont.drawCenteredString("MULTIPLAYER", Window.HALF_WIDTH, Window.HEIGHT/4 - Window.WIDTH/20, Color.white);
            Score.sortMultiplayerScores();
            for (int i = 0; i < Score.multiplayerScoreStrings.length; i++)
                highscoreFont.drawCenteredString(Score.multiplayerScoreStrings[i], Window.HALF_WIDTH, (int)(Window.HEIGHT/2.6) + (i * 64), Color.white);
        }

        menuButton.render();
    }
}
