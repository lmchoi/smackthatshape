package au.com.mandychoi.smackthat;

import java.util.Iterator;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class GameLevelScreen implements Screen {
    private final SmackThatShapeGame game;
    private OrthographicCamera camera;

    private Array<Shape> shapes;
    private long lastSpawnTime;
    public static final int LEVEL_WIDTH = 800;
    public static final int LEVEL_HEIGHT = 480;

    private RandomShapeFactory shapeFactory;

    public GameLevelScreen(SmackThatShapeGame game, RandomShapeFactory shapeFactory) {
        this.game = game;
        this.shapeFactory = shapeFactory;
        shapes = new Array<Shape>();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        // setup the camera
        camera.update();
        game.setupProjection(camera.combined);

        update();
        draw();
    }

    private void update() {
        if (TimeUtils.nanoTime() - lastSpawnTime > 1000000000)
            spawnShape();

        Iterator<Shape> iter = shapes.iterator();
        while (iter.hasNext()) {
            Shape shape = iter.next();
            shape.upate();
            if (shape.isOutOfBounds())
                iter.remove();
        }
    }

    private void spawnShape() {
        Shape shape = shapeFactory.createShape();
        shapes.add(shape);
        lastSpawnTime = TimeUtils.nanoTime();
    }

    private void draw() {
        // draw
        ScreenUtils.clear(0, 0, 0, 1);
        game.beginRendering();
        for (Shape shape : shapes) {
            shape.draw(game);
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
