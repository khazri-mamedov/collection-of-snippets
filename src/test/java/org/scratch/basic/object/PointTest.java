package org.scratch.basic.object;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Naming convention for tests: unitOfWork_StateUnderTest_ExpectedValue
 */
public class PointTest {
    private final Player player = new Player("John Doe", 21);
    private final int x = 10;
    private final int y = 20;
    private final Point point = new Point(player, x, y);
    
    @Test
    public void clone_ShallowClone_CloneReturned() throws CloneNotSupportedException {
        Point shallowClone = point.clone();
        
        assertSame(shallowClone.getX(), x);
        assertSame(shallowClone.getY(), y);
        assertSame(shallowClone.getPlayer(), player);
    }
    
    @Test
    public void cloneThroughJson_DeepClone_CloneReturned() throws IOException
    {
        Point deepClone = point.cloneThroughJson(point);
    
        assertSame(deepClone.getX(), x);
        assertSame(deepClone.getY(), y);
        assertNotSame(deepClone.getPlayer(), player);
    }
}