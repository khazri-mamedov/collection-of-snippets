package org.scratch.basic;

import java.util.function.BinaryOperator;

public class NumericManipulation {
    
    /**
     * Find max between 2 integers without Math.max() or Integer.max()
     */
    public int maxValue(int first, int second) {
        return BinaryOperator.maxBy(Integer::compare).apply(first, second);
    }
}