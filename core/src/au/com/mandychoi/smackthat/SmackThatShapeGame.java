package au.com.mandychoi.smackthat;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class SmackThatShapeGame extends Game {
    private SpriteBatch batch;
    private Sprite sprite;

    @Override
    public void create() {
        batch = new SpriteBatch();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("simple_shapes.atlas"));

        sprite = atlas.createSprite("circle_filled");
        sprite.setSize(64, 64);

        this.setScreen(new GameLevelScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public void beginRendering() {
        batch.begin();
    }

    public void endRendering() {
        batch.end();
    }

    public void draw(float x, float y) {
        sprite.setPosition(x, y);
        sprite.setColor(Color.BLUE);
        sprite.draw(batch);
    }
}
