/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * A collision listener that makes Skater lose lives during collision with other bodies.
 * @author abdurahmanomar
 */
public class DecrementLives implements CollisionListener{
private Skater skater;

    /**
     *
     * @param skater
     */
    public DecrementLives(Skater skater) {
        this.skater = skater;
    }

    /**
     *inherits collisionListener and overrides collide method upon collision.
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
      
       if((e.getOtherBody() == skater)){
           skater.decrementLives();
           e.getReportingBody().destroy();
           
       }
    }
    
}
