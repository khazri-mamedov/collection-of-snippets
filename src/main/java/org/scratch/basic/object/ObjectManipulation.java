package org.scratch.basic.object;

import java.util.List;
import java.util.Objects;

/**
 * Common object manipulations
 */
public class ObjectManipulation {
    
    /**
     * Checking for nullness of list and content
     * @param values for checking nullness
     * @param <T> type of values in a container
     * @return true if contains null or reference is null otherwise false
     * @since 1.8
     */
    public <T> boolean containsNulls(final List<T> values) {
        return Boolean.logicalOr(Objects.isNull(values), values.stream().anyMatch(Objects::isNull));
    }
    
}
