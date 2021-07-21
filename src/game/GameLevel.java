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
 */
public abstract class GameLevel extends World {
    Skater skater;
    
    /**
     *Getter for player.
     * @return
     */
    public Skater getPlayer() {
        return skater;
    }
    
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     * @param game
     */
    public void populate(Game game) {
        skater = new Skater(this);
        skater.setPosition(startPosition());
        Gate gate = new Gate(this);
        gate.setPosition(gatePosition());
        gate.addCollisionListener(new GateListener(skater, game));
    }
    
    /** The initial position of the Skater Player.
     * @return  */
    public abstract Vec2 startPosition();
    
    /** The position of the exit gate.
     * @return  */
    public abstract Vec2 gatePosition();
    
}
