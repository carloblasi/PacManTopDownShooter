package Game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author carloblasi
 */
public class ScoreManager implements Serializable {

    private int score = 0;
    private int[] scores = {0, 0, 0, 0, 0};

    /**
     *
     */
    public String[] scoreStrings;

    /**
     *
     */
    public ScoreManager() {

        this.scoreStrings = new String[this.scores.length];
    }

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
     *
     * @return
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
     *
     * @param score
     * @return
     */
    public String getStringFromScore(int score) {

        String scoreString = Integer.toString(score);

        if (scoreString.length() < 8) {

            int diff = 8 - scoreString.length();
            for (int i = 0; i < diff; i++)
                scoreString = "0" + scoreString;
        }
        return scoreString;
    }

    /**
     *
     */
    public void sortScores() {

        int k = 0;
        for (int i = this.scores.length - 1; i >= 0; i--) {

            this.scoreStrings[k] = this.getStringFromScore(this.scores[i]);
            k++;
        }
    }

    /**
     *
     */
    public void saveScores() {

        try {
            try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("pmmtds.saves"))) {
                outStream.writeObject(this);
                System.out.println("SCORES SAVED");
            }
        } catch(IOException e) {
            System.out.println("ERROR WHILE SAVING SCORES");
        }
    }
}
