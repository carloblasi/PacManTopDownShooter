package Game;

import static Game.Game.Score;
import static Game.Game.playFont;
import static Game.Game.IPFont;
import static Game.Game.menuButton;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class LeaderBoardState {

    public static GameFont titleFont = playFont;
    public static GameFont highscoreFont = IPFont;

    public static void update(GameContainer gc, Input input, int delta, int mouseX, int mouseY) throws SlickException {

        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {

            if (menuButton.isPressed(input)) {

                Window.clear(input);
                Game.state = Game.MENUSTATE;
            }
        }

        if (input.isKeyPressed(Input.KEY_ESCAPE)) {

            Window.clear(input);
            Game.state = Game.MENUSTATE;
        }
    }

    public static void render(GameContainer gc, Graphics g) throws SlickException {

        titleFont.drawCenteredString("HIGHSCORES:", Window.HALF_WIDTH, Window.HEIGHT/4, Color.white);

        Score.sortScores();
        for (int i = 0; i < Score.scoreStrings.length; i++)
            highscoreFont.drawCenteredString(Score.scoreStrings[i], Window.HALF_WIDTH - (int)(Window.WIDTH/5.8), (int)(Window.HEIGHT/2.6) + (i * 64), Color.white);

        Score.sortMultiplayerScores();
        for (int i = 0; i < Score.multiplayerScoreStrings.length; i++)
            highscoreFont.drawCenteredString(Score.multiplayerScoreStrings[i], Window.HALF_WIDTH + (int)(Window.WIDTH/5.8), (int)(Window.HEIGHT/2.6) + (i * 64), Color.white);

        menuButton.render();
    }
}
