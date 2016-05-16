package Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Input;

/**
 * La classe Button rappresenta una stringa cliccabile.
 * @author carloblasi
 */
public class Button {
    
    private String text;
    private int x, y, width, heigth;
    private Color backgroundColor;
    private Color textColor;
    private int fontSize;
    private GameFont font;
    
    /**
     * 
     * @param text
     * @param x
     * @param y 
     */
    public Button(String text, int x, int y) {
        
        this.text = text;
        this.x = x;
        this.y = y;
        createFont(8);
    }
    
    /**
     * 
     * @param text
     * @param x
     * @param y
     * @param textColor 
     */
    public Button(String text, int x, int y, Color textColor) {
        
        this.text = text;
        this.x = x;
        this.y = y;
        this.textColor = textColor;
        createFont(8);
    }
    
    /**
     * Costruisce un pulsante con il testo, la dimensione, la posizione e il colore passati.
     * La dimensione del font rappresenta anche la dimensione sull'asse Y in pixel del bottone.
     * @param text Stringa che rappresenta il testo all'interno del pulsante
     * @param x Posizione sull'asse delle X
     * @param y Posizione sull'asse delle Y
     * @param fontSize Dimensione del testo del pulsante
     * @param textColor Colore del testo del pulsante
     */
    public Button(String text, int x, int y, int fontSize, Color textColor) {
        
        this.text = text;
        this.x = x;
        this.y = y;
        this.fontSize = fontSize;
        this.textColor = textColor;
        this.createFont(this.fontSize);
    }
    
    /**
     * 
     */
    public void render() {
        this.font.drawCenteredString(this.text, this.x, this.y, this.textColor);
    }
    
    /**
     * 
     * @param text 
     */
    public void render(String text) {
        this.font.drawCenteredString(text, this.x, this.y, this.textColor);
    }
    
    /**
     * 
     * @param text
     * @param x
     * @param y 
     */
    public void render(String text, int x, int y) {
        this.font.drawCenteredString(text, x, y, this.textColor);
    }
    
    /**
     * 
     * @param x
     * @param y 
     */
    public void render(int x, int y) {
        this.font.drawCenteredString(this.text, x, y, this.textColor);
    }
    
    public void setColor(Color textColor) {
        this.textColor = textColor;
    }
    
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
    
    /**
     * Controlla se il pulsante è stato cliccato
     * @param input L'{@code Input} del gioco
     * @return true se l'utente ha cliccato il bottone, false altrimenti
     */
    public boolean isPressed(Input input) {
        
        return input.getMouseX() > (this.x - this.font.getStringWidth(this.text)/2) && input.getMouseX() < (this.x + this.font.getStringWidth(this.text)/2) &&
                input.getMouseY() > (this.y - this.font.getStringHeight(this.text)/2) && input.getMouseY() < (this.y + this.font.getStringHeight(this.text)/2);
    }
    
    /**
     * Controlla se il pulsante è stato cliccato
     * @param input L'{@code Input} del gioco
     * @param x Posizione sull'asse X se il pulsante ha una posizione diversa da quella scelta nel costruttore
     * @param y Posizione sull'asse Y se il pulsante ha una posizione diversa da quella scelta nel costruttore
     * @return true se l'utente ha cliccato il bottone, false altrimenti
     */
    public boolean isPressed(Input input, int x, int y) {
        
        return input.getMouseX() > (x - this.font.getStringWidth(this.text)/2) && input.getMouseX() < (x + this.font.getStringWidth(this.text)/2) &&
                input.getMouseY() > (y - this.font.getStringHeight(this.text)/2) && input.getMouseY() < (y + this.font.getStringHeight(this.text)/2);
    }
    
    private void createFont(int fontSize) {
        this.font = new GameFont(fontSize);
    }
    
    public void setPosition(int x, int y) {
        
        this.x = x;
        this.y = y;
    }
}
