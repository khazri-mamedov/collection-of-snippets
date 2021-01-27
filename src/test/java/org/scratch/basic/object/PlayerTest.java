package org.scratch.basic.object;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Naming convention for tests: unitOfWork_StateUnderTest_ExpectedValue
 */
public class PlayerTest {
    private final Player player = new Player("John Doe", 1);
    private final Player anotherPlayer = new Player("John Doe", 1);
    
    @Test
    public void equals_Reflexivity_True() {
        assertEquals(player, player);
    }
    
    @Test
    public void equals_Symmetry_True() {
        assertEquals(player, anotherPlayer);
        assertEquals(anotherPlayer, player);
    }
    
    @Test
    public void equals_Transitive_True() {
        final Player thirdPlayer = new Player("John Doe", 1);
        
        assertEquals(player, anotherPlayer);
        assertEquals(anotherPlayer, thirdPlayer);
        assertEquals(player, thirdPlayer);
    }
    
    @Test
    public void equals_Null_False() {
        assertFalse(player.equals(null));
    }
    
    @Test
    public void equals_DifferentType_False() {
        final Object object = new Object();
        
        assertFalse(player.equals(object));
    }
    
    @Test
    public void equals_EqualityPropertyChanged_False() {
        anotherPlayer.setPlayerId(2);
        
        assertNotEquals(player, anotherPlayer);
    }
    
    @Test
    public void hashCode_EqualObjects_True() {
        assertEquals(player, anotherPlayer);
        assertEquals(player.hashCode(), anotherPlayer.hashCode());
    }
}
