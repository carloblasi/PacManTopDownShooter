/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carloblasi
 */
public class ScoreManagerTest {

    public ScoreManagerTest() {
    }

    /**
     * Test of incrementScore method, of class ScoreManager.
     */
    @Test
    public void testIncrementScore() {
        System.out.println("incrementScore");
        ScoreManager instance = new ScoreManager();
        instance.incrementScore();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetScore method, of class ScoreManager.
     */
    @Test
    public void testResetScore() {
        System.out.println("resetScore");
        ScoreManager instance = new ScoreManager();
        instance.resetScore();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScore method, of class ScoreManager.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        ScoreManager instance = new ScoreManager();
        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScore method, of class ScoreManager.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        int score = 0;
        ScoreManager instance = new ScoreManager();
        instance.setScore(score);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkNewHighScore method, of class ScoreManager.
     */
    @Test
    public void testCheckNewHighScore() {
        System.out.println("checkNewHighScore");
        ScoreManager instance = new ScoreManager();
        boolean expResult = false;
        boolean result = instance.checkNewHighScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkNewMultiplayerHighScore method, of class ScoreManager.
     */
    @Test
    public void testCheckNewMultiplayerHighScore() {
        System.out.println("checkNewMultiplayerHighScore");
        ScoreManager instance = new ScoreManager();
        boolean expResult = false;
        boolean result = instance.checkNewMultiplayerHighScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortScores method, of class ScoreManager.
     */
    @Test
    public void testSortScores() {
        System.out.println("sortScores");
        ScoreManager instance = new ScoreManager();
        instance.sortScores();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortMultiplayerScores method, of class ScoreManager.
     */
    @Test
    public void testSortMultiplayerScores() {
        System.out.println("sortMultiplayerScores");
        ScoreManager instance = new ScoreManager();
        instance.sortMultiplayerScores();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveScores method, of class ScoreManager.
     */
    @Test
    public void testSaveScores() {
        System.out.println("saveScores");
        ScoreManager instance = new ScoreManager();
        instance.saveScores();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
