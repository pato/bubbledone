package com.bubbledone.main;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public final class AttractorRenderer {
	public static void render(BubbleWorld world, Attractor attractor, OrthographicCamera cam, ShapeRenderer shapeRenderer) {
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(255 / 255.0f, 87 / 255.0f, 34 / 255.0f, 1);
        shapeRenderer.ellipse(attractor.getX(), attractor.getY(), attractor.getRadius(), attractor.getRadius(), 1000);
		shapeRenderer.end();
	}
}
