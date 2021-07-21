/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 *
 * @author abdurahmanomar
 * 
 * 
 */

public class Explosive extends Walker {

    private static final float radius = 1.0f;
    private static final Shape shape = new PolygonShape(-0.146f,1.345f, -1.349f,0.898f,
            -1.341f,0.017f, -1.276f,-1.323f, -0.481f,-1.354f, 1.255f,-1.341f,
            1.139f,0.705f, 0.859f,1.302f);
    
    private static final BodyImage explosiveImage =
        new BodyImage("data/explosive.png",2.75f);

    /**
     * The enemy character is created.
     * @param world the world in which this body exists.
     */
    public Explosive(World world) {
        super(world, shape);
        addImage(explosiveImage);
        
    }
}



