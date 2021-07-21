package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 */
public class Tracker implements StepListener {
    /** The view */
    private WorldView view;

    /** The body */
    private Body body;

    /**
     *
     * @param view
     * @param body
     */
    public Tracker(WorldView view, Body body) {
        this.view = view;
        this.body = body;
    }

    /**
     *
     * @param e
     */
    @Override
    public void preStep(StepEvent e) {
    }

    /**
     *
     * @param e
     */
    @Override
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(body.getPosition()));
    }
    
}
