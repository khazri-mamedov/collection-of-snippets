package org.scratch.basic.object;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

/**
 * Shallow and deep copy best practices
 */
public class Point implements Cloneable {
    
    @Getter
    @Setter
    private int x;
    
    @Getter
    @Setter
    private int y;
    
    @Getter
    @Setter
    private Player player;
    
    public Point() {}
    
    public Point(Player player, int x, int y) {
        this.player = player;
        this.x = x;
        this.y = y;
    }
    
    /**
     * Deep clone with JSON technique
     * @param pointToClone object to clone
     * @return deep cloned object
     * @throws IOException in case of improper JSON mapping
     */
    public Point cloneThroughJson(final Point pointToClone) throws IOException
    {
        final ObjectMapper objectMapper = new ObjectMapper();
        final String pointJson = objectMapper.writeValueAsString(pointToClone);
        
        return objectMapper.readValue(pointJson, Point.class);
    }
    
    /**
     * Default implementation for shallow copy
     * @return shallow cloned object
     * @throws CloneNotSupportedException in case of unsupported clone operation
     */
    @Override
    public Point clone() throws CloneNotSupportedException
    {
        return (Point) super.clone();
    }
}
