package au.com.mandychoi.smackthat;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class RandomShapeFactory {

    private static final int SHAPE_SIZE = 64;
    private final Array<Sprite> sprites;
    private final Array<Color> colours;

    public RandomShapeFactory(TextureAtlas atlas) {
        Sprite circle = atlas.createSprite("circle_filled");
        Sprite triangle = atlas.createSprite("triangle_filled");
        Sprite square = atlas.createSprite("square_filled");
        sprites = Array.with(circle, triangle, square);
        colours = Array.with(ColourScheme.SHAPE_RED, ColourScheme.SHAPE_BLUE, ColourScheme.SHAPE_GREEN);
    }

    public Shape createShape() {
        int x = MathUtils.random(0, GameLevelScreen.LEVEL_WIDTH - SHAPE_SIZE);
        int y = GameLevelScreen.LEVEL_HEIGHT;
        Sprite shapeSprite = sprites.get(MathUtils.random(2));
        Color shapeColour = colours.get(MathUtils.random(2));
        return new Shape(shapeSprite, SHAPE_SIZE, SHAPE_SIZE, x, y, shapeColour);
    }
}
