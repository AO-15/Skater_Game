/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import java.awt.Color;

/**
 *
 * @author abdurahmanomar
 */
public class Danger extends DynamicBody {
    
        private static final Shape shape = new BoxShape(2,0.5f);
    
    /**
     *
     * @param world
     * @param shape
     */
    public Danger(World world, Shape shape) {
        super(world, shape);
        setFillColor(Color.red);

    }
}
