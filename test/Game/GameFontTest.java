/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import org.junit.Test;
import static org.junit.Assert.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

/**
 *
 * @author carloblasi
 */
public class GameFontTest {

    public GameFontTest() {
    }

    /**
     * Test of drawCenteredString method, of class GameFont.
     */
    @Test
    public void testDrawCenteredString() {
        System.out.println("drawCenteredString");
        String string = "";
        int x = 0;
        int y = 0;
        Color color = null;
        GameFont instance = null;
        instance.drawCenteredString(string, x, y, color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawString method, of class GameFont.
     */
    @Test
    public void testDrawString() {
        System.out.println("drawString");
        String string = "";
        int x = 0;
        int y = 0;
        Color color = null;
        GameFont instance = null;
        instance.drawString(string, x, y, color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStringWidth method, of class GameFont.
     */
    @Test
    public void testGetStringWidth() {
        System.out.println("getStringWidth");
        String string = "";
        GameFont instance = null;
        int expResult = 0;
        int result = instance.getStringWidth(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStringHeight method, of class GameFont.
     */
    @Test
    public void testGetStringHeight() {
        System.out.println("getStringHeight");
        String string = "";
        GameFont instance = null;
        int expResult = 0;
        int result = instance.getStringHeight(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFont method, of class GameFont.
     */
    @Test
    public void testGetFont() {
        System.out.println("getFont");
        GameFont instance = null;
        TrueTypeFont expResult = null;
        TrueTypeFont result = instance.getFont();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
