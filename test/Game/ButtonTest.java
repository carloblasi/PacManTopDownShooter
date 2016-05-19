/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import org.junit.Test;
import static org.junit.Assert.*;
import org.newdawn.slick.Color;

/**
 *
 * @author carloblasi
 */
public class ButtonTest {

    public ButtonTest() {
    }

    /**
     * Test of render method, of class Button.
     */
    @Test
    public void testRender_0args() {
        System.out.println("render");
        Button instance = null;
        instance.render();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of render method, of class Button.
     */
    @Test
    public void testRender_Color() {
        System.out.println("render");
        Color textColor = null;
        Button instance = null;
        instance.render(textColor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of render method, of class Button.
     */
    @Test
    public void testRender_String() {
        System.out.println("render");
        String text = "";
        Button instance = null;
        instance.render(text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of render method, of class Button.
     */
    @Test
    public void testRender_3args() {
        System.out.println("render");
        String text = "";
        int x = 0;
        int y = 0;
        Button instance = null;
        instance.render(text, x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of render method, of class Button.
     */
    @Test
    public void testRender_int_int() {
        System.out.println("render");
        int x = 0;
        int y = 0;
        Button instance = null;
        instance.render(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class Button.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        Color textColor = null;
        Button instance = null;
        instance.setColor(textColor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFontSize method, of class Button.
     */
    @Test
    public void testSetFontSize() {
        System.out.println("setFontSize");
        int fontSize = 0;
        Button instance = null;
        instance.setFontSize(fontSize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPressed method, of class Button.
     */
    @Test
    public void testIsPressed_0args() {
        System.out.println("isPressed");
        Button instance = null;
        boolean expResult = false;
        boolean result = instance.isPressed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hoverEffect method, of class Button.
     */
    @Test
    public void testHoverEffect_0args() {
        System.out.println("hoverEffect");
        Button instance = null;
        instance.hoverEffect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hoverEffect method, of class Button.
     */
    @Test
    public void testHoverEffect_int_int() {
        System.out.println("hoverEffect");
        int x = 0;
        int y = 0;
        Button instance = null;
        instance.hoverEffect(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPressed method, of class Button.
     */
    @Test
    public void testIsPressed_int_int() {
        System.out.println("isPressed");
        int x = 0;
        int y = 0;
        Button instance = null;
        boolean expResult = false;
        boolean result = instance.isPressed(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class Button.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        int x = 0;
        int y = 0;
        Button instance = null;
        instance.setPosition(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
