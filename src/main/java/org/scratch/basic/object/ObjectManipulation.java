package org.scratch.basic.object;

import java.util.List;
import java.util.Objects;

/**
 * Common object manipulations
 */
public class ObjectManipulation {
    
    /**
     * Checking for nullnes of list and content
     */
    public <T> boolean containsNulls(final List<T> integers) {
        return Boolean.logicalOr(Objects.isNull(integers), integers.stream().anyMatch(Objects::isNull));
    }
    
}
