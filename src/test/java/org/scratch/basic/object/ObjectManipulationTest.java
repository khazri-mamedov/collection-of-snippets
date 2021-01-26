package org.scratch.basic.object;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Naming convention for tests: unitOfWork_StateUnderTest_ExpectedValue
 */
public class ObjectManipulationTest {
    private final ObjectManipulation objectManipulation = new ObjectManipulation();
    
    @Test
    public void containsNull_ContainsNullValues_True() {
        final List<Integer> integers = Arrays.asList(1, null, 2, null);
        
        assertTrue(objectManipulation.containsNulls(integers));
    }
    
    @Test
    public void containsNull_ContainsNonNullValues_False() {
        final List<Integer> integers = Arrays.asList(1, 2);
    
        assertFalse(objectManipulation.containsNulls(integers));
    }
}
