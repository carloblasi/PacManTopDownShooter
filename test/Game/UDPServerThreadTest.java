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
public class UDPServerThreadTest {

    public UDPServerThreadTest() {
    }

    /**
     * Test of close method, of class UDPServerThread.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        UDPServerThread instance = null;
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRunning method, of class UDPServerThread.
     */
    @Test
    public void testIsRunning() {
        System.out.println("isRunning");
        boolean isRunning = false;
        UDPServerThread instance = null;
        instance.isRunning(isRunning);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class UDPServerThread.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        UDPServerThread instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
