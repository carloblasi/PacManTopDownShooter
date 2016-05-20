package Game;

import org.junit.Test;
import static org.junit.Assert.*;

public class AmmoTest {

    @Test
    public void testGetRadius() {

        Ammo instance = new Ammo();
        int expResult = 30;
        int result = instance.getRadius();
        assertEquals(expResult, result);
    }

    @Test
    public void testPick() {

        Ammo instance = new Ammo();
        instance.pick();
        assertEquals(instance.isPickable(), false);
    }

    @Test
    public void testAlreadyPicked() {

        Ammo instance = new Ammo();
        instance.pick();
        boolean expResult = true;
        boolean result = instance.alreadyPicked();
        assertEquals(expResult, result);
    }
}
