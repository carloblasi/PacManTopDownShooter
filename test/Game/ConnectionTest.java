/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.net.InetSocketAddress;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carloblasi
 */
public class ConnectionTest {

    public ConnectionTest() {
    }

    /**
     * Test of connect method, of class Connection.
     */
    @Test
    public void testConnect() throws Exception {
        System.out.println("connect");
        int port = 0;
        InetSocketAddress address = null;
        Connection instance = new Connection();
        instance.connect(port, address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Connection.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Connection instance = new Connection();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stop method, of class Connection.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
        Connection instance = new Connection();
        instance.stop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class Connection.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Connection instance = new Connection();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of send method, of class Connection.
     */
    @Test
    public void testSend_String() throws Exception {
        System.out.println("send");
        String msg = "";
        Connection instance = new Connection();
        instance.send(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of send method, of class Connection.
     */
    @Test
    public void testSend_byteArr() throws Exception {
        System.out.println("send");
        byte[] ba = null;
        Connection instance = new Connection();
        instance.send(ba);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOpponentPosition method, of class Connection.
     */
    @Test
    public void testGetOpponentPosition() {
        System.out.println("getOpponentPosition");
        Connection instance = new Connection();
        String expResult = "";
        String result = instance.getOpponentPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
