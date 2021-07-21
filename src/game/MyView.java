/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;

/**
 *
 * @author abdurahmanomar
 */
public class MyView extends UserView {

    private Image background;
    private int screenWidth, screenHeight;
    private Skater skater;
    private GameLevel world;
    private BufferedImage heart;

    /**
     * Initialises the MyView class.
     * @param world
     * @param width
     * @param height
     */
    public MyView(GameLevel world, int width, int height) {
        super(world, width, height);
        skater = world.getPlayer();
        screenWidth = width;
        screenHeight = height;
        background = new ImageIcon("data/jungle.jpg").getImage();

        try {
            heart = ImageIO.read(new File("data/heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *This method sets the background for each level.
     * @param level in which the game is currently in.
     */
    public void setBackgroundForLevel(int level) {
        try {
            String filePath = "";
            if (level == 2) {
                filePath = "data/background2.png";
            }
            if (level == 3) {
                filePath = "data/background3.png";
            }
            if (level == 4) {
                filePath = "data/background4.jpg";
            }
            background = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * draws the background for the game.
     * @param g
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, screenWidth, screenHeight, this);
    }

    /**
     *Paints foreground so lives and score may be shown.
     * @param g
     */
    @Override
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(1, 5, screenWidth, 30);

        g.scale(1.5, 1.5);
        g.setColor(Color.BLACK);
        g.drawString("Lives : " + skater.getLives(), 2, 16.5f);
        int xPos = 35;
        for (int i = 1; i <= skater.getLives(); i++) {
            xPos += 25;
            g.drawImage(heart, xPos, 1, this);
        }
        g.drawString("Coins : " + skater.getCoinCount(), 165, 15.5f);
        g.drawString("Keys : " + skater.getKeyCount(), 255, 15.5f);

    }

    /**
     *
     * @param skater
     */
    public void setPlayer(Skater skater) {
        this.skater = skater;
    }

}
