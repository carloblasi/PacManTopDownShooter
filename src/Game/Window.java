package Game;

import java.awt.Dimension;
import java.awt.Toolkit;
import org.newdawn.slick.Input;

/**
 *
 * @author carloblasi
 */
public class Window {
    
    public final static int WIDTH, HEIGHT, HALF_WIDTH, HALF_HEIGHT;

    static {
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        
        WIDTH = screenWidth;
        HEIGHT = screenHeight;
        HALF_WIDTH = screenWidth/2;
        HALF_HEIGHT = screenHeight/2;
    }
    
    /**
     * Resetta lo stato di tutti i tasti, inclusi quelli del mouse. 
     * @param input L'{@code Input} del gioco
     */
    static public void clear(Input input) {
        
        input.clearKeyPressedRecord();
        input.clearMousePressedRecord();
    }
}
