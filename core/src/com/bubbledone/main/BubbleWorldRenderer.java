package com.bubbledone.main;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.bubbledone.ui.CreateButtonRenderer;

public class BubbleWorldRenderer {
	private BubbleWorld world;
	OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;

	private TouchHandler touchHandler;

	public BubbleWorldRenderer(BubbleWorld world) {
		this.world = world;

		cam = new OrthographicCamera();
		cam.setToOrtho(true, world.getWidth(), world.getHeight());
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);

		world.getBatch().setProjectionMatrix(cam.combined);
	}

	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		world.getBatch().begin();
		//world.getBatch().draw(new Texture(Gdx.files.internal("background.jpg")),0, 0, 800, 480);
		world.getBatch().end();

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

	public void dispose() {
		shapeRenderer.dispose();
		world.getBatch().dispose();
		world.getFont().dispose();
	}
}