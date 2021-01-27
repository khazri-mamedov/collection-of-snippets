package org.scratch.basic.object;

import lombok.Getter;

/**
 * Immutable player object with mutable reference property
 */
public final class ImmutablePlayer {
    @Getter
    private final int playerId;
    
    @Getter
    private final String name;
    
    private final PlayerRole playerRole;
    
    public ImmutablePlayer(PlayerRole playerRole, String name, int playerId) {
        this.playerId = playerId;
        this.name = name;
        
        PlayerRole clonePlayerRole = new PlayerRole();
        clonePlayerRole.setCurrentRole(playerRole.getCurrentRole());
        clonePlayerRole.setFutureRole(playerRole.getFutureRole());
        
        this.playerRole = clonePlayerRole;
    }
    
    public PlayerRole getPlayerRole() {
        PlayerRole clonePlayerRole = new PlayerRole();
        clonePlayerRole.setCurrentRole(playerRole.getCurrentRole());
        clonePlayerRole.setFutureRole(playerRole.getFutureRole());
        
        return clonePlayerRole;
    }
}
