package Game;

import org.junit.Test;
import static org.junit.Assert.*;
import org.newdawn.slick.GameContainer;

public class BulletTest {

    @Test
    public void testSetFired() {

        Bullet instance = new Bullet();
        instance.setFired();
        assertEquals(instance.isFired(), true);
    }

    @Test
    public void testIsOutOfBounds() {

        Bullet instance = new Bullet();
        boolean expResult = false;
        boolean result = (instance.getX() < - 10 || instance.getX() > instance.getY() + 10) ||
                         (instance.getY() < - 10 || instance.getY() > Window.HEIGHT + 10);

        assertEquals(expResult, result);
    }

    @Test
    public void testRemove() {

        Bullet instance = new Bullet();
        instance.remove();
        assertEquals(instance.isFired(), false);
    }
}
