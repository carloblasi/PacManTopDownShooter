/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carloblasi
 */
public class EnemyTest {

    public EnemyTest() {
    }

    /**
     * Test of update method, of class Enemy.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Point playerCoordinates = null;
        int delta = 0;
        Enemy instance = new Enemy();
        instance.update(playerCoordinates, delta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of render method, of class Enemy.
     */
    @Test
    public void testRender() {
        System.out.println("render");
        Enemy instance = new Enemy();
        instance.render();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of detectCollisionWithBullet method, of class Enemy.
     */
    @Test
    public void testDetectCollisionWithBullet() {
        System.out.println("detectCollisionWithBullet");
        ArrayList<Bullet> bullets = null;
        Enemy instance = new Enemy();
        instance.detectCollisionWithBullet(bullets);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCollidingWithBullets method, of class Enemy.
     */
    @Test
    public void testIsCollidingWithBullets_ArrayList() {
        System.out.println("isCollidingWithBullets");
        ArrayList<Bullet> bullets = null;
        Enemy instance = new Enemy();
        boolean expResult = false;
        boolean result = instance.isCollidingWithBullets(bullets);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCollidingWithBullets method, of class Enemy.
     */
    @Test
    public void testIsCollidingWithBullets_LinkedList() {
        System.out.println("isCollidingWithBullets");
        LinkedList<Bullet> bullets = null;
        Enemy instance = new Enemy();
        boolean expResult = false;
        boolean result = instance.isCollidingWithBullets(bullets);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadImage method, of class Enemy.
     */
    @Test
    public void testLoadImage_0args() {
        System.out.println("loadImage");
        Enemy instance = new Enemy();
        instance.loadImage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadImage method, of class Enemy.
     */
    @Test
    public void testLoadImage_int() {
        System.out.println("loadImage");
        int imageIndex = 0;
        Enemy instance = new Enemy();
        instance.loadImage(imageIndex);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAlive method, of class Enemy.
     */
    @Test
    public void testIsAlive() {
        System.out.println("isAlive");
        Enemy instance = new Enemy();
        boolean expResult = false;
        boolean result = instance.isAlive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Enemy.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Enemy instance = new Enemy();
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Enemy.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Enemy instance = new Enemy();
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRadius method, of class Enemy.
     */
    @Test
    public void testGetRadius() {
        System.out.println("getRadius");
        Enemy instance = new Enemy();
        int expResult = 0;
        int result = instance.getRadius();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of kill method, of class Enemy.
     */
    @Test
    public void testKill() {
        System.out.println("kill");
        Enemy instance = new Enemy();
        instance.kill();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class Enemy.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Enemy instance = new Enemy();
        instance.remove();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSpeed method, of class Enemy.
     */
    @Test
    public void testSetSpeed() {
        System.out.println("setSpeed");
        int newSpeed = 0;
        Enemy instance = new Enemy();
        instance.setSpeed(newSpeed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerToFollow method, of class Enemy.
     */
    @Test
    public void testGetPlayerToFollow() {
        System.out.println("getPlayerToFollow");
        Enemy instance = new Enemy();
        int expResult = 0;
        int result = instance.getPlayerToFollow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
