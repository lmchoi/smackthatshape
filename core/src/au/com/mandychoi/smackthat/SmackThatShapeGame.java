package au.com.mandychoi.smackthat;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Matrix4;

public class SmackThatShapeGame extends Game {
    private SpriteBatch batch;
    private TextureAtlas atlas;

    @Override
    public void create() {
        batch = new SpriteBatch();
        // assetManager = new AssetManager();
        // assetManager.load("simple_shapes.atlas", TextureAtlas.class);
        // assetManager.update(); // true if everything has been loaded
        // atlas = assetManager.get("simple_shapes.atlas", TextureAtlas.class);
        atlas = new TextureAtlas(Gdx.files.internal("simple_shapes.atlas"));
        RandomShapeFactory shapeFactory = new RandomShapeFactory(atlas);
        this.setScreen(new GameLevelScreen(this, shapeFactory));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        atlas.dispose();
    }

    public void setupProjection(Matrix4 cameraCombined) {
        batch.setProjectionMatrix(cameraCombined);
    }

    public void beginRendering() {
        batch.begin();
    }

    public void endRendering() {
        batch.end();
    }

    public void draw(Sprite sprite) {
        sprite.draw(batch);
    }
}
