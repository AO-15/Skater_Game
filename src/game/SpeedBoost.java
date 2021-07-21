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
public class SpeedBoost extends Walker {
        private static final Shape shape = new PolygonShape(-0.458f,0.957f, -0.988f,0.446f,
                -0.981f,-0.435f, -0.427f,-0.961f, 0.556f,-0.981f, 0.965f,-0.244f,
                0.708f,0.7f, 0.271f,0.945f);
      private static final BodyImage image = new BodyImage ("data/speed.png", 2.0f);
       
    /**
     * Create a speed boost.
     * @param world
     */
    public SpeedBoost(World world) {
        super(world, shape);
        addImage(image);
      //  setFillColor(Color.pink);
    }
    
    
}
