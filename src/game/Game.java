package game;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import org.jbox2d.common.Vec2;

/**
 * The computer game.
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;
    
    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private MyView view;
    private int level;
    private Controller controller;
    private ControlPanel controlPanel;
    private HighScore highscore; 

    /**
     *
     */
   public static String name;
    private MySound sound;

        

    /**
     * Initialise a new Game.
     */
    public Game() {

        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);

        view = new MyView(world, 900, 450);
        
       highscore = new HighScore();
sound = new MySound();

        // make a view
        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);
        // display the view in a frame
        final JFrame frame = new JFrame("Event handling");

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);

        ControlPanel controlPanel = new ControlPanel(view, world, this);
        frame.add(controlPanel, BorderLayout.SOUTH);

        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        //   view.addMouseListener(new DropKey(view, world));

        frame.addKeyListener(new Controller(world.getPlayer()));

        // uncomment to make the view track the skater
        world.addStepListener(new Tracker(view, world.getPlayer()));

        // uncomment this to make a debugging view
         JFrame debugView = new DebugViewer(world, 900, 450);
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);

        // start!
        world.start();
    }

    /**
     *
     * @return
     */
    public Skater getPlayer() {
        return world.getPlayer();
    }

    /**
     *
     * @return Number of Coins user has collected.
     */
    public int getCoins() {
        return getPlayer().getCoinCount();
    }

    /**
     *
     * @return number of keys user has collected
     */
    public int getKeys() {
        return getPlayer().getKeyCount();
    }

    /**
     *Method that progresses user to next level.
     */
    public void goNextLevel() {


        world.stop();
        level++;
        view.setBackgroundForLevel(level);


        switch (level) {
            case 2:
                world = new Level2();
                break;
            case 3:
                world = new Level3();
                break;
            case 4:
                world = new Level4();
                break;
            default:
                System.exit(0);
        }

        // fill it with bodies
        world.populate(this);
        // switch the keyboard control to the new player
        controller.setPlayer(world.getPlayer());
        // show the new world in the view
        view.setWorld(world);
        view.setPlayer(world.getPlayer());

        world.addStepListener(new Tracker(view, world.getPlayer()));
        JFrame debugView = new DebugViewer(world, 500, 500);
        world.start();
    }
    
    /**
     * Method that allows user to restart level.
     */
    public void restart() {


        world.stop();

        switch (level) {
            case 1:
                world = new Level1();
                break;
            case 2:
                world = new Level2();
                break;
            case 3:
                world = new Level3();
                break;
            case 4:
                world = new Level4();
                break;

        }

        world.populate(this);
        controller.setPlayer(world.getPlayer());
        view.setWorld(world);

        view.setPlayer(world.getPlayer());
        world.addStepListener(new Tracker(view, world.getPlayer()));
           JFrame debugView = new DebugViewer(world, 500, 500);
        world.start();

    }

    /**
     *
     * @return world
     */
    public GameLevel getWorld(){
        return world;
    }
    

    /**
     *Saves score
     * @param name
     * @throws IOException
     */
    public void saveScore(String name) throws IOException {
            this.name = name;
        highscore.writeHighScore(name, world.getPlayer().getCoinCount());

    }
    
    /**
     * Reads high score.
     */
    public void readHighscore() {highscore.readHighscore();
    }
    
    /**
     *Displays High Score through JFrame.
     */
    public void viewHighscore(){
        final JFrame frame = new JFrame("High Scores");
        frame.add(highscore);
        frame.setVisible(true);
        frame.pack();
    }
    
    /**
     * Getter for sound.
     * @return sound
     */
    public MySound getSound(){
        return sound;
    }
    


    /**
     * Run the game.
     * @param args
     */
    public static void main(String[] args) {
        new Game();

    }
}
