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
public class GateListener implements CollisionListener {
 
    private Game game;
    private Skater skater;

    /**
     * GateListener detects collision.
     * @param skater
     * @param game
     */
    public GateListener(Skater skater, Game game) {
        this.skater = skater;
        this.game = game;
    }

    /**
     *Allows the gate to detect when skater has collided.
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        Skater skater = game.getPlayer();
        if (e.getOtherBody() == skater) {
            e.getReportingBody().destroy();
            game.goNextLevel();
        }
    }

}
