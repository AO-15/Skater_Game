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
 */
public class Key extends Walker  {
    
    private static final Shape shape = new PolygonShape(-0.046f,0.85f, -0.59f,0.62f,
            -0.741f,0.162f, -0.561f,-0.545f, -0.023f,-0.576f, 0.663f,-0.401f, 
            0.782f,0.141f, 0.586f,0.727f);
    
    private static final BodyImage image = new BodyImage ("data/key.png", 1.75f);
    
    /**
     * A key is constructed into the game world.
     * @param world
     */
    public Key(World world) {
        super(world, shape);
        addImage(image);
    }
    
}
