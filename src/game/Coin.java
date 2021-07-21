/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author abdurahmanomar
 * 
 * Class of the collectable coins. 
 */
public class Coin extends DynamicBody {
    

    private static final Shape shape = new PolygonShape(-0.407f,0.605f, -0.78f,0.23f, 
            -0.77f,-0.282f, -0.464f,-0.609f, 0.309f,-0.616f, 0.711f,-0.232f,
            0.616f,0.282f, 0.239f,0.616f);
    
   private static final BodyImage image = new BodyImage ("data/coin.png", 1.25f);
    
    /**
     *Initialisation of the class Coin which inherits DynamicBody.
     * @param world
     */
    public Coin(World world) {
        super(world, shape);
        addImage(image);

    }
}
    
