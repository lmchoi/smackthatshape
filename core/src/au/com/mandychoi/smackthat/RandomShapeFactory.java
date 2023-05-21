package au.com.mandychoi.smackthat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class RandomShapeFactory {
    private static final TextureAtlas atlas =
            new TextureAtlas(Gdx.files.internal("simple_shapes.atlas"));
    private static final Sprite circle = atlas.createSprite("circle_filled");
    private static final Sprite triangle = atlas.createSprite("triangle_filled");
    private static final Sprite square = atlas.createSprite("square_filled");
    private static final int SHAPE_SIZE = 64;
    private static final Array<Sprite> sprites = Array.with(circle, triangle, square);
    private static final Array<Color> colours = Array.with(Color.RED, Color.BLUE, Color.GREEN);

    public static Shape createShape() {
        int x = MathUtils.random(0, GameLevelScreen.LEVEL_WIDTH - SHAPE_SIZE);
        int y = GameLevelScreen.LEVEL_HEIGHT;
        Sprite shapeSprite = sprites.get(MathUtils.random(2));
        Color shapeColour = colours.get(MathUtils.random(2));
        return new Shape(shapeSprite, SHAPE_SIZE, SHAPE_SIZE, x, y, shapeColour);
    }
}
