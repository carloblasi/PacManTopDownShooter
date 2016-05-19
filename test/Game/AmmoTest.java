/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carloblasi
 */
public class AmmoTest {

    public AmmoTest() {
    }

    /**
     * Test of render method, of class Ammo.
     */
    @Test
    public void testRender() {
        System.out.println("render");
        Ammo instance = new Ammo();
        instance.render();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Ammo.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Ammo instance = new Ammo();
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Ammo.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Ammo instance = new Ammo();
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRadius method, of class Ammo.
     */
    @Test
    public void testGetRadius() {
        System.out.println("getRadius");
        Ammo instance = new Ammo();
        int expResult = 0;
        int result = instance.getRadius();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pick method, of class Ammo.
     */
    @Test
    public void testPick() {
        System.out.println("pick");
        Ammo instance = new Ammo();
        instance.pick();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alreadyPicked method, of class Ammo.
     */
    @Test
    public void testAlreadyPicked() {
        System.out.println("alreadyPicked");
        Ammo instance = new Ammo();
        boolean expResult = false;
        boolean result = instance.alreadyPicked();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPickable method, of class Ammo.
     */
    @Test
    public void testIsPickable() {
        System.out.println("isPickable");
        Ammo instance = new Ammo();
        boolean expResult = false;
        boolean result = instance.isPickable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
