package au.com.mandychoi.smackthat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Shape {

    private Sprite sprite;
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Shape(Sprite sprite, int width, int height, int x, int y, Color color) {
        this.sprite = sprite;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void upate() {
        drop(200 * Gdx.graphics.getDeltaTime());
    }

    private void drop(float distance) {
        y -= distance;
    }

    public boolean isOutOfBounds() {
        // currently only check the floor boundary
        return (y + height < 0);
    }

    public void draw(SmackThatShapeGame game) {
        sprite.setPosition(x, y);
        sprite.setColor(color);
        sprite.setSize(width, height);
        game.draw(sprite);
    }
}
