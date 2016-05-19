/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import org.junit.Test;
import static org.junit.Assert.*;
import org.newdawn.slick.Graphics;

/**
 *
 * @author carloblasi
 */
public class HealthBarTest {

    public HealthBarTest() {
    }

    /**
     * Test of render method, of class HealthBar.
     */
    @Test
    public void testRender_int_Graphics() {
        System.out.println("render");
        int health = 0;
        Graphics g = null;
        HealthBar instance = null;
        instance.render(health, g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of render method, of class HealthBar.
     */
    @Test
    public void testRender_4args() {
        System.out.println("render");
        int x = 0;
        int y = 0;
        int health = 0;
        Graphics g = null;
        HealthBar instance = null;
        instance.render(x, y, health, g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of render method, of class HealthBar.
     */
    @Test
    public void testRender_5args() {
        System.out.println("render");
        int x = 0;
        int y = 0;
        int health = 0;
        Graphics g = null;
        boolean isEnemy = false;
        HealthBar instance = null;
        instance.render(x, y, health, g, isEnemy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
