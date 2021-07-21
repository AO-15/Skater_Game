/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/**
 *
 * @author abdurahmanomar
 */
public class JumpBoost extends Walker {
            private static final Shape shape = new PolygonShape(-0.738f,0.858f, -0.866f,0.166f,
                    -0.79f,-0.615f, -0.359f,-0.863f, 0.432f,-0.837f, 0.86f,-0.233f,
                    0.799f,0.516f, 0.353f,0.849f);
     private static final BodyImage image = new BodyImage ("data/jump.png", 1.75f);
       
    /**
     * Construct a JumpBoost.
     * @param world
     */
    public JumpBoost(World world) {
        super(world, shape);
        addImage(image);
        setFillColor(Color.green);
    }
    
}
