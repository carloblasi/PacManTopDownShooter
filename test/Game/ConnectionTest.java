package Game;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConnectionTest {

    @Test
    public void testStart() {

        Connection instance = new Connection();
        instance.start();
        assertEquals(instance.isRunning(), true);
    }

    @Test
    public void testStop() throws SocketException {

        Connection instance = new Connection();
        instance.connect(1234, InetSocketAddress.createUnresolved("localhost", 1235));
        instance.stop();
        assertEquals(instance.isRunning(), false);
    }

    @Test
    public void testGetOpponentPosition() {
        System.out.println("getOpponentPosition");
        Connection instance = new Connection();
        String expResult = "";
        String result = instance.getOpponentPosition();
        assertEquals(expResult, result);
    }

}
