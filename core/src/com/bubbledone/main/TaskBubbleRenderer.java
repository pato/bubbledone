package com.bubbledone.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class TaskBubbleRenderer implements Renderer {
	TaskBubble bubble;
	private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private BubbleWorld world;
	
	public TaskBubbleRenderer(TaskBubble bubble, OrthographicCamera cam,
			ShapeRenderer shapeRenderer, BubbleWorld world) {
		this.bubble = bubble;
		this.cam = cam;
		this.shapeRenderer = shapeRenderer;
		this.world = world;
	}
	
	@Override
	public void render() {
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(87 / 255.0f, 87 / 255.0f, 87 / 255.0f, 1);
        shapeRenderer.circle(bubble.getCircle().x, bubble.getCircle().y, bubble.getCircle().radius);
        shapeRenderer.end();
	}
}
