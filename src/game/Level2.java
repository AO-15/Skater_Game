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
public class Level2 extends GameLevel {

    private Game game;

    private static final Color platformColour = Color.DARK_GRAY;

    @Override
    public void populate(Game game) {
        super.populate(game);
//    this.game = game;

        { // ground
            Shape shape = new BoxShape(3, 0.5f);
            Body ground = new StaticBody(this, shape);
            ground.setFillColor(Color.black);
            ground.setLineColor(Color.darkGray);
            ground.setPosition(new Vec2(-20, -9.75f));

            // wall
            Shape leftWallShape = new BoxShape(0.5f, 3, new Vec2(-3f, 3f));
            Fixture leftWall = new SolidFixture(ground, leftWallShape);
        }

        {
            Shape shape = new BoxShape(4, 0.5f);
            Shape shape2 = new BoxShape(3, 0.5f);
            Shape shape3 = new BoxShape(1, 1f);
            Shape shapeBig = new BoxShape(250, 10);
            Shape shapeMid = new BoxShape(5, 0.5f);

            Body platform1 = new StaticBody(this, shape);
            platform1.setPosition(new Vec2(-10, -9.75f));
            platform1.setFillColor(platformColour);

            Body platform2 = new StaticBody(this, shape);
            platform2.setPosition(new Vec2(0, -14f));
            platform2.setFillColor(platformColour);

            Body platform3 = new StaticBody(this, shape);
            platform3.setPosition(new Vec2(12, -17f));
            platform3.setFillColor(platformColour);

            Body platform4 = new StaticBody(this, shape2);
            platform4.setPosition(new Vec2(22, -26f));
            platform4.setFillColor(platformColour);

            Body platform5 = new StaticBody(this, shape2);
            platform5.setPosition(new Vec2(35, -21f));
            platform5.setFillColor(platformColour);

            Body platform6 = new StaticBody(this, shape2);
            platform6.setPosition(new Vec2(47, -27f));
            platform6.setFillColor(platformColour);

            Body platform7 = new StaticBody(this, shapeMid);
            platform7.setPosition(new Vec2(60, -32.5f));
            platform7.setFillColor(platformColour);

            Body platform8 = new StaticBody(this, shape);
            platform8.setPosition(new Vec2(73, -25.5f));
            platform8.setFillColor(platformColour);

            Body platformBase = new StaticBody(this, shapeBig);
            platformBase.setPosition(new Vec2(100, -75.5f));
            platformBase.setFillColor(new Color(204, 0, 255));
        }
        {
            for (int i = 0; i < 50; i++) {
                Body coin = new Coin(this);
                coin.setPosition(new Vec2(i * 5 - 10, 25));
                coin.addCollisionListener(new CollisionDetector(skater));
            }
        }
        {
            
            Body explosive = new Explosive(this);
            explosive.setPosition(new Vec2(62.5f, -27.5f));
            explosive.addCollisionListener(new DecrementLives(skater));
        }
        {
            Body explosive = new Explosive(this);
            explosive.setPosition(new Vec2(52.5f, -27.5f));
            explosive.addCollisionListener(new DecrementLives(skater));
        }

    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-20, -2.5f);
    }

    @Override
    public Vec2 gatePosition() {
        return new Vec2(73, -22.5f);
    }
}
