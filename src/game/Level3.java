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
public class Level3 extends GameLevel {

    private static final Color platformColour = Color.CYAN;

    /**
     * Populate the world.
     * @param game
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // wall
        Shape leftWallShape = new BoxShape(0.5f, 3, new Vec2(-3f, 3f));

        {
            Shape shapeStart = new BoxShape(5, 0.5f);
            Shape shape1 = new BoxShape(1, 0.5f);
            Shape shape2 = new BoxShape(2, 0.5f);
            Shape shape3 = new BoxShape(1, 1f);
            Shape shapeBig = new BoxShape(250, 10);

            Body platform1 = new StaticBody(this, shapeStart);
            platform1.setPosition(new Vec2(-10, -7));
            platform1.setFillColor(platformColour);

            Body platform2 = new StaticBody(this, shape3);
            platform2.setPosition(new Vec2(2, -2f));
            platform2.setFillColor(platformColour);

            Body platform3 = new StaticBody(this, shape2);
            platform3.setPosition(new Vec2(5, -7f));
            platform3.setFillColor(platformColour);

            Body platform4 = new StaticBody(this, shape2);
            platform4.setPosition(new Vec2(15, -2f));
            platform4.setFillColor(platformColour);

            Body platform5 = new StaticBody(this, shape2);
            platform5.setPosition(new Vec2(25, 4.5f));
            platform5.setFillColor(platformColour);
            
            Body platform6 = new StaticBody(this, shape2);
            platform6.setPosition(new Vec2(30, 10.5f));
            platform6.setFillColor(platformColour);
   
            
            for (int i = 0; i<10; i++){
            Body platform7 = new StaticBody(this, shape3);
            platform7.setPosition(new Vec2(35, 10.5f + i));
            platform7.setFillColor(platformColour);
            }
            
            Body platform8 = new StaticBody(this, shapeStart);
            platform8.setPosition(new Vec2(36.5f, 10.5f));
            platform8.setFillColor(platformColour);            
          


            Body platformBase = new StaticBody(this, shapeBig);
            platformBase.setPosition(new Vec2(100, -75.5f));
            platformBase.setFillColor(new Color(204, 0, 255));

            for (int i = 0; i < 50; i++) {
                Body coin = new Coin(this);
                coin.setPosition(new Vec2(i * 4 - 8, 10));
                coin.addCollisionListener(new Pickup(getPlayer()));
            }
        }

        SpeedBoost speedBoost = new SpeedBoost(this);
        speedBoost.setPosition(new Vec2(-13.5f, 1.5f));
        speedBoost.addCollisionListener(new CollisionDetector(skater));

        for (int i = 0; i < 5; i++) {
            Body key = new Key(this);
            key.setPosition(new Vec2(10+ i*0.5f, 10));
            key.addCollisionListener(new CollisionDetector(getPlayer()));
        }

        for (int x = 0; x < 4; x++) {
            JumpBoost jumpBoost = new JumpBoost(this);
            jumpBoost.setPosition(new Vec2(2.5f + x * 12.5f, 0.5f + 4 * x));
            jumpBoost.addCollisionListener(new CollisionDetector(skater));
        }
        
                {
            
            Body explosive = new Explosive(this);
            explosive.setPosition(new Vec2(30.5f, 12.5f));
            explosive.addCollisionListener(new DecrementLives(skater));
        }
        {
            Body explosive = new Explosive(this);
            explosive.setPosition(new Vec2(36.5f, 10.5f));
            explosive.addCollisionListener(new DecrementLives(skater));
        }


    }
        

    

    @Override
    public Vec2 startPosition() {
        return new Vec2(-10, 20);
    }

    @Override
    public Vec2 gatePosition() {
        return new Vec2(36.5f, 14.5f);
    }
}
