package org.scratch.basic.object;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Equals contract:
 * 1. Reflexivity : An Object equals to itself player.equals(player)
 * 2. Symmetry: player.equals(anotherPlayer) equals anotherPlayer.equals(player)
 * 3. Transitive: if first object equals to second and second to third then first equals third
 * 4. Consistent: Two equal objects must remain equal until one of equality properties is changed
 * 5. Null returns false
 *
 * Hashcode contract:
 * 1. Two equal objects must return the same hash code
 * 2. Two objects with the same hash code are not mandatory equal
 * 3. Consistency
 */
public class Player {
    @Getter
    @Setter
    private int playerId;
    
    @Getter
    @Setter
    private String name;
    
    public Player(String name, int playerId) {
        this.name = name;
        this.playerId = playerId;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Player anotherPlayer = (Player) obj;
    
        return this.playerId == anotherPlayer.playerId && this.name.equals(anotherPlayer.name);
    }
    
    @Override
    public int hashCode() {
        int hash = 69;
        hash = 21 * hash + this.playerId;
        hash = 21 * hash + Objects.hashCode(this.name);
        
        return hash;
    }
}
