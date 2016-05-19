package Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;
import java.awt.FontFormatException;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;

/**
 * Rappresenta il font (di tipo TrueTypeFont) con cui è possibile scrivere stringhe sullo schermo.
 * @author carloblasi
 */
public class GameFont {

    private TrueTypeFont font;
    static Color optionBlue = new Color(0, 194, 255);

    /**
     * Inizializza il font con la dimesione data.
     * @param size dimesione del font
     */
    public GameFont(float size) {

        try {
            InputStream inputStream = ResourceLoader.getResourceAsStream("Font/BitBold.ttf");

            font = new TrueTypeFont(Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(size), true);

        } catch (FontFormatException | IOException e) {
            System.out.println("Error while loading font");
        }
    }

    /**
     * Disegna una stringa con la posizione data e il colore data, centrandola.
     * @param string La stringa da disegnare
     * @param x La posizione della stringa sull'asse X
     * @param y La posizione della stringa sull'asse Y
     * @param color Il colore del testo da scrivere
     */
    public void drawCenteredString(String string, int x, int y, Color color) {

        int width = font.getWidth(string);
        int height = font.getHeight(string);
        font.drawString(x - width/2, y - height/2, string, color);
    }

    /**
     * Disegna una stringa con la posizione data e il colore data, partendo dall'angolo in alto a sinistra.
     * @param string La stringa da disegnare
     * @param x La posizione della stringa sull'asse X
     * @param y La posizione della stringa sull'asse Y
     * @param color Il colore del testo da scrivere
     */
    public void drawString(String string, int x, int y, Color color) {
        font.drawString(x, y, string, color);
    }

    public int getStringWidth(String string) {
        return font.getWidth(string);
    }

    public int getStringHeight(String string) {
        return font.getHeight(string);
    }

    public TrueTypeFont getFont() {
        return this.font;
    }
}
