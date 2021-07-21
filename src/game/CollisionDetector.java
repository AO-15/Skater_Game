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
 * Collision listener that detects when the skater is colliding with other bodies.
 */
public class CollisionDetector implements CollisionListener {

    private Skater skater;
private Game game;

    /**
     *
     * @param skater
     */
    public CollisionDetector(Skater skater) {
        this.skater = skater;
    }

    /**
     *
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == skater) {
//            System.out.print("Collision Occured");

            if (e.getReportingBody() instanceof Coin) {
                skater.incrementCoinCount();
                e.getReportingBody().destroy();

            } else if (e.getReportingBody() instanceof SpeedBoost) {
                System.out.println("WOO!! Speed Boost Activated!");
                skater.startWalking(50);
                e.getReportingBody().destroy();

            } else if (e.getReportingBody() instanceof JumpBoost) {
                System.out.println("Jump Boost Activated!");
                skater.jump(15);
                e.getReportingBody().destroy();
            }

        } else if (e.getReportingBody() instanceof Key) {
            skater.incrementKeyCount();
            e.getReportingBody().destroy();

        } else if (e.getReportingBody() instanceof FallOff) {
          //  System.out.println("You have fell off... Game Over!");
            System.exit(0);

        } else if (e.getReportingBody() instanceof Danger) {

//            if (e.getReportingBody() instanceof Danger) {
            //              skater.decrementLives();
            //            e.getReportingBody().destroy();
            //      }

            /*     
            }else if (e.getReportingBody() instanceof Gate){
                System.out.println("Level Complete!");
                e.getReportingBody().destroy();
            }
             */
        }

    }
}
