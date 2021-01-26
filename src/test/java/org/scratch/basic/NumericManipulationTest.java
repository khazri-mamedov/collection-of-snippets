package org.scratch.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Naming convention for tests: unitOfWork_StateUnderTest_ExpectedValue
 */
public class NumericManipulationTest
{
    private final NumericManipulation numericManipulation = new NumericManipulation();
    
    @Test
    public void maxValue_SecondMax_EqualsMax() {
        assertSame(numericManipulation.maxValue(10, 11), 11);
    }

    @Test
    public void isInRange_ValueInRange0ToLength_True() {
        assertTrue(numericManipulation.isInRange(5, 6));
    }
    
    @Test
    public void isInRange_ValueInRange0ToLength_False() {
        assertThrows(IndexOutOfBoundsException.class, () -> numericManipulation.isInRange(5, 1));
    }
}
