/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;
import java.awt.Color;

/**
 *
 * @author abdurahmanomar
 */
public class FallOff extends DynamicBody {
                            
    /**
     *
     * @param world
     * @param s
     */
    public FallOff(World world, Shape s) {
        super(world, s);
        setFillColor(Color.black);
        setGravityScale(0);
    }
    
}
