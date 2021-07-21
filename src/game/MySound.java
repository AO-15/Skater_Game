/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.SoundClip;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author abdurahmanomar
 * 
 * A class that allows sound to be incorporated in the game.
 */
public class MySound {

    private static SoundClip gameMusic;
    private static SoundClip collectCoin;
    private static SoundClip collectJump;
    private static SoundClip collectSpeed;
    private static SoundClip collect;
    private static SoundClip gate;
    private static SoundClip gameOver;

    static {
        try {
            collectCoin = new SoundClip("data/CollectCoin.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private int count;

    /**
     *Plays the music for game.
     */
    public MySound() {
        count = 0;
        loopMusic().loop();
    }

    /**
     * The class responsible for playing the music.
     * @return game music.
     */
    public SoundClip loopMusic() {
        count %= 2;
        if (gameMusic != null) {
            gameMusic.stop();
        }

        if (count == 0) {
            try {
                gameMusic = new SoundClip("data/music1.wav");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        } else if (count == 1) {
            try {
                gameMusic = new SoundClip("data/music2.wav");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }
        gameMusic.loop();
        count++;
        return gameMusic;
    }

    /**
     * function that stops music playing.
     */
    public void off() {
        gameMusic.pause();
    }

    /**
     * function that turn music on. 
     */
    public void on() {
        gameMusic.resume();
    }

    /**
     *Function that plays coin collecting sound.
     */
    public void playCollectCoin() {
        collectCoin.play();
    }

    /**
     *Played upon arrival at Gate.
     */
    public void playGate() {
        gate.play();
    }

    /**
     *Played when game is lost.
     */
    public void playGameOver() {
        gameOver.play();
    }
}
