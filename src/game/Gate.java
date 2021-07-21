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
public class Gate extends Walker {

    private static final Shape shape = new PolygonShape(-0.01f,1.45f, -1.39f,
            1.02f, -1.34f,-1.42f, 1.38f,-1.47f, 1.38f,1.03f, 0.9f,1.41f);

    private static final BodyImage image = new BodyImage("data/gate.png", 3f);

    /**
     * Construct a gate in the world
     * @param world
     */
    public Gate(World world) {
        super(world, shape);
        addImage(image);
    }
}
