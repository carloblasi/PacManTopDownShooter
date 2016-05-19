/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import org.junit.Test;
import static org.junit.Assert.*;
import org.newdawn.slick.GameContainer;

/**
 *
 * @author carloblasi
 */
public class BulletTest {

    public BulletTest() {
    }

    /**
     * Test of render method, of class Bullet.
     */
    @Test
    public void testRender() {
        System.out.println("render");
        Bullet instance = new Bullet();
        instance.render();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Bullet.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        int delta = 0;
        Bullet instance = new Bullet();
        instance.update(delta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFired method, of class Bullet.
     */
    @Test
    public void testIsFired() {
        System.out.println("isFired");
        Bullet instance = new Bullet();
        boolean expResult = false;
        boolean result = instance.isFired();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFired method, of class Bullet.
     */
    @Test
    public void testSetFired() {
        System.out.println("setFired");
        Bullet instance = new Bullet();
        instance.setFired();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFromGameIfOutOfBounds method, of class Bullet.
     */
    @Test
    public void testRemoveFromGameIfOutOfBounds() {
        System.out.println("removeFromGameIfOutOfBounds");
        GameContainer gc = null;
        Bullet instance = new Bullet();
        instance.removeFromGameIfOutOfBounds(gc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOutOfBounds method, of class Bullet.
     */
    @Test
    public void testIsOutOfBounds() {
        System.out.println("isOutOfBounds");
        GameContainer gc = null;
        Bullet instance = new Bullet();
        boolean expResult = false;
        boolean result = instance.isOutOfBounds(gc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class Bullet.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Bullet instance = new Bullet();
        instance.remove();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Bullet.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Bullet instance = new Bullet();
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Bullet.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Bullet instance = new Bullet();
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRadius method, of class Bullet.
     */
    @Test
    public void testGetRadius() {
        System.out.println("getRadius");
        Bullet instance = new Bullet();
        int expResult = 0;
        int result = instance.getRadius();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
