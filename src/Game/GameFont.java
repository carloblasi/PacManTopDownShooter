package Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;
import java.awt.FontFormatException;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author carloblasi
 */
public class GameFont {
    
    private TrueTypeFont font;
    static Color optionBlue = new Color(0, 194, 255);
    
    /**
     *
     * @param size
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
     *
     * @param string
     * @param x
     * @param y
     * @param color
     */
    public void drawCenteredString(String string, int x, int y, Color color) {
        
        int width = font.getWidth(string);
        int height = font.getHeight(string);
        font.drawString(x - width/2, y - height/2, string, color);
    }
    
    /**
     *
     * @param string
     * @param x
     * @param y
     * @param color
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
