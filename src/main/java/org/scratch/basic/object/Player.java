package org.scratch.basic.object;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Equals contract:
 * <ul>
 *     <li>Reflexivity : An Object equals to itself player.equals(player)</li>
 *     <li>Symmetry: player.equals(anotherPlayer) equals anotherPlayer.equals(player)</li>
 *     <li>Transitive: if first object equals to second and second to third then first equals third</li>
 *     <li>Consistent: Two equal objects must remain equal until one of equality properties is changed</li>
 *     <li>Null returns false</li>
 * </ul>
 *
 * Hashcode contract:
 * <ul>
 *     <li>Two equal objects must return the same hash code</li>
 *     <li>Two objects with the same hash code are not mandatory equal</li>
 *     <li>Consistency</li>
 * </ul>
 */
public class Player {
    @Getter
    @Setter
    private int playerId;
    
    @Getter
    @Setter
    private String name;
    
    public Player() {}
    
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
