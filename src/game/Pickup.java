package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Pickup implements CollisionListener {
    private Skater skater;
    
    /**
     *
     * @param skater
     */
    public Pickup(Skater skater) {
        this.skater = skater;
    }

    /**
     *
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == skater) {
            skater.incrementCoinCount();
            e.getReportingBody().destroy();
        }
    }
    
}
