package org.scratch.basic;

import java.util.Objects;
import java.util.function.BinaryOperator;

/**
 * Simple numeric manipulations
 */
public class NumericManipulation {
    
    /**
     * Find max between 2 integers without Math.max() or Integer.max()
     * @param first value
     * @param second value
     * @return max among 2 values
     */
    public int maxValue(int first, int second) {
        return BinaryOperator.maxBy(Integer::compare).apply(first, second);
    }
    
    /**
     * Check range with Objects.checkIndex()
     * @param x value for checking
     * @param length from 0 to length
     * @return true if is in range otherwise false
     * @since 9
     */
    public boolean isInRange(int x, int length) {
        return Objects.checkIndex(x, length) == x;
    }
}
