package au.com.mandychoi.smackthat;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class GameLevelScreen implements Screen {
    private final SmackThatShapeGame game;

    private Array<Rectangle> shapes;
    private long lastSpawnTime;
    private final int shapeSize = 64;
    private final int levelWidth = 800;
    private final int levelHeight = 480;

    public GameLevelScreen(SmackThatShapeGame game) {
        this.game = game;
        shapes = new Array<Rectangle>();
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        // process input

        update();
        draw();
    }

    private void update() {
        if (TimeUtils.nanoTime() - lastSpawnTime > 1000000000)
            spawnShape();

        Iterator<Rectangle> iter = shapes.iterator();
        while (iter.hasNext()) {
            Rectangle raindrop = iter.next();
            raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
            if (raindrop.y + shapeSize < 0)
                iter.remove();
        }
    }

    private void spawnShape() {
        Rectangle shape = new Rectangle();
        shape.x = MathUtils.random(0, levelWidth - shapeSize);
        shape.y = levelHeight;
        shape.width = shapeSize;
        shape.height = shapeSize;
        shapes.add(shape);
        lastSpawnTime = TimeUtils.nanoTime();
    }

    private void draw() {
        // draw
        ScreenUtils.clear(0, 0, 0, 1);
        game.beginRendering();
        for (Rectangle shape : shapes) {
            game.draw(shape.x, shape.y);
        }
        game.endRendering();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {
        throw new UnsupportedOperationException("Unimplemented method 'pause'");
    }

    @Override
    public void resume() {
        throw new UnsupportedOperationException("Unimplemented method 'resume'");
    }

    @Override
    public void hide() {
        throw new UnsupportedOperationException("Unimplemented method 'hide'");
    }

    @Override
    public void dispose() {}
}
