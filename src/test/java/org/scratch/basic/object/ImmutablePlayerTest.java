package org.scratch.basic.object;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;

/**
 * Naming convention for tests: unitOfWork_StateUnderTest_ExpectedValue
 */
public class ImmutablePlayerTest {
    private final PlayerRole playerRole = new PlayerRole();
    private final ImmutablePlayer immutablePlayer = new ImmutablePlayer(playerRole, "John", 1);
    
    @Test
    public void construct_ImmutableObject_True() {
        assertNotSame(immutablePlayer.getPlayerRole(), playerRole);
    }
}
