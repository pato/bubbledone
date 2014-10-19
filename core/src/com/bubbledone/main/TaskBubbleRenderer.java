package com.bubbledone.main;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public final class TaskBubbleRenderer{
	public static void render(BubbleWorld world, TaskBubble bubble, OrthographicCamera cam, ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(83 / 255.0f, 109 / 255.0f, 254 / 255.0f, 1);
        shapeRenderer.ellipse(bubble.getX(), bubble.getY(),
        		bubble.getRadius(), bubble.getRadius(), 1000);
        shapeRenderer.end();
	}
}