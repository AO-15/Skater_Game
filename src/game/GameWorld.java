package game;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 * A world with some bodies.
 */
public class GameWorld extends World {

    private Skater skater;

    /**
     * World with bodies.
     */
    public GameWorld() {
        super();

        // make the ground
        Shape groundShape = new BoxShape(100, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(-50.5f, -0.5f));
        // walls
        Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-12.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);

        // make platforms 
        Shape shape = new BoxShape(-12.5f, 0.5f);
        Shape shape2 = new BoxShape(8.5f, 0.5f);
        Shape shape3 = new BoxShape(4.5f, 0.5f);

        Body platform1 = new StaticBody(this, shape);
        platform1.setPosition(new Vec2(-35.5f, 12.5f));

        Body platform2 = new StaticBody(this, shape);
        platform2.setPosition(new Vec2(-4.5f, 24.5f));

        Body platform3 = new StaticBody(this, shape);
        platform3.setPosition(new Vec2(15, 2.5f));
        platform3.setFillColor(new Color(233, 190, 255));
        platform3.setLineColor(new Color(233, 190, 255));

        Body platform33 = new StaticBody(this, shape);
        platform33.setPosition(new Vec2(20, -2.5f));
        platform33.setFillColor(new Color(233, 190, 255));
        platform33.setLineColor(new Color(233, 190, 255));

        Body platform5 = new StaticBody(this, shape);
        platform5.setPosition(new Vec2(38, -4f));
        platform5.setFillColor(new Color(233, 190, 255));
        platform5.setLineColor(new Color(233, 190, 255));

        Body platform6 = new StaticBody(this, shape);
        platform6.setPosition(new Vec2(43, 12.5f));
        platform6.setFillColor(new Color(233, 190, 255));
        platform6.setLineColor(new Color(233, 190, 255));

        Body platform7 = new StaticBody(this, shape2);
        platform7.setPosition(new Vec2(52, 18f));
        platform7.setFillColor(new Color(233, 190, 255));
        platform7.setLineColor(new Color(233, 190, 255));

        // make a character
        skater = new Skater(this);
        skater.setPosition(new Vec2(-42.5f, 1.5f));


        SpeedBoost speedBoost = new SpeedBoost(this);
        speedBoost.setPosition(new Vec2(14f, 1.5f));
        speedBoost.addCollisionListener(new CollisionDetector(skater));

        Key key = new Key(this);
        key.setPosition(new Vec2(14f, 1.5f));
        key.addCollisionListener(new CollisionDetector(skater));

        for (int x = 0; x < 4; x++) {
            JumpBoost jumpBoost = new JumpBoost(this);
            jumpBoost.setPosition(new Vec2(-12.5f + x * 12.5f, 0.5f + 4 * x));
            jumpBoost.addCollisionListener(new CollisionDetector(skater));
        }

        for (int i = 0; i < 50; i++) {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 5 - 10, 20));
            coin.addCollisionListener(new CollisionDetector(skater));
        }
    }

    /**
     *
     * @return
     */
    public Skater getPlayer() {
        return skater;
    }
}
