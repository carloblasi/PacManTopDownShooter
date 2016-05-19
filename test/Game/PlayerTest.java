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
import org.newdawn.slick.Input;

/**
 *
 * @author carloblasi
 */
public class PlayerTest {

    public PlayerTest() {
    }

    /**
     * Test of render method, of class Player.
     */
    @Test
    public void testRender() {
        System.out.println("render");
        Graphics g = null;
        Player instance = new Player();
        instance.render(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadImage method, of class Player.
     */
    @Test
    public void testLoadImage() {
        System.out.println("loadImage");
        Player instance = new Player();
        instance.loadImage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Player.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Input input = null;
        int delta = 0;
        Player instance = new Player();
        instance.update(input, delta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of detectCollisionWithEnemies method, of class Player.
     */
    @Test
    public void testDetectCollisionWithEnemies() throws Exception {
        System.out.println("detectCollisionWithEnemies");
        ArrayList<Enemy> enemies = null;
        Player instance = new Player();
        instance.detectCollisionWithEnemies(enemies);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of detectCollisionWithBullet method, of class Player.
     */
    @Test
    public void testDetectCollisionWithBullet() throws Exception {
        System.out.println("detectCollisionWithBullet");
        ArrayList<Bullet> bullets = null;
        Player instance = new Player();
        instance.detectCollisionWithBullet(bullets);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIfPickedUpAmmos method, of class Player.
     */
    @Test
    public void testCheckIfPickedUpAmmos() throws Exception {
        System.out.println("checkIfPickedUpAmmos");
        Ammo[] ammos = null;
        Player instance = new Player();
        instance.checkIfPickedUpAmmos(ammos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hit method, of class Player.
     */
    @Test
    public void testHit() {
        System.out.println("hit");
        Player instance = new Player();
        instance.hit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHealth method, of class Player.
     */
    @Test
    public void testGetHealth() {
        System.out.println("getHealth");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getHealth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Player.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Player.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAlive method, of class Player.
     */
    @Test
    public void testIsAlive() {
        System.out.println("isAlive");
        Player instance = new Player();
        boolean expResult = false;
        boolean result = instance.isAlive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCoordinates method, of class Player.
     */
    @Test
    public void testGetCoordinates() {
        System.out.println("getCoordinates");
        Player instance = new Player();
        Point expResult = null;
        Point result = instance.getCoordinates();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmmos method, of class Player.
     */
    @Test
    public void testGetAmmos() {
        System.out.println("getAmmos");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getAmmos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAmmo method, of class Player.
     */
    @Test
    public void testRemoveAmmo() {
        System.out.println("removeAmmo");
        Player instance = new Player();
        instance.removeAmmo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class Player.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reset method, of class Player.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        Player instance = new Player();
        instance.reset();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
