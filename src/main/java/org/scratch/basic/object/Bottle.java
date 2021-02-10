package org.scratch.basic.object;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.scratch.basic.util.GeneratedIgnoreCoverage;

/**
 * Simple object for using in collections
 */
@RequiredArgsConstructor
@EqualsAndHashCode
@GeneratedIgnoreCoverage
public class Bottle implements Comparable<Bottle> {
    @Getter
    private final int id;
    
    @Getter
    private final String name;
    
    @Override
    public int compareTo(Bottle bottle) {
        return Integer.compare(id, bottle.getId());
    }
}
