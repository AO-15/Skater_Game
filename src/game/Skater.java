package game;

import city.cs.engine.*;

/**
 * Simple character
 */
public class Skater extends Walker {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance. 
    // That means there is a single shape and image for all instances of the class.
 
    private static final Shape shape = new PolygonShape(-1.051f,0.949f, -1.041f
            ,-0.919f, 1.027f,-0.926f, 1.01f,0.966f);

    private static final BodyImage image =
        new BodyImage("data/skater.gif", 2.25f);

    private int coinCount;
    
    private int keyCount;

    private int lives;

    /**
     * Initialising Skater class.
     * @param world
     */
    public Skater(World world) {
        super(world, shape);
        addImage(image);
        coinCount = 0;
        keyCount = 0;
        lives = 3;
    }

    /**
     * Getter for coin count.
     * @return
     */
    public int getCoinCount() {
        return coinCount;
    }
    
    /**
     * increments coin count.
     */
    public void incrementCoinCount() {
        coinCount++;
 //       System.out.println("You Have Collected: " + coinCount + " Coins");
    }
 
    /**
     * Getter for Key.
     * @return
     */
    public int getKeyCount() {
        return keyCount;
    }
     
    /**
     *Increments Key.
     */
    public void incrementKeyCount() {
        keyCount++;
        System.out.println("Keys = " + keyCount);
    }
    
    /**
     *Getter for lives.
     * @return
     */
    public int getLives(){
        return lives;
    }
    
    /**
     * Decrements Lives
     */
    public void decrementLives() {
        lives--;
        System.out.println("Lives " + lives);
    }
        

    
}
