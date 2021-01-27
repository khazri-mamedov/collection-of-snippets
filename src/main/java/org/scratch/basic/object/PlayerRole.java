package org.scratch.basic.object;

import lombok.Getter;
import lombok.Setter;

/**
 * Mutable player role
 */
public class PlayerRole {
    @Getter
    @Setter
    private String currentRole;
    
    @Getter
    @Setter
    private String futureRole;
}
