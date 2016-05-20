package Game;

import static Game.Game.input;
import org.newdawn.slick.Color;

/**
 * La classe Button rappresenta una stringa cliccabile dall'utente.
 * @author carloblasi
 */
public class Button {

    private String text;
    private int x, y;
    private Color textColor, originalColor, darkerColor;
    private int fontSize;
    private GameFont font;

    /**
     * Inizializza un pulsante con il testo e la posizione dati.
     * @param text Stringa che rappresenta il testo all'interno del pulsante
     * @param x Posizione sull'asse delle X
     * @param y Posizione sull'asse delle Y
     */
    public Button(String text, int x, int y) {

        this.text = text;
        this.x = x;
        this.y = y;
        createFont(8);
    }

    /**
     * Inizializza un pulsante con il testo, la posizione e il colore dati.
     * @param text Stringa che rappresenta il testo all'interno del pulsante
     * @param x Posizione sull'asse delle X
     * @param y Posizione sull'asse delle Y
     * @param textColor Colore del testo del pulsante
     */
    public Button(String text, int x, int y, Color textColor) {

        this.text = text;
        this.x = x;
        this.y = y;
        this.textColor = textColor;
        this.originalColor = this.textColor;
        this.darkerColor = new Color(textColor.r * 0.5f, textColor.g * 0.5f, textColor.b * 0.5f);
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
        this.originalColor = this.textColor;
        this.darkerColor =  new Color(textColor.r * 0.6f, textColor.g * 0.6f, textColor.b * 0.6f, 1.0f);
        this.createFont(this.fontSize);
    }

    /**
     * Disegna il pulsante.
     */
    public void render() {
        this.font.drawCenteredString(this.text, this.x, this.y, this.textColor);
    }

    /**
     * Disegna il pulsante con un colore diverso da quello originale.
     * @param textColor Colore del testo del pulsante
     */
    public void render(Color textColor) {
        this.font.drawCenteredString(this.text, this.x, this.y, textColor);
    }

    /**
     * Disegna il pulsante con un testo diverso da quello originale.
     * @param text Stringa che rappresenta il testo all'interno del pulsante
     */
    public void render(String text) {
        this.font.drawCenteredString(text, this.x, this.y, this.textColor);
    }

    /**
     * Disegna il pulsante con un testo diverso e una posizione diversa da quella originale.
     * @param text Stringa che rappresenta il testo all'interno del pulsante
     * @param x Posizione sull'asse delle X
     * @param y Posizione sull'asse delle Y
     */
    public void render(String text, int x, int y) {
        this.font.drawCenteredString(text, x, y, this.textColor);
    }

    /**
     * Disegna il pulsante con una posizione diversa da quella originale.
     * @param x Posizione sull'asse delle X
     * @param y Posizione sull'asse delle Y
     */
    public void render(int x, int y) {
        this.font.drawCenteredString(this.text, x, y, this.textColor);
    }

    /**
     * Cambia il colore del testo del pulsante
     * @param textColor Nuovo colore del testo
     */
    public void setColor(Color textColor) {

        this.textColor = textColor;
        this.originalColor = this.textColor;
    }

    /**
     * Cambia la dimensione del font del pulsante.
     * @param fontSize Nuova dimensione del font
     */
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * Scurisce il pulsante se l'utente ha il mouse "sopra" il pulsante.
     */
    public void hoverEffect() {

        if (input.getMouseX() > (this.x - this.font.getStringWidth(this.text)/2) && input.getMouseX() < (this.x + this.font.getStringWidth(this.text)/2) &&
            input.getMouseY() > (this.y - this.font.getStringHeight(this.text)/2) && input.getMouseY() < (this.y + this.font.getStringHeight(this.text)/2)) {

            this.textColor = this.darkerColor;
        } else {
            this.textColor = this.originalColor;
        }
    }

    /**
     * Scurisce il pulsante se l'utente ha il mouse "sopra" il pulsante quando il pulsante ha coordinate
     * da quelle originali.
     * @param x Posizione sull'asse X se il pulsante ha una posizione diversa da quella scelta nel costruttore
     * @param y Posizione sull'asse Y se il pulsante ha una posizione diversa da quella scelta nel costruttore
     */
    public void hoverEffect(int x, int y) {

        if (input.getMouseX() > (x - this.font.getStringWidth(this.text)/2) && input.getMouseX() < (x + this.font.getStringWidth(this.text)/2) &&
            input.getMouseY() > (y - this.font.getStringHeight(this.text)/2) && input.getMouseY() < (y + this.font.getStringHeight(this.text)/2)) {

            this.textColor = this.darkerColor;
        } else {
            this.textColor = this.originalColor;
        }
    }

    /**
     * Controlla se il pulsante è stato cliccato.
     * @return true se l'utente ha cliccato il bottone, false altrimenti
     */
    public boolean isPressed() {

        return input.getMouseX() > (this.x - this.font.getStringWidth(this.text)/2) && input.getMouseX() < (this.x + this.font.getStringWidth(this.text)/2) &&
                input.getMouseY() > (this.y - this.font.getStringHeight(this.text)/2) && input.getMouseY() < (this.y + this.font.getStringHeight(this.text)/2);
    }

    /**
     * Controlla se il pulsante è stato cliccato se il pulsante ha una posizione diversa da quella originale.
     * @param x Posizione sull'asse X se il pulsante ha una posizione diversa da quella scelta nel costruttore
     * @param y Posizione sull'asse Y se il pulsante ha una posizione diversa da quella scelta nel costruttore
     * @return true se l'utente ha cliccato il bottone, false altrimenti
     */
    public boolean isPressed(int x, int y) {

        return input.getMouseX() > (x - this.font.getStringWidth(this.text)/2) && input.getMouseX() < (x + this.font.getStringWidth(this.text)/2) &&
                input.getMouseY() > (y - this.font.getStringHeight(this.text)/2) && input.getMouseY() < (y + this.font.getStringHeight(this.text)/2);
    }

    /**
     * Crea il font del pulsante.
     * @param fontSize Dimensione del testo del pulsante
     */
    private void createFont(int fontSize) {
        this.font = new GameFont(fontSize);
    }

    /**
     * Cambia la posizione al pulsante.
     * @param x La nuova posizione sull'asse X
     * @param y La nuova posizione sull'asse Y
     */
    public void setPosition(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Color getColor() {
        return this.textColor;
    }
}
