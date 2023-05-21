package au.com.mandychoi.smackthat;

import com.badlogic.gdx.math.MathUtils;

public class Shape {
    public static final int SHAPE_SIZE = 64;
    private int x;
    private int y;

    public Shape() {
        x = MathUtils.random(0, GameLevelScreen.LEVEL_WIDTH - SHAPE_SIZE);
        y = GameLevelScreen.LEVEL_HEIGHT;
    }

    public void drop(float distance) {
        y -= distance;
    }

    public boolean isOutOfBounds() {
        // currently only check the floor boundary
        return (y + SHAPE_SIZE < 0);
    }

    public void draw(SmackThatShapeGame game) {
        game.draw(x, y);
    }
}
