package Game;

import static Game.Game.localIP;
import static Game.Game.menuButton;
import static Game.Game.playButton;
import static Game.Game.serverButton;
import static Game.Game.smallFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class MultiplayerMenuState {

    static int errorTimer = 800;
    static boolean error = false;
    static boolean isServer = false;

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

            if (menuButton.isPressed()) {

                Window.clear(input);
                Game.IPTextField.setText("");
                Game.DestinationPortTextField.setText("");
                Game.SourcePortTextField.setText("");
                isServer = false;
                Game.isServer = false;
                Game.state = Game.MENUSTATE;
            }

            if (playButton.isPressed(Window.HALF_WIDTH, Window.HEIGHT - Window.HEIGHT/4)) {

                if (Game.IPTextField.getText() != null && Game.IPTextField.getText().equals("") == false &&
                    Game.SourcePortTextField.getText() != null && Game.SourcePortTextField.getText().equals("") == false &&
                    Game.DestinationPortTextField.getText() != null && Game.DestinationPortTextField.getText().equals("") == false) {

                    Window.clear(input);
                    Game.IP = Game.IPTextField.getText();
                    Game.SourcePort = Integer.parseInt(Game.SourcePortTextField.getText());
                    Game.DestinationPort = Integer.parseInt(Game.DestinationPortTextField.getText());

                    Game.IPTextField.setText("");
                    Game.DestinationPortTextField.setText("");
                    Game.SourcePortTextField.setText("");
                    Game.multiplayerGameID++;
                    Game.state = Game.MULTIPLAYERGAMEPLAYSTATE;
                }
                else {
                    error = true;
                }
            }

            if (serverButton.isPressed()) {

                Game.isServer = !Game.isServer;
                isServer = !isServer;
            }
        }

        if (input.isKeyPressed(Input.KEY_ESCAPE)) {

            Window.clear(input);
            Game.IPTextField.setText("");
            Game.DestinationPortTextField.setText("");
            Game.SourcePortTextField.setText("");
            isServer = false;
            Game.isServer = false;
            Game.state = Game.MENUSTATE;
        }

        if (input.isKeyPressed(Input.KEY_ENTER)) {

            if (Game.IPTextField.getText() != null && Game.IPTextField.getText().equals("") == false &&
                Game.SourcePortTextField.getText() != null && Game.SourcePortTextField.getText().equals("") == false &&
                Game.DestinationPortTextField.getText() != null && Game.DestinationPortTextField.getText().equals("") == false) {

                Window.clear(input);
                Game.IP = Game.IPTextField.getText();
                Game.SourcePort = Integer.parseInt(Game.SourcePortTextField.getText());
                Game.DestinationPort = Integer.parseInt(Game.DestinationPortTextField.getText());

                Game.IPTextField.setText("");
                Game.DestinationPortTextField.setText("");
                Game.SourcePortTextField.setText("");
                Game.multiplayerGameID++;
                Game.state = Game.MULTIPLAYERGAMEPLAYSTATE;
            }
            else {
                error = true;
            }
        }

        if (error) {

            errorTimer -= delta;
            if (errorTimer < 0) {

                error = false;
                errorTimer = 800;
            }
        }

        menuButton.hoverEffect();
        playButton.hoverEffect(Window.HALF_WIDTH, Window.HEIGHT - Window.HEIGHT/4);
        serverButton.hoverEffect();
    }

    public static void render(GameContainer gc, Graphics g) {

        Game.IPTextField.render(gc, g);
        Game.DestinationPortTextField.render(gc, g);
        Game.SourcePortTextField.render(gc, g);
        Game.IPFont.drawString("IP:", Window.HALF_WIDTH - 300, Window.HALF_HEIGHT - 200, Color.white);
        Game.SourcePortFont.drawString("SOURCE PORT:", Window.HALF_WIDTH - 400, Window.HALF_HEIGHT - 120, Color.white);
        Game.DestinationPortFont.drawString("DEST. PORT:", Window.HALF_WIDTH - 380, Window.HALF_HEIGHT - 48, Color.white);
        smallFont.drawString("YOUR IP: " + localIP, Window.WIDTH/64, Window.HEIGHT/40, Color.white);
        menuButton.render();

        if (isServer) {
            serverButton.setColor(Color.green);
        } else {
            serverButton.setColor(Color.red);
        }
        serverButton.render();

        if (!error) {
            playButton.render(Window.HALF_WIDTH, Window.HEIGHT - Window.HEIGHT/4);
        }
        else {
            playButton.render("FILL ALL THE FIELDS!", Window.HALF_WIDTH, Window.HEIGHT - Window.HEIGHT/4);
        }
    }
}
