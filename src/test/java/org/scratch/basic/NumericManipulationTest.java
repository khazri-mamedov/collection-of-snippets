package org.scratch.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class NumericManipulationTest
{
    private final NumericManipulation numericManipulation = new NumericManipulation();
    
    @Test
    public void testMaxValueSuccess() {
        assertSame(numericManipulation.maxValue(10, 11), 11);
    }
}
