package com.bubbledone.ui;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;
import com.bubbledone.main.Attractor;
import com.bubbledone.main.BubbleWorld;

public class CreateButtonRenderer {
	public static void render(BubbleWorld world, CreateButton button, OrthographicCamera cam, ShapeRenderer shapeRenderer) {
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(178 / 255.0f, 255 / 255.0f, 89 / 255.0f, 1);
		Vector3 v3 = cam.unproject(new Vector3(button.getX(), button.getY(), button.getRadius()));
        //shapeRenderer.ellipse(v3.x, v3.y, button.getRadius(), button.getRadius(), 1000);
        //shapeRenderer.ellipse(136, 194, button.getRadius(), button.getRadius(), 1000);
        shapeRenderer.ellipse(button.getX(), button.getY(), button.getRadius(), button.getRadius(), 1000);
		shapeRenderer.end();
	}
}
