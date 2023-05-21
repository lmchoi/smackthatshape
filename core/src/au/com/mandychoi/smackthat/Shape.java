package au.com.mandychoi.smackthat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;

public class Shape {
    public static final int SHAPE_SIZE = 64;

    private static final TextureAtlas atlas =
            new TextureAtlas(Gdx.files.internal("simple_shapes.atlas"));
    private static final Sprite sprite = atlas.createSprite("circle_filled");

    private int x;
    private int y;
    private int width;
    private int height;

    public Shape() {
        x = MathUtils.random(0, GameLevelScreen.LEVEL_WIDTH - SHAPE_SIZE);
        y = GameLevelScreen.LEVEL_HEIGHT;
        width = SHAPE_SIZE;
        height = SHAPE_SIZE;
    }

    public void drop(float distance) {
        y -= distance;
    }

    public boolean isOutOfBounds() {
        // currently only check the floor boundary
        return (y + SHAPE_SIZE < 0);
    }

    public void draw(SmackThatShapeGame game) {
        sprite.setPosition(x, y);
        sprite.setColor(Color.BLUE);
        sprite.setSize(width, height);
        game.draw(sprite);
    }
}
