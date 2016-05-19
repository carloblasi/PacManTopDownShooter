/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Point;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.newdawn.slick.Graphics;

/**
 *
 * @author carloblasi
 */
public class OpponentTest {

    public OpponentTest() {
    }

    /**
     * Test of render method, of class Opponent.
     */
    @Test
    public void testRender() {
        System.out.println("render");
        Graphics g = null;
        Opponent instance = new Opponent();
        instance.render(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadImage method, of class Opponent.
     */
    @Test
    public void testLoadImage() {
        System.out.println("loadImage");
        Opponent instance = new Opponent();
        instance.loadImage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Opponent.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Point oppCoordinates = null;
        int x = 0;
        int y = 0;
        Opponent instance = new Opponent();
        instance.update(oppCoordinates, x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of detectCollisionWithBullet method, of class Opponent.
     */
    @Test
    public void testDetectCollisionWithBullet_BulletArr() throws Exception {
        System.out.println("detectCollisionWithBullet");
        Bullet[] bullets = null;
        Opponent instance = new Opponent();
        instance.detectCollisionWithBullet(bullets);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of detectCollisionWithBullet method, of class Opponent.
     */
    @Test
    public void testDetectCollisionWithBullet_ArrayList() throws Exception {
        System.out.println("detectCollisionWithBullet");
        ArrayList<Bullet> bullets = null;
        Opponent instance = new Opponent();
        instance.detectCollisionWithBullet(bullets);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of detectCollisionWithEnemies method, of class Opponent.
     */
    @Test
    public void testDetectCollisionWithEnemies() throws Exception {
        System.out.println("detectCollisionWithEnemies");
        ArrayList<Enemy> enemies = null;
        Opponent instance = new Opponent();
        instance.detectCollisionWithEnemies(enemies);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hit method, of class Opponent.
     */
    @Test
    public void testHit() {
        System.out.println("hit");
        Opponent instance = new Opponent();
        instance.hit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHealth method, of class Opponent.
     */
    @Test
    public void testGetHealth() {
        System.out.println("getHealth");
        Opponent instance = new Opponent();
        int expResult = 0;
        int result = instance.getHealth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHealth method, of class Opponent.
     */
    @Test
    public void testSetHealth() {
        System.out.println("setHealth");
        int health = 0;
        Opponent instance = new Opponent();
        instance.setHealth(health);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Opponent.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Opponent instance = new Opponent();
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Opponent.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Opponent instance = new Opponent();
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAlive method, of class Opponent.
     */
    @Test
    public void testIsAlive() {
        System.out.println("isAlive");
        Opponent instance = new Opponent();
        boolean expResult = false;
        boolean result = instance.isAlive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCoordinates method, of class Opponent.
     */
    @Test
    public void testGetCoordinates() {
        System.out.println("getCoordinates");
        Opponent instance = new Opponent();
        Point expResult = null;
        Point result = instance.getCoordinates();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class Opponent.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Opponent instance = new Opponent();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reset method, of class Opponent.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        Opponent instance = new Opponent();
        instance.reset();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
