/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 *
 * @author abdurahmanomar
 */
public class Level1 extends GameLevel {

    private static final Color baseColour = new Color(0, 127, 0);
    private static final Color platformColour = new Color(0, 63, 31);

    /**
     * Populate the world.
     * @param game
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        /*{ // ground
            Shape shape = new BoxShape(3, 0.5f);
            Body ground = new StaticBody(this, shape);
            ground.setFillColor(Color.black);
            ground.setLineColor(Color.darkGray);
            ground.setPosition(new Vec2(-56.5f, -9.75f));

            // wall
            //    Shape leftWallShape = new BoxShape(0.5f, 3, new Vec2(-40.5f, 3f));
            //   Fixture leftWall = new SolidFixture(ground, leftWallShape);
        }*/

        {
            Shape shapeEasy = new BoxShape(50, 0.5f);
            Shape shapeMid = new BoxShape(5, 0.5f);
            Shape shape2 = new BoxShape(15f, 0.5f);
            Shape shapeBig = new BoxShape(250, 10);

            Body platform1 = new StaticBody(this, shapeEasy);
            platform1.setPosition(new Vec2(-10, -10.5f));
            platform1.setFillColor(platformColour);

            Body platform2 = new StaticBody(this, shapeEasy);
            platform2.setPosition(new Vec2(100, -10.5f));
            platform2.setFillColor(platformColour);

            Body platform3 = new StaticBody(this, shapeMid);
            platform3.setPosition(new Vec2(100, -3.5f));
            platform3.setFillColor(platformColour);

            Body platform4 = new StaticBody(this, shape2);
            platform4.setPosition(new Vec2(125, 6.5f));
            platform4.setFillColor(platformColour);

            Body platform5 = new StaticBody(this, shape2);
            platform5.setPosition(new Vec2(145, 10.5f));
            platform5.setFillColor(platformColour);

            Body platformBase = new StaticBody(this, shapeBig);
            platformBase.setPosition(new Vec2(100, -75.5f));
            platformBase.setFillColor(new Color(204, 0, 255));

            for (int i = 0; i < 10; i++) {
                Body coin = new Coin(this);
                coin.setPosition(new Vec2(i * 4 - 8, 10));
                coin.addCollisionListener(new Pickup(getPlayer()));
            }
        }
        {
        SpeedBoost speedBoost = new SpeedBoost(this);
        speedBoost.setPosition(new Vec2(-30.5f, 1.5f));
        speedBoost.addCollisionListener(new CollisionDetector(skater));
        }
        {
        SpeedBoost speedBoost = new SpeedBoost(this);
        speedBoost.setPosition(new Vec2(30f, 1.5f));
        speedBoost.addCollisionListener(new CollisionDetector(skater));
        }
        Key key = new Key(this);
        key.setPosition(new Vec2(20f, 12.5f));
        key.addCollisionListener(new CollisionDetector(skater));

        JumpBoost jumpBoost = new JumpBoost(this);
        jumpBoost.setPosition(new Vec2(37.5f, 1.5f));
        jumpBoost.addCollisionListener(new CollisionDetector(skater));

        Body explosive = new Explosive(this);
        explosive.setPosition(new Vec2(132.5f, 14.5f));
        explosive.addCollisionListener(new DecrementLives(skater));
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-55.5f, 5);
    }

    @Override
    public Vec2 gatePosition() {
        return new Vec2(145, 15.5f);
    }
}
