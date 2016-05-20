package Game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Rappresenta l'oggetto che si occupa di gestire il punteggio durante una partita e i punteggi migliori.
 * @author carloblasi
 */
public class ScoreManager implements Serializable {

    private int score = 0;
    private int[] scores = {0, 0, 0, 0, 0};
    private int[] multiplayerScores = {0, 0, 0, 0, 0};

    /**
     * I due array di stringhe di punteggi sono pubblici perché vengono usati dalla classe LeaderboardState per essere scritti su schermo
     */
    public String[] scoreStrings;
    public String[] multiplayerScoreStrings;

    /**
     * Inizializza lo ScoreManager.
     */
    public ScoreManager() {

        this.scoreStrings = new String[this.scores.length];
        this.multiplayerScoreStrings = new String[this.multiplayerScores.length];
    }

    /**
     * Aumenta il punteggio di 10.
     */
    public void incrementScore() {
        this.score += 10;
    }

    public void resetScore() {
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Controlla se il punteggio è maggiore di uno dei cinque punteggi già presenti nella leaderboard e se lo è lo inserisce nel vettore.
     * @return true se il punteggio è un nuovo record
     */
    public boolean checkNewHighScore() {

        for (int i = 0; i < this.scores.length; i++) {

            if (this.score > this.scores[i]) {

                int min = -1;
                for (int j = 0; j < this.scores.length; j++)
                    if (min > this.scores[j])
                        min = this.scores[j];

                int c = 0;
                for (int j = 0; j < this.scores.length; j++) {
                    if (this.scores[j] == min) {
                        c = j;
                        break;
                    }
                }
                this.scores[c] = this.score;
                Arrays.sort(this.scores);
                return true;
            }
        }
        return false;
    }

    /**
     * Controlla se il punteggio è maggiore di uno dei cinque punteggi già presenti nella leaderboard e se lo è lo inserisce nel vettore.
     * @return true se il punteggio è un nuovo record
     */
    public boolean checkNewMultiplayerHighScore() {

        for (int i = 0; i < this.multiplayerScores.length; i++) {

            if (this.score > this.multiplayerScores[i]) {

                int min = -1;
                for (int j = 0; j < this.multiplayerScores.length; j++)
                    if (min > this.multiplayerScores[j])
                        min = this.multiplayerScores[j];

                int c = 0;
                for (int j = 0; j < this.multiplayerScores.length; j++) {
                    if (this.multiplayerScores[j] == min) {
                        c = j;
                        break;
                    }
                }
                this.multiplayerScores[c] = this.score;
                Arrays.sort(this.multiplayerScores);
                return true;
            }
        }
        return false;
    }

    /**
     * Aggiunge di fronte al punteggio che gli viene passato come argomento gli zeri necessari per riempire lo spazio nella leaderboard.
     * È solo una cosa estetica
     * @param score
     * @return il punteggio modificato
     */
    private String getStringFromScore(int score) {

        String scoreString = Integer.toString(score);

        if (scoreString.length() < 8) {

            int diff = 8 - scoreString.length();
            for (int i = 0; i < diff; i++)
                scoreString = "0" + scoreString;
        }
        return scoreString;
    }

    /**
     * Ordina al contrario il vettore di stringhe che contiene gli score.
     */
    public void sortScores() {

        int k = 0;
        for (int i = this.scores.length - 1; i >= 0; i--) {

            this.scoreStrings[k] = this.getStringFromScore(this.scores[i]);
            k++;
        }
    }

    /**
     * Ordina al contrario il vettore di stringhe che contiene gli score.
     */
    public void sortMultiplayerScores() {

        int k = 0;
        for (int i = this.multiplayerScores.length - 1; i >= 0; i--) {

            this.multiplayerScoreStrings[k] = this.getStringFromScore(this.multiplayerScores[i]);
            k++;
        }
    }

    /**
     * Serializza l'oggetto ScoreManager.
     */
    public void saveScores() {

        try {
            try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("pmmtds.scores"))) {
                outStream.writeObject(this);
                System.out.println("SCORES SAVED");
            }
        } catch(IOException e) {
            System.out.println("ERROR WHILE SAVING SCORES");
        }
    }
}
