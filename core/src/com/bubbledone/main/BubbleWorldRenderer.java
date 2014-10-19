package com.bubbledone.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bubbledone.ui.CreateButtonRenderer;

import java.util.List;

public class BubbleWorldRenderer {
	private BubbleWorld world;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;

	public BubbleWorldRenderer(BubbleWorld world) {
		this.world = world;

		cam = new OrthographicCamera();
		cam.setToOrtho(true, world.getWidth(), world.getHeight());
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		
		world.getBatch().setProjectionMatrix(cam.combined);
		
		Gdx.input.setInputProcessor(new InputHandler(world, cam));
	}
	
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// draw attractor
		AttractorRenderer.render(world, world.getAttractor(), cam, shapeRenderer);
		
		// draw bubbles
        List<TaskBubble> bubbles = world.getBubbles();
        for (TaskBubble b : bubbles) {
        	TaskBubbleRenderer.render(world, b, cam, shapeRenderer);
        }
        
		// draw button
		CreateButtonRenderer.render(world, world.getCreateButton(), cam, shapeRenderer);
    }
}