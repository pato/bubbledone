package com.bubbledone.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import java.util.List;

public class BubbleWorldRenderer {
	private BubbleWorld world;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;

	public BubbleWorldRenderer(BubbleWorld world) {
		this.world = world;

		cam = new OrthographicCamera();
		cam.setToOrtho(true, 136, 204);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
	}
	
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        List<TaskBubble> bubbles = world.getBubbles();
        
        for (TaskBubble b : bubbles) {
        	
        }

//        shapeRenderer.begin(ShapeType.Filled);
//        shapeRenderer.setColor(87 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);
//        shapeRenderer.rect(world.getRect().x, world.getRect().y,
//        		world.getRect().width, world.getRect().height);
//        shapeRenderer.end();
//
//        shapeRenderer.begin(ShapeType.Line);
//        shapeRenderer.setColor(255 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);
//        shapeRenderer.rect(world.getRect().x, world.getRect().y,
//        		world.getRect().width, world.getRect().height);
//        shapeRenderer.end();
    }
}